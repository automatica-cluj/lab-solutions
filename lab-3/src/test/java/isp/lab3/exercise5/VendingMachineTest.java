package isp.lab3.exercise5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testConstructor() {
        assertEquals("The credit should be 0 at creation of vending machine", 0, vendingMachine.displayCredit(), 0);
        assertArrayEquals("The following products should be in vending machine \"Cola\", \"Sprite\", \"Fanta\", \"Mirinda\", \"Schweppes\"", new String[]{"Cola", "Sprite", "Fanta", "Mirinda", "Schweppes"}, vendingMachine.getProducts());
        assertArrayEquals("The following prices should be in vending machine \"4.00\", \"4.50\", \"4.50\", \"3.50\", \"5.00\"", new double[]{4.00D, 4.50D, 4.50D, 3.50D, 5.00D}, vendingMachine.getPrices(), 0);
    }

    @Test
    public void testSelectProductWhichDoesNotExist() {
        assertEquals("There should be an error message as the product does not exist", "The product with id: 10 is not available", vendingMachine.selectProduct(10));
    }

    @Test
    public void testSelectProductWithInsufficientFounds() {
        assertEquals("There should be an error message as there are insufficient founds", "Insufficient founds", vendingMachine.selectProduct(1));
    }

    @Test
    public void testSelectProductWithEnoughFounds() {
        vendingMachine.insertCoin(20D);
        assertEquals("There should be the name of the product", "Sprite", vendingMachine.selectProduct(1));
    }

    @Test
    public void testInsertCoin() {
        assertEquals(0, vendingMachine.displayCredit(), 0.01);

        vendingMachine.insertCoin(5);
        assertEquals(5, vendingMachine.displayCredit(), 0.01);

        vendingMachine.insertCoin(-1);
        assertEquals(5, vendingMachine.displayCredit(), 0.01);
    }

    @Test
    public void testDisplayProducts() {
        assertEquals("The products should be displayed in a proper format", "0 Cola -> 4.0\n" +
                "1 Sprite -> 4.5\n" +
                "2 Fanta -> 4.5\n" +
                "3 Mirinda -> 3.5\n" +
                "4 Schweppes -> 5.0\n", vendingMachine.displayProducts());
    }

    @Test
    public void testUserMenu() {
        assertEquals("The user menu should be displayed in a proper format", "1 -> Display credit\n2 -> Select product by id\n3 -> Insert coin \n4 -> Display products \n5 -> Exit\n", vendingMachine.userMenu());
    }
}