package isp.lab3.exercise5;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> products;
    private int credit;

    public VendingMachine() {
        this.credit = 0;
        this.products = new ArrayList<>();
    }

    public String selectProduct(int id) {
        for (Product product : products) {
            if (product != null && product.getId() == id) {
                return product.toString();
            }
        }
        return "The product with id: " + id + " is not available";
    }

    public int displayCredit() {
        return this.credit;
    }

    public void insertCoin(int value) {
        if (value >= 0) {
            this.credit += value;
        }
    }

    public String displayProducts() {
        return products.toString();
    }

    public String userMenu() {
        return "displayCredit() \n selectProduct(int id) \n insertCoin(int value) \n displayProducts()";
    }

    public void initialize() {
        this.products.add(new Product(1, "Apple"));
        this.products.add(new Product(2, "Cola"));
        this.products.add(new Product(3, "Sprite"));
        this.products.add(new Product(4, "7 Days"));
        this.products.add(new Product(5, "Water"));
        this.products.add(new Product(6, "Snickers"));
        this.products.add(new Product(7, "Rafaelo"));
    }

}
