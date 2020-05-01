package isp.lab3.exercise5;

public class Exercise5 {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(123);
        System.out.println(vendingMachine.displayCredit());
        System.out.println(vendingMachine.displayProducts());
        vendingMachine.initialize();
        System.out.println(vendingMachine.displayCredit());
        System.out.println(vendingMachine.displayProducts());
    }
}
