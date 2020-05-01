package isp.lab3.exercise2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    Rectangle rectangle1;
    Rectangle rectangle2;

    @Before
    public void setup() {
        rectangle1 = new Rectangle(8, 9);
        rectangle2 = new Rectangle(6, 7, "green");
    }

    @Test
    public void testGetLength() {
        assertEquals(8, rectangle1.getLength());
        assertEquals(6, rectangle2.getLength());
    }

    @Test
    public void testGetWidth() {
        assertEquals(9, rectangle1.getWidth());
        assertEquals(7, rectangle2.getWidth());
    }

    @Test
    public void tetGetColor() {
        assertEquals("red", rectangle1.getColor());
        assertEquals("green", rectangle2.getColor());
    }

    @Test
    public void tetGetPerimeter() {
        assertEquals(8 + 8 + 9 + 9, rectangle1.getPerimeter());
        assertEquals(6 + 6 + 7 + 7, rectangle2.getPerimeter());
    }

    @Test
    public void tetGetArea() {
        assertEquals(8 * 9, rectangle1.getArea());
        assertEquals(6 * 7, rectangle2.getArea());
    }
}