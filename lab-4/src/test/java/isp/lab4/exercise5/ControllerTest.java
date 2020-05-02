package isp.lab4.exercise5;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControllerTest {

    // NOTE: The tests for generated methods are omitted because are the same as for exercise 1 and exercise 2

    @Test
    public void testControlStep() {
        //given
        Controller controller = new Controller();

        //pre assert
        assertFalse("The alarm should be OFF because no logic was applied", controller.getFireAlarm().isActive());

        //when
        controller.controlStep();

        //post assert
        assertTrue("The alarm should be ON because at least one sensor have value greater than 50", controller.getFireAlarm().isActive());
    }
}