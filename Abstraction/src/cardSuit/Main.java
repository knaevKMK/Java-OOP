package cardSuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");
        for (int i = 0; i < CardSuit.values().length; i++) {
            CardSuit card = CardSuit.values()[i];
            System.out.println(String.format("Ordinal value: %d; Name value: %s", card.getValue(), card));
        }

    }
}
