package Shapes;

public class Validation {
    public static void checkSide(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be positive number");
        }
    }
}
