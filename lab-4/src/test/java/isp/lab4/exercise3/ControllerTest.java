package isp.lab4.exercise3;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class tests more than just the {@link Controller}
 */
public class ControllerTest {


    /**
     * This method test more than just the controlStep()
     */
    @Test
    public void testControlStep() {
        Controller controller = new Controller();

        FireAlarm fireAlarm = new FireAlarm(false);
        assertFalse(fireAlarm.isActive());

        TemperatureSensor temperatureSensor = new TemperatureSensor(24, "living-room");
        assertEquals(24, temperatureSensor.getValue(),0.1);
        assertEquals("living-room", temperatureSensor.getLocation());

        controller.setFireAlarm(fireAlarm);
        controller.setTemperatureSensor(temperatureSensor);

        assertFalse(fireAlarm.isActive());
        controller.controlStep();
        assertFalse(fireAlarm.isActive());

        TemperatureSensor temperatureSensor1 = new TemperatureSensor(64, "bath-room");
        assertEquals(64, temperatureSensor1.getValue(),0.1);
        assertEquals("bath-room", temperatureSensor1.getLocation());

        controller.setTemperatureSensor(temperatureSensor1);

        assertFalse(fireAlarm.isActive());
        controller.controlStep();
        assertTrue(fireAlarm.isActive());
    }
}