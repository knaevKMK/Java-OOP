package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

public class Command implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    public Command(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public Command() {
    }


    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable;
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring((1));
        try {
            Class<? extends Executable> temp = (Class<? extends Executable>) Class.forName("barracksWars.models.units." + commandName);
            Constructor<? extends Executable> constructor = temp.getDeclaredConstructor();
            executable = constructor.newInstance();
            injectFields(executable, data);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        return executable;
    }

    private void injectFields(Executable executable, String[] data) {
        try {
            Field[] fields = executable.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == String[].class) {
                    field.set(executable, data);
                } else if (field.getType() == Repository.class) {
                    field.set(executable, repository);
                } else if (field.getType() == UnitFactory.class) {
                    field.set(executable, unitFactory);
                }
            }
        } catch (Exception ignored) {
        }
    }
}

