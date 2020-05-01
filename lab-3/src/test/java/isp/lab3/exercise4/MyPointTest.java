package isp.lab3.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {
    MyPoint point;

    @Before
    public void setup() {
        point = new MyPoint(2, 3, 4);
    }

    @Test
    public void testSetXYZ() {
        assertEquals(2, point.getX());
        assertEquals(3, point.getY());
        assertEquals(4, point.getZ());

        point.setXYZ(5, 6, 7);

        assertEquals(5, point.getX());
        assertEquals(6, point.getY());
        assertEquals(7, point.getZ());
    }

    @Test
    public void testDistance() {
        assertEquals(5.196, point.distance(5, 6, 7), 0.001);

    }

    @Test
    public void testDistance1() {
        assertEquals(5.196, point.distance(new MyPoint(5, 6, 7)), 0.001);
    }
}