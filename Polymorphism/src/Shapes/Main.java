package Shapes;

public class Main {
    public static void main(String[] args) {
        try {
            Shape circle = new Circle(4.0);

        //   System.out.println(circle.getPerimeter());
            System.out.println(circle.getPerimeter());
            System.out.println(circle.getArea());
           Shape rectangle = new Rectangle(4, 2);
        //    System.out.println(rectangle.calculateArea());
        //    System.out.println(rectangle.getPerimeter());
            System.out.println(rectangle.getPerimeter());
            System.out.println(rectangle.getArea());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
