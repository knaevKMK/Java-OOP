package PizzaCalories;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] token = scanner.nextLine().split("\\s+");
        try {
            Pizza pizza = new Pizza(token[1], Integer.parseInt(token[2]));
            token = scanner.nextLine().split("\\s+");
            pizza.setDough(new Dough(token[1], token[2], Double.parseDouble(token[3])));
            String read;
            while (!"END".equals(read = scanner.nextLine())) {
                token = read.split("\\s+");
                pizza.addTopping(new Topping(token[1], Double.parseDouble(token[2])));
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
