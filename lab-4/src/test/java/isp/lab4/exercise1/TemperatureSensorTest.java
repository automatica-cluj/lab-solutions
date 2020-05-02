package isp.lab4.exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TemperatureSensorTest {
    TemperatureSensor temperatureSensor;

    @Before
    public void setUP() {
        temperatureSensor = new TemperatureSensor(25, "kitchen");
    }

    @Test
    public void testDefaultConstructor() {
        TemperatureSensor temperatureSensor1 = new TemperatureSensor();
        assertEquals("The default value should be 0", 0, temperatureSensor1.getValue());
        assertNull("The default location should be null", temperatureSensor1.getLocation());
    }

    @Test
    public void testGetValue() {
        assertEquals("The values should be 25", 25, temperatureSensor.getValue());
    }

    @Test
    public void testGetLocation() {
        assertEquals("The location should be kitchen", "kitchen", temperatureSensor.getLocation());
    }

    @Test
    public void testToString() {
        assertEquals("The toString method should have the default implementation", "TemperatureSensor{" + "value=" + temperatureSensor.getValue() + ", location='" + temperatureSensor.getLocation() + '\'' + '}', temperatureSensor.toString());
    }
}