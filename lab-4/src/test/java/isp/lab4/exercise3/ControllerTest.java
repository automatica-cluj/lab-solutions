package isp.lab4.exercise3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    // NOTE: The tests for generated methods are omitted because are the same as for exercise 1 and exercise 2

    @Test
    public void testControlStepWhenTemperatureSensorValueIsLowerThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(24, "living-room");
        Controller controller = new Controller();
        controller.setFireAlarm(fireAlarm);
        controller.setTemperatureSensor(temperatureSensor);

        //pre assert
        assertFalse("The fire alarm should be OFF because no change was made", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertFalse("The fire alarm should be OFF because the value of the temperature sensor is lower than 50", fireAlarm.isActive());
    }

    @Test
    public void testControlStepWhenTemperatureSensorValueIsGreaterThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(64, "bath-room");
        Controller controller = new Controller();
        controller.setFireAlarm(fireAlarm);
        controller.setTemperatureSensor(temperatureSensor);

        //pre assert
        assertFalse("The fire alarm should be OFF because no change was made", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertTrue("The fire alarm should be ON because the value of the temperature sensor is greater than 50", fireAlarm.isActive());
    }
}