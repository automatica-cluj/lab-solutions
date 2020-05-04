package isp.lab5.exercise1;

import org.junit.Test;

import static isp.lab5.exercise1.Exercise1.initializeAtm;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BankTest {

    @Test
    public void testGetAccountByCardIdSuccessfully() {
        //given
        Atm atm = initializeAtm();

        //when
        Account account = atm.getBank().getAccountByCardId("1");

        // then
        assertNotNull("The account should not be null", account);

    }

    @Test
    public void testGetAccountByCardIdErrorBecauseCardIdNotInBank() {
        //given
        Atm atm = initializeAtm();

        //when
        Account account = atm.getBank().getAccountByCardId("222");

        // then
        assertNull("The account should be null because the cardID is not in the bank", account);
    }

    @Test
    public void testGetAccountByCardIdErrorBecauseAccountsAreNull() {
        //given
        Atm atm = new Atm(new Bank(null));

        //when
        Account account = atm.getBank().getAccountByCardId("1");

        // then
        assertNull("The account should be null because accounts are null", account);
    }
}