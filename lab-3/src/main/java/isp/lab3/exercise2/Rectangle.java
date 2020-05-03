package isp.lab3.exercise2;

public class Rectangle {
    private int length = 2;
    private int width = 1;
    private String color = "red";

    public Rectangle() {
        // just to provide access to the default constructor
    }

    /**
     * Constructor which sets the length and the width
     *
     * @param length to be set
     * @param width  to be set
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Constructor which sets the length, width and color
     *
     * @param length to be set
     * @param width  to be set
     * @param color  to be set
     */
    public Rectangle(int length, int width, String color) {
        this(length, width);
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    /**
     * Calculate and return the perimeter of the current rectangle
     *
     * @return the perimeter
     */
    public int getPerimeter() {
        return 2 * this.length + 2 * this.width;
    }

    /**
     * Calculate and return the area of the current rectangle
     *
     * @return the area
     */
    public int getArea() {
        return this.width * this.length;
    }
}
