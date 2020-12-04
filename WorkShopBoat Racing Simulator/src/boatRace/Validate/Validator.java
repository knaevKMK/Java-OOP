package boatRace.Validate;

public class Validator {
    private Validator() {

    }


    public static void validateInteger(int value, String prefix) {
        if (value <= 0) {
            throw new IllegalArgumentException(prefix + " must be a positive integer.");
        }
    }


    public static void validateModelBoat(String model) {
        if (model.length() <= 5) {
            throw new IllegalArgumentException("Model's name must be at least 5 symbols long.");
        }
    }

    public static void validateEngineModel(String model) {
        if (model.length() < 3) {
            throw new IllegalArgumentException("Model's name must be at least 3 symbols long.");
        }
    }
}
