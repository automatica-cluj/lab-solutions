package isp.lab5.exercise1;

public class Atm {
    protected static final String INSERT_CARD_MESSAGE = "Please insert the card";
    private Card card;
    private final Bank bank;

    public Atm(Bank bank) {
        this.bank = bank;
    }

    public void changePin(String oldPin, String newPin) {
        if (this.card != null) {
            System.out.println(bank.executeTransaction(new ChangePin(oldPin, newPin, bank.getAccountByCardId(this.card.getCardId()))));
        } else {
            System.out.println(INSERT_CARD_MESSAGE);
        }
    }

    public void withdraw(Double amount) {
        if (this.card != null) {
            System.out.println(bank.executeTransaction(new WithdrawMoney(amount, bank.getAccountByCardId(this.card.getCardId()))));
        } else {
            System.out.println(INSERT_CARD_MESSAGE);
        }
    }

    public void checkMoney() {
        if (this.card != null) {
            System.out.println(bank.executeTransaction(new CheckMoney(bank.getAccountByCardId(this.card.getCardId()))));
        } else {
            System.out.println(INSERT_CARD_MESSAGE);
        }
    }

    public boolean insertCard(Card card, String pin) {
        if (this.card == null) {
            if (card.getPin().equals(pin)) {
                this.card = card;
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Card already inserted");
            return false;
        }
    }

    public void removeCard() {
        this.card = null;
    }

    public Bank getBank() {
        return bank;
    }

    public Card getCard() {
        return card;
    }
}
