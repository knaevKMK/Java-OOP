package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void checkValue(double value, String prefix) {
        if (value <= 0) {
            throw new IllegalArgumentException(prefix + " cannot be zero or negative.");
        }
    }

    private void setLength(double length) {
        checkValue(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkValue(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkValue(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.height * this.length + 2 * this.height * this.width;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.height * this.length + 2 * this.height * this.width;
    }

    public double calculateVolume() {
        return this.height * this.length * this.width;
    }
}

