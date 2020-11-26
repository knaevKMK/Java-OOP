package pointInRectangle;

public class Rectangle {
    private static Point bottomLeft;
    private static Point topRgiht;

    public Rectangle(Point bottomLeft, Point topRgiht) {
        this.bottomLeft = bottomLeft;
        this.topRgiht = topRgiht;
    }

    public static boolean contains(Point point) {
        return point.getX() >= bottomLeft.getX()
                && point.getX() <= topRgiht.getX()
                && point.getY() <= topRgiht.getY()
                && point.getY() >= bottomLeft.getY();
    }
}
