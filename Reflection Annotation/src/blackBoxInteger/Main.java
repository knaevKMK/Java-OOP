package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Class<?> demo = BlackBoxInt.class;
        BlackBoxInt blackBoxInt;
        try {
            Constructor<?> constructor = demo.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) constructor.newInstance(0);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalArgumentException(e.getMessage());
        }


        String read;
        while (!"END".equalsIgnoreCase(read = scanner.nextLine())) {
            String[] token = read.split("_");
            String methodRead = token[0];
            int value = Integer.parseInt(token[1]);
            try {
                Method method = demo.getDeclaredMethod(methodRead, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);
                Field field = demo.getDeclaredField("innerValue");
                field.setAccessible(true);
                System.out.println(field.get(blackBoxInt));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }

        }
    }
}
