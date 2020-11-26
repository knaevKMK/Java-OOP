package Shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }


    @Override
    public Double calculatePerimeter() {
        return 2 * this.height + 2 * this.width;
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }


}
