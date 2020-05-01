package isp.lab8.safehome;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SafeHomeTest {

    ControllerInterface ctrl;

    @Before
    public void instantiateDoorController() {
        //INITIALISE CONTROLLER OBJECT HERE
        ctrl = new DoorLockController(new Door(), new ArrayList<>());
    }

    // >>>> DO NOT CHANGE CODE AFTER THIS LINE ! <<<<

    @Test
    public void whenCorrectPinDoorOpen() throws Exception {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        assertEquals("Door status should be OPEN", DoorStatus.OPEN, ctrl.enterPin("12345"));
    }

    @Test
    public void whenWrongPinThrowInvalidPinException() {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        try {
            ctrl.enterPin("4532");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "InvalidPinException");
        }
    }

    @Test
    public void whenTooManyAttemptsThrowTooManyAttemptsException() {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        for (int i = 0; i < 2; i++) {
            try {
                ctrl.enterPin("4532");
                fail("Exception should be thrown!");
            } catch (Exception e) {
                System.out.println("Attempt " + i);
                assertExceptionType(e, "InvalidPinException");
            }
        }//.for

        try {
            ctrl.enterPin("4532");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "TooManyAttemptsException");
        }
    }

    @Test
    public void whenTooManyAttemptsDoorPermanentlyLocked() {
        try {
            ctrl.addTenant("1234", "User1");
        } catch (Exception ex) {
            fail("No exception should be thrown ");
        }

        int errCount = 0;
        for (int i = 0; i < 2; i++) {
            try {
                ctrl.enterPin("4532");
                fail("Exception should be thrown!");
            } catch (Exception e) {
                assertExceptionType(e, "InvalidPinException");
            }
        }//.for


        // too many attempts exception with wrong pin
        try {
            ctrl.enterPin("4532");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "TooManyAttemptsException");
        }

        // too many attempts with correct pin
        try {
            ctrl.enterPin("1234");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "TooManyAttemptsException");
        }
    }

    @Test
    public void whenDoorPermanentlyLockedAndMasterKeyIsUsedThanRetriesCountShouldBeReset() throws Exception {
        try {
            ctrl.addTenant("1234", "User1");
        } catch (Exception ex) {
            fail("No exception should be thrown ");
        }

        for (int i = 0; i < 2; i++) {
            try {
                ctrl.enterPin("4532");
                fail("Exception should be thrown!");
            } catch (Exception e) {
                System.out.println("Attempt " + i);
                assertExceptionType(e, "InvalidPinException");
            }
        }//.for

        try {
            ctrl.enterPin("4532");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "TooManyAttemptsException");
        }

        // use master key
        assertEquals("Status should be OPEN", DoorStatus.OPEN, ctrl.enterPin(ControllerInterface.MASTER_KEY));

        // old tenant can use now the key again
        assertEquals("Status should be CLOSE", DoorStatus.CLOSE, ctrl.enterPin("1234"));
    }

    @Test
    public void whenEnterPinDoorRevertStatus() throws Exception {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        assertEquals("Status should be OPEN", DoorStatus.OPEN, ctrl.enterPin("12345"));
        assertEquals("Status should be CLOSE", DoorStatus.CLOSE, ctrl.enterPin("12345"));
        assertEquals("Status should be OPEN", DoorStatus.OPEN, ctrl.enterPin("12345"));
        assertEquals("Status should be CLOSE", DoorStatus.CLOSE, ctrl.enterPin("12345"));
    }

    @Test
    public void whenTenantDoesNotExistThanTenantIsAdded() throws Exception {
        ctrl.addTenant("12345", "User1");
        assertEquals("Door status should be OPEN", DoorStatus.OPEN, ctrl.enterPin("12345"));
    }

    @Test
    public void whenTenantAlreadyExistsThanExceptionShouldBeThrown() {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        try {
            ctrl.addTenant("12345", "User1");
            fail("Exception should be thrown!");
        } catch (Exception ex) {
            assertExceptionType(ex, "TenantAlreadyExistsException");
        }
    }

    @Test
    public void whenTenantNotFoundThanRemoveTenantThrowsException() {
        try {
            ctrl.removeTenant("User1");
            fail("Exception should be thrown!");
        } catch (Exception ex) {
            assertExceptionType(ex, "TenantNotFoundException");
        }
    }

    @Test
    public void whenTenantRemovedAccessIsAlsoRemoved() throws Exception {
        try {
            ctrl.addTenant("12345", "User1");
        } catch (Exception ex) {
            fail("No exception should be added while creating new tenant");
        }

        assertEquals(DoorStatus.OPEN, ctrl.enterPin("12345"));
        ctrl.removeTenant("User1");
        try {
            ctrl.enterPin("12345");
            fail("Exception should be thrown!");
        } catch (Exception e) {
            assertExceptionType(e, "InvalidPinException");
        }
    }

    private void assertExceptionType(final Exception ex, final String expectedExceptionName) {
        assertTrue("Wrong exception name.", ex.getClass().getCanonicalName().indexOf(expectedExceptionName) != -1);
    }
}
