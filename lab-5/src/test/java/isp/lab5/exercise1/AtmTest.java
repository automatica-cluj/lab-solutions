package isp.lab5.exercise1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static isp.lab5.exercise1.Atm.INSERT_CARD_MESSAGE;
import static isp.lab5.exercise1.Exercise1.initializeAtm;
import static org.junit.Assert.*;

public class AtmTest {

    private static final String OLD_PIN = "oldPin";
    private static final String NEW_PIN = "newPin";
    private static final String CARD_NOT_INTRODUCE_MESSAGE = "There should be an error that the card was not inserted";
    private static final String CARD_SHOULD_BE_INTRODUCE_MESSAGE = "The card should be introduced successfully";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private Atm atm;

    @Before
    public void setUp() {
        atm = initializeAtm();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testChangePinWhenCardNotInserted() {
        atm.changePin(OLD_PIN, NEW_PIN);
        assertEquals(CARD_NOT_INTRODUCE_MESSAGE, INSERT_CARD_MESSAGE, outContent.toString().trim());
    }

    @Test
    public void testChangePinWhenCardInsertedAndWrongOldPin() {
        assertTrue(CARD_SHOULD_BE_INTRODUCE_MESSAGE, atm.insertCard(new Card("1", "2"), "2"));
        atm.changePin("0", NEW_PIN);
        assertEquals("There should be an error that the old pin is not the same as entered pin", "The old pin do not match the existing pin", outContent.toString().trim());
    }

    @Test
    public void testChangePinWhenCardInsertedAndGoodOldPin() {
        assertTrue(CARD_SHOULD_BE_INTRODUCE_MESSAGE, atm.insertCard(new Card("1", "2"), "2"));
        atm.changePin("2", NEW_PIN);
        assertEquals("There should be an success message as ping changed successfully", "Pin changed successfully", outContent.toString().trim());
    }

    @Test
    public void testWithdrawWhenCardNotInserted() {
        atm.withdraw(200D);
        assertEquals(CARD_NOT_INTRODUCE_MESSAGE, INSERT_CARD_MESSAGE, outContent.toString().trim());
    }

    @Test
    public void testWithdrawWhenCardInsertedButNotEnoughFounds() {
        assertTrue(CARD_SHOULD_BE_INTRODUCE_MESSAGE, atm.insertCard(new Card("1", "2"), "2"));
        atm.withdraw(20000D);
        assertEquals("There should be an error message as the requested amount is greater than the current balance", "The amount is bigger than account balance", outContent.toString().trim());
    }

    @Test
    public void testWithdrawWhenCardInsertedAndEnoughFounds() {
        assertTrue(CARD_SHOULD_BE_INTRODUCE_MESSAGE, atm.insertCard(new Card("1", "2"), "2"));
        atm.withdraw(20D);
        assertEquals("There should be an success message as the transaction is executed successfully", "The amount withdrawn is " + 20D + " and the remaining balance is " + atm.getBank().getAccountByCardId("1").getBalance(), outContent.toString().trim());
        assertEquals("The balance should be reduced by 20.0", 980D, atm.getBank().getAccountByCardId("1").getBalance(), 0);
    }

    @Test
    public void testCheckMoneyWhenCardNotIntroduced() {
        atm.checkMoney();
        assertEquals(CARD_NOT_INTRODUCE_MESSAGE, INSERT_CARD_MESSAGE, outContent.toString().trim());
    }

    @Test
    public void testCheckMoneyWhenCardIntroduced() {
        assertTrue(CARD_SHOULD_BE_INTRODUCE_MESSAGE, atm.insertCard(new Card("1", "2"), "2"));
        atm.checkMoney();
        assertEquals("There should be an success message as the transaction is executed successfully", "The current balance is " + atm.getBank().getAccountByCardId("1").getBalance(), outContent.toString().trim());
    }

    @Test
    public void testInsertCardSuccessfully() {
        assertTrue(atm.insertCard(new Card("1", "2"), "2"));
        assertEquals("The introduced card should be tha same", new Card("1", "2"), atm.getCard());
    }

    @Test
    public void testInsertCardWhenCardAlreadyInserted() {
        if (atm.insertCard(new Card("1", "2"), "2")) {
            assertFalse(atm.insertCard(new Card("2", "4"), "4"));
            assertEquals("There should be an error message as a card is already inserted", "Card already inserted", outContent.toString().trim());
            assertEquals("The old card should be the same",new Card("1", "2"), atm.getCard());
        } else {
            fail(CARD_SHOULD_BE_INTRODUCE_MESSAGE);
        }
    }

    @Test
    public void testInsertCardWhenWrongPin() {
        assertFalse(atm.insertCard(new Card("1", "2"), "anyWrongPin"));
    }

    @Test
    public void testRemoveCardWhenNoCardInserted() {
        atm.removeCard();
        assertNull("The card should be null as it was removed", atm.getCard());
    }

    @Test
    public void testRemoveCardWhenCardAlreadyInserted() {
        if (atm.insertCard(new Card("1", "2"), "2")) {
            assertNotNull("The card should not be null as it was inserted successfully", atm.getCard());
            atm.removeCard();
            assertNull("The card should be null as it was removed", atm.getCard());
        } else {
            fail(CARD_SHOULD_BE_INTRODUCE_MESSAGE);
        }
    }
}