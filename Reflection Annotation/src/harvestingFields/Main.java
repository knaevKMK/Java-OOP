package harvestingFields;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
             Class<?> demo = RichSoilLand.class;

        Field[] fields = demo.getDeclaredFields();
        Consumer<Field> print = f -> System.out.printf("%s %s %s%n"
              //  , f.toString().substring(0, f.toString().indexOf(" "))
                ,Modifier.toString(f.getModifiers())
                , f.getType().getSimpleName()
                , f.getName());
        Predicate<Field> predicate = null;
        String read;
        while (!"HARVEST".equalsIgnoreCase(read = scanner.nextLine())) {
            switch (read) {
                case "protected":
                    predicate = f -> Modifier.isProtected(f.getModifiers());
                    break;
                case "private":
                    predicate = f -> Modifier.isPrivate(f.getModifiers());
                    break;
                case "public":
                    predicate = f -> Modifier.isPublic(f.getModifiers());
                    break;
                case "all":
                    Arrays.stream(fields).forEach(print);
                    continue;
                default:
                    throw new IllegalArgumentException("Invalid access Modifier");
            }
            try {
                Arrays.stream(fields)
                        .filter(predicate)
                        .forEach(print);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
