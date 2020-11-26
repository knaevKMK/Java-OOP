package Shapes;

public abstract class Shape implements IShape {
    private Double perimeter;
    private Double area;


    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public Double getArea() {
        return this.area;
    }

    @Override
    public Double getPerimeter() {
        return this.perimeter;
    }
}
