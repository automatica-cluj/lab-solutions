package isp.lab3.exercise6;

public class VendingMachine {
    private static VendingMachine instance;
    private final String[] products;
    private final double[] prices;
    private double credit;

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "VendingMachine{}";
    }

    /**
     * Constructor which initialize the vending machine with some products and 0 credit
     */
    private VendingMachine() {
        this.credit = 0;
        this.products = new String[]{
                "Cola",
                "Sprite",
                "Fanta",
                "Mirinda",
                "Schweppes"
        };
        this.prices = new double[]{
                4.00D,
                4.50D,
                4.50D,
                3.50D,
                5.00D
        };
    }

    /**
     * Display the desired product by id if the product exists and the amount of credit required for that product is inserted in vending machine or print an error message
     *
     * @param id the id of the desired product
     * @return a {@link String} containing the name of desired product or some error message
     */
    public String selectProduct(int id) {

        if (id < this.products.length && id >= 0) {
            if (this.credit >= this.prices[id]) {
                this.credit -= this.prices[id];
                return this.products[id];
            }
            return "Insufficient founds";
        } else {
            return "The product with id: " + id + " is not available";
        }
    }

    /**
     * Return the current credit from the vending machine
     * Works as a getter for credit
     *
     * @return the current credit
     */
    public double displayCredit() {
        return this.credit;
    }

    /**
     * Insert some coins into vending machine if the value is positive
     *
     * @param value the amount of coins to be inserted
     */
    public void insertCoin(double value) {
        if (value >= 0) {
            this.credit += value;
        } else {
            System.out.println("You can not take out money from vending machine");
        }
    }

    /**
     * Returns a list containing all products from vending machine
     *
     * @return list of products
     */
    public String displayProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.products.length; i++) {
            stringBuilder.append(i).append(" ").append(this.products[i]).append(" -> ").append(this.prices[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Display a message that represents a list of options to be displayed to a user
     *
     * @return list of options
     */
    public String userMenu() {
        return "1 -> Display credit\n2 -> Select product by id\n3 -> Insert coin \n4 -> Display products \n5 -> Exit\n";
    }

    public String[] getProducts() {
        return products;
    }

    public double[] getPrices() {
        return prices;
    }
}
