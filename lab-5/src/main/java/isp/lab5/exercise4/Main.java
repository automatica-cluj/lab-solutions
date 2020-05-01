package isp.lab5.exercise4;

public class Main {
    public static void main(String[] args) {
        AbstractShapeFactory roundedShapeFactory = ShapeFactoryProvider.getShapeFactory("rounded");
        AbstractShapeFactory normalShapeFactory = ShapeFactoryProvider.getShapeFactory("normal");

        // create instances
        Shape roundedRectangle = roundedShapeFactory.getShape("roundedRectangle");
        Shape rectangle = normalShapeFactory.getShape("rectangle");
        Shape roundedSquare = roundedShapeFactory.getShape("roundedSquare");
        Shape square = normalShapeFactory.getShape("square");

        roundedRectangle.draw();
        rectangle.draw();
        roundedSquare.draw();
        square.draw();
    }
}
