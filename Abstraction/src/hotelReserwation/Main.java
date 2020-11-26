package hotelReserwation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] read = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(read[0]);
        int day = Integer.parseInt(read[1]);
        PriceCalculator.Season season1 = PriceCalculator.Season.valueOf(read[2].toUpperCase());

        PriceCalculator priceCalculator = new PriceCalculator(PriceCalculator.Season.valueOf(read[2].toUpperCase()),
                PriceCalculator.Discount.valueOf(read[3].toUpperCase()), day, price);

        System.out.printf("%.2f", priceCalculator.calculatePrice());


    }
}
