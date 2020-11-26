package GreedyTimes;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bag bag = new Bag(Long.parseLong(scanner.nextLine()));
        bag.addInBag(scanner.nextLine());
        System.out.println(bag);
    }
}
