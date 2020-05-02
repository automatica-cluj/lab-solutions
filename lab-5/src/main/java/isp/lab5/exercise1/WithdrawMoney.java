package isp.lab5.exercise1;

public class WithdrawMoney extends Transaction {
    private final double amount;

    public WithdrawMoney(double amount, Account account) {
        super(account);
        this.amount = amount;
    }

    /**
     * Verify if the operation of withdraw is possible and if so then withdraw the money
     *
     * @return A message representing info about withdraw transaction(successful or error)
     */
    @Override
    public String execute() {
        if (this.account.getBalance() >= this.amount) {
            this.account.setBalance(this.account.getBalance() - this.amount);
            return "The amount withdrawn is " + this.amount + " and the remaining balance is " + this.account.getBalance();
        } else {
            return "The amount is bigger than account balance";
        }
    }
}
