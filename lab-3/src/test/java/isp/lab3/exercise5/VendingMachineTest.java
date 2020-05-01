package isp.lab3.exercise5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    @Test
    public void testSelectProduct() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals("The product with id: 1 is not available", vendingMachine.selectProduct(1));
        vendingMachine.initialize();
        assertEquals("Apple: 1", vendingMachine.selectProduct(1));
    }

    @Test
    public void testInsertCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(0, vendingMachine.displayCredit());
        vendingMachine.insertCoin(5);
        assertEquals(5, vendingMachine.displayCredit());
    }

    @Test
    public void testDisplayProducts() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals("[]", vendingMachine.displayProducts());
        vendingMachine.initialize();
        assertEquals("[Apple: 1, Cola: 2, Sprite: 3, 7 Days: 4, Water: 5, Snickers: 6, Rafaelo: 7]", vendingMachine.displayProducts());
    }
}