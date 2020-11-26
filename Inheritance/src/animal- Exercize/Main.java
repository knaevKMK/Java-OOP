package animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String read;
        while (!"Beast!".equals(read = scanner.nextLine())) {
            String[] token = scanner.nextLine().split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            if (age < 0 || ((!token[2].equals("Male") && !token[2].equals("Female")))) {
                System.out.println("Invalid input!");
                continue;
            }
            String gender = token[2];

            Animal animal;
            switch (read) {
                case "Cat":
                    animal = new Cat(name, age, gender);
                    break;
                case "Dog":
                    animal = new Dog(name, age, gender);
                    break;
                case "Frog":
                    animal = new Frog(name, age, gender);
                    break;
                case "Tomcat":
                    animal = new Tomcat(gender, age);
                    break;
                case "Kitten":
                    animal = new Kitten(gender, age);
                    break;
                default:
                    throw new RuntimeException("Invalid input!");
            }
            System.out.println(animal);
        }
    }
}
