package isp.lab6.exercise3;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;

    public Bank(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public String executeTransaction(Transaction transaction) {
        return transaction.execute();
    }

    /**
     * Search and return an {@link Account} based on a card id
     *
     * @param cardId the id of the card
     * @return the found {@link Account} having the card with the specified cardId or null if no account found
     */
    public Account getAccountByCardId(String cardId) {
        if (this.accounts != null && this.accounts.size() > 0) {
            return accounts.stream().filter(account -> account.getCard().getCardId().equals(cardId)).findFirst().orElse(null);
        } else {
            return null;
        }
    }
}
