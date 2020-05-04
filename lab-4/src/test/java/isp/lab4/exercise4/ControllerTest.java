package isp.lab4.exercise4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    // NOTE: The tests for generated methods are omitted because are the same as for exercise 1 and exercise 2

    @Test
    public void testControlStepWhenAllSensorsValuesAreLowerThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(24, "living room");
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(34, "bathroom");
        TemperatureSensor temperatureSensor3 = new TemperatureSensor(44, "kitchen");
        Controller controller = new Controller(new TemperatureSensor[]{temperatureSensor, temperatureSensor2, temperatureSensor3}, fireAlarm);

        //pre assert
        assertFalse("The fire alarm should be OFF because there was no logic applied", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertFalse("The fire alarm should be OFF because not all sensors have values greater than 50", fireAlarm.isActive());
    }

    @Test
    public void testControlStepWhenOneSensorValueIsGreaterThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(54, "living room");
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(34, "bathroom");
        TemperatureSensor temperatureSensor3 = new TemperatureSensor(44, "kitchen");
        Controller controller = new Controller(new TemperatureSensor[]{temperatureSensor, temperatureSensor2, temperatureSensor3}, fireAlarm);

        //pre assert
        assertFalse("The fire alarm should be OFF because there was no logic applied", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertFalse("The fire alarm should be OFF because not all sensors have values greater than 50", fireAlarm.isActive());
    }

    @Test
    public void testControlStepWhenOneSensorValueIsLowerThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(24, "living room");
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(56, "bathroom");
        TemperatureSensor temperatureSensor3 = new TemperatureSensor(69, "kitchen");
        Controller controller = new Controller(new TemperatureSensor[]{temperatureSensor, temperatureSensor2, temperatureSensor3}, fireAlarm);

        //pre assert
        assertFalse("The fire alarm should be OFF because there was no logic applied", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertFalse("The fire alarm should be OFF because not all sensors have values greater than 50", fireAlarm.isActive());
    }

    @Test
    public void testControlStepWhenAllSensorsValuesAreGreaterThan50() {
        // given
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(89, "living room");
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(85, "bathroom");
        TemperatureSensor temperatureSensor3 = new TemperatureSensor(67, "kitchen");
        Controller controller = new Controller(new TemperatureSensor[]{temperatureSensor, temperatureSensor2, temperatureSensor3}, fireAlarm);

        //pre assert
        assertFalse("The fire alarm should be OFF because there was no logic applied", fireAlarm.isActive());

        //when
        controller.controlStep();

        //post assert
        assertTrue("The fire alarm should be ON because all sensors have values greater than 50", fireAlarm.isActive());
    }
}