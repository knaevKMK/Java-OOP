package Lab;

import Demo.Authour;
import Demo.Tracker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    @Authour(name = "Knev")
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Tracker.printMethodsByAuthor(Tracker.class);
        Scanner scanner = new Scanner(System.in);
        Class<Reflection> reflection = Reflection.class;

        Comparator<Field> comparatorField = (m1, m2) -> m1.getName().compareTo(m2.getName());
        //  Field[] fields
        Arrays.stream(reflection.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(comparatorField)
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Comparator<Method> comparator = (m1, m2) -> m1.getName().compareTo(m2.getName());

        //      List<Method> getters =
        Arrays.stream(reflection.getDeclaredMethods())
                .filter(g -> g.getName().startsWith("get") && g.getParameterCount() == 0 && g.getReturnType() != void.class && !Modifier.isPublic(g.getModifiers()))
                .sorted(comparator)
                .forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        //      List<Method> setters =
        Arrays.stream(reflection.getMethods())
                .filter(s -> s.getName().startsWith("set") && s.getParameterCount() == 1 && s.getReturnType() == void.class && !Modifier.isPrivate(s.getModifiers()))
                .sorted(comparator)
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }
}
