package c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class getClassWithChildClass {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException {
        String read = scanner.nextLine();

        Class<?> clazz = Class.forName(read);
        Class<?>[] clazzClasses = clazz.getClasses();
        for (Class<?> clazzClass : clazzClasses) {
            System.out.println(clazzClass.getSimpleName());
        }


    }
}
