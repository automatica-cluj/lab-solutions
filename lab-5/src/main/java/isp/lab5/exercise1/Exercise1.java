package isp.lab5.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        Atm atm = initializeAtm();
        atm.checkMoney();
        atm.withdraw(500.00);
        atm.changePin("asd", "as");

        if (atm.insertCard(new Card("1", "2"), "2")) {
            atm.checkMoney();
            atm.withdraw(500.00);
            atm.withdraw(2000.00);
            atm.checkMoney();
            atm.changePin("asd", "as");

            atm.changePin("2", "as");

            atm.removeCard();

            atm.checkMoney();
            atm.withdraw(500.00);
            atm.changePin("asd", "as");
        }
    }

    protected static Atm initializeAtm() {
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(new Card(String.valueOf(i), String.valueOf(2 * i)), "Owner " + i, 1000D * i);
        }
        Bank bank = new Bank(accounts);
        return new Atm(bank);
    }
}
