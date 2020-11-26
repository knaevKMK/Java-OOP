package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "Exit":
                    return;
                case "Create":
                    studentSystem.create(input);
                    break;
                case "Show":
                    System.out.print(studentSystem.show(input[1]));
                    break;


            }

        }
    }
}
