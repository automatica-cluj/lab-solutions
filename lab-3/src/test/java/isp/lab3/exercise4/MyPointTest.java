package isp.lab3.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {
    MyPoint point;


    @Before
    public void setUp() {
        point = new MyPoint(2, 3, 4);

    }

    @Test
    public void testDefaultConstructor() {
        MyPoint point1 = new MyPoint();

        assertEquals("The default x coordinate should be 0", 0, point1.getX());
        assertEquals("The default y coordinate should be 0", 0, point1.getY());
        assertEquals("The default z coordinate should be 0", 0, point1.getZ());
    }

    @Test
    public void testSetXYZ() {
        assertEquals("The x coordinate should be 2", 2, point.getX());
        assertEquals("The y coordinate should be 3", 3, point.getY());
        assertEquals("The z coordinate should be 4", 4, point.getZ());

        point.setXYZ(5, 6, 7);

        assertEquals("The x coordinate should be 5", 5, point.getX());
        assertEquals("The y coordinate should be 6", 6, point.getY());
        assertEquals("The z coordinate should be 7", 7, point.getZ());
    }

    @Test
    public void testDistance() {
        assertEquals("The distance between the current point and the given coordinates should be 5.196", 5.196, point.distance(5, 6, 7), 0);

    }

    @Test
    public void testDistance1() {
        assertEquals("The distance between the current point and another point should be 5.196", 5.196, point.distance(new MyPoint(5, 6, 7)), 0);
    }

    @Test
    public void testToString() {
        assertEquals("the toString method should have the proper format", "(" + point.getX() + "," + point.getY() + "," + point.getZ() + ")", point.toString());
    }
}