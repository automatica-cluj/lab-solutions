package isp.lab5.exercise1;

import java.util.Arrays;

public class Bank {
    private final Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    public String executeTransaction(Transaction transaction) {
        return transaction.execute();
    }

    public Account getAccountByCardId(String cardId) {
        if (this.accounts != null && this.accounts.length > 0) {
            return Arrays.stream(accounts).filter(account -> account.getCard().getCardId().equals(cardId)).findFirst().orElse(null);
        } else {
            return null;
        }
    }
}
