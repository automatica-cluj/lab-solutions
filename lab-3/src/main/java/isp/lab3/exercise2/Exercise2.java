package isp.lab3.exercise2;

public class Exercise2 {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println("First rectangle:");
        printRectangleDetails(rectangle);

        Rectangle rectangle1 = new Rectangle(4, 5);
        System.out.println("Second rectangle:");
        printRectangleDetails(rectangle1);

        Rectangle rectangle2 = new Rectangle(2, 3, "blue");
        System.out.println("Third rectangle:");
        printRectangleDetails(rectangle2);
    }

    /**
     * Method which prints the details about a given {@link Rectangle}
     *
     * @param rectangle the given {@link Rectangle} to print details
     */
    private static void printRectangleDetails(Rectangle rectangle) {
        System.out.println("Color: " + rectangle.getColor());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println("Area: " + rectangle.getArea());
    }
}
