package isp.lab3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author mihai.hulea
 */
public class ExampleTest {

    @Test
    public void testAdd() {
        assertEquals("Should add 2 numbers", 30, Example.add(10, 20));
    }

    @Test
    public void testSubstract() {
        assertEquals("Should substract 2 numbers", 5, Example.substract(15, 10));
    }

}
