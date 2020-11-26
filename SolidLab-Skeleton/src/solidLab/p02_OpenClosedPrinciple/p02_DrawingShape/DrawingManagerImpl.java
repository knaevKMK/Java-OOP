package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {
        if (shape instanceof Circle) {
            this.drawCircle((Circle) shape);
        } else if (shape instanceof Rectangle) {
            this.drawRectangle(((Rectangle) shape));
        }else if (shape instanceof Triangle) {
            this.drawTriangle(((Triangle) shape));
        }
    }

    public void drawCircle(Circle circle) {
        circle.draw();
    }

    public void drawRectangle(Rectangle rectangle) {
        rectangle.draw();
    }

    public void drawTriangle(Triangle tringle) {
        tringle.draw();
    }
}
