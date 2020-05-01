package isp.lab5.exercise1;

public class WithdrawMoney extends Transaction {
    private double amount;

    public WithdrawMoney(double amount, Account account) {
        super(account);
        this.amount = amount;
    }

    @Override
    public String execute() {
        if (this.account.getBalance() >= this.amount) {
            this.account.setBalance(this.account.getBalance() - this.amount);
            return "The amount withdrawn is " + this.amount + " and the remaining balance is " + this.account.getBalance();
        } else {
            return "The amount is bigger then account balance";
        }
    }
}
