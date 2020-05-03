package isp.lab3.exercise5;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        boolean interactingWithUser = true;
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
        while (interactingWithUser) {
            System.out.println(vendingMachine.userMenu());
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Current credit is " + vendingMachine.displayCredit());
                    break;
                case 2:
                    System.out.println("insert product id");
                    System.out.println(vendingMachine.selectProduct(scanner.nextInt()));
                    break;
                case 3:
                    System.out.println("select the amount you want to enter");
                    vendingMachine.insertCoin(scanner.nextDouble());
                    System.out.println("Current credit is " + vendingMachine.displayCredit());
                    break;
                case 4:
                    System.out.println(vendingMachine.displayProducts());
                    break;
                case 5:
                    interactingWithUser = false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
        System.out.println("Thank you for interaction");
    }
}
