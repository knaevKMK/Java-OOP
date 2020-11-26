package rhombus;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());

        Rombus rombus = new Rombus(n);
        rombus.create();
//        printTop(n);
//        printBottom(n);

    }

    private static void printBottom(int n) {
        for (int i = 1; i < n; i++) {
            printRow(" ", i);
            printRow("* ", n - i);
            System.out.println();
        }
    }

    private static void printTop(int n) {
        for (int i = 1; i <= n; i++) {
            printRow(" ", n - i);
            printRow("* ", i);
            System.out.println();
        }
    }

    private static void printRow(String s, int end) {
        for (int j = 1; j <= end; j++) {
            System.out.print(s);
        }
    }
}
