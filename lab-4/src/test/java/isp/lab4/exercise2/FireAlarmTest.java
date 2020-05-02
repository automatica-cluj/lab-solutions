package isp.lab4.exercise2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FireAlarmTest {
    FireAlarm fireAlarm;

    @Before
    public void setUP() {
        fireAlarm = new FireAlarm(false);
    }

    @Test
    public void testIsActive() {
        assertFalse("The alarm should be OFF", fireAlarm.isActive());
    }

    @Test
    public void testSetActive() {
        assertFalse("The alarm should be OFF", fireAlarm.isActive());
        fireAlarm.setActive(true);
        assertTrue("The alarm should be ON", fireAlarm.isActive());
    }

    @Test
    public void testToString() {
        assertEquals("The toString method should have the default implementation", "FireAlarm{" + "active=" + fireAlarm.isActive() + '}', fireAlarm.toString());
    }
}