package isp.lab6.exercise3;

public class Account {
    private final Card card;
    private final String owner;
    private double balance;

    public Account(Card card, String owner, double balance) {
        this.card = card;
        this.owner = owner;
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
