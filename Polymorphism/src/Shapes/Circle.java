package Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(double radius) {
        this.radius = radius;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {

        return 2 * Math.PI * this.radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
