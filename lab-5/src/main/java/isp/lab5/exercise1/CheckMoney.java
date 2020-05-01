package isp.lab5.exercise1;

public class CheckMoney extends Transaction {

    public CheckMoney(Account account) {
        super(account);
    }

    @Override
    public String execute() {
        return "The current balance is " + this.account.getBalance();
    }
}
