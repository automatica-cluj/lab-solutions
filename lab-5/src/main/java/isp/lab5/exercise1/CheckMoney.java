package isp.lab5.exercise1;

public class CheckMoney extends Transaction {

    public CheckMoney(Account account) {
        super(account);
    }

    /**
     * Verify how many money are for current account
     *
     * @return A message representing the amount from current account
     */
    @Override
    public String execute() {
        return "The current balance is " + this.account.getBalance();
    }
}
