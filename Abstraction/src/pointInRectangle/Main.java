package pointInRectangle;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Rectangle rectangle= new Rectangle(new Point(scanner.nextInt(), scanner.nextInt()),
                new Point(scanner.nextInt(), scanner.nextInt()));
        scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(Rectangle.contains(new Point(scanner.nextInt(), scanner.nextInt())));
        }
    }
}
