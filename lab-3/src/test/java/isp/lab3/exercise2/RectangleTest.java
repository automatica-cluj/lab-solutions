package isp.lab3.exercise2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    Rectangle rectangle1;
    Rectangle rectangle2;

    @Before
    public void setUP() {
        rectangle1 = new Rectangle(8, 9);
        rectangle2 = new Rectangle(6, 7, "green");
    }

    @Test
    public void testGetLength() {
        assertEquals("The length of the rectangle should be 8", 8, rectangle1.getLength());
        assertEquals("The length of the rectangle should be 6", 6, rectangle2.getLength());
    }

    @Test
    public void testGetWidth() {
        assertEquals("The width of the rectangle should be 9", 9, rectangle1.getWidth());
        assertEquals("The width of the rectangle should be 7", 7, rectangle2.getWidth());
    }

    @Test
    public void tetGetColor() {
        assertEquals("The color of the rectangle should be \"red\" (the default one)", "red", rectangle1.getColor());
        assertEquals("The color of the rectangle should be \"green\"", "green", rectangle2.getColor());
    }

    @Test
    public void tetGetPerimeter() {
        assertEquals("The perimeter of the rectangle should be 34", 8 + 8 + 9 + 9, rectangle1.getPerimeter());
        assertEquals("The perimeter of the rectangle should be 26", 6 + 6 + 7 + 7, rectangle2.getPerimeter());
    }

    @Test
    public void tetGetArea() {
        assertEquals("The area of the rectangle should be 72", 8 * 9, rectangle1.getArea());
        assertEquals("The area of the rectangle should be 42", 6 * 7, rectangle2.getArea());
    }
}