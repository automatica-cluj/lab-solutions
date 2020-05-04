package isp.lab6.exercise3;

/**
 * Superclass for all Transactions
 */
public abstract class Transaction {
    protected Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    public abstract String execute();
}
