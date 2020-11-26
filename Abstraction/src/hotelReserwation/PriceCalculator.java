package hotelReserwation;

public class PriceCalculator {
    private Season season;
    private Discount discount;
    private int day;
    private double price;

    public PriceCalculator(Season season, Discount discount, int day, double price) {
        this.season = season;
        this.discount = discount;
        this.day = day;
        this.price = price;
    }

    public double calculatePrice() {
        return this.price * this.day * this.season.getCode() * (1 - this.discount.getValue() / 100.00);
    }


    public enum Season {
        AUTUMN(1),
        SPRING(2),
        WINTER(3),
        SUMMER(4);
        int code;

        Season(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum Discount {
        NONE(0),
        SECONDVISIT(10),
        VIP(20);
        int value;

        Discount(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }
    }
}
