package isp.lab5.exercise1;

public class ChangePin extends Transaction {
    private final String oldPin;
    private final String newPin;

    public ChangePin(String oldPin, String newPin, Account account) {
        super(account);
        this.oldPin = oldPin;
        this.newPin = newPin;
    }

    /**
     * Verify if the old pin is equal with the existing one on the card of the current account<br>
     * And if true then change the pin to the newPin value
     *
     * @return A message which represents the outcome of the change pin transaction(successful or error)
     */
    @Override
    public String execute() {
        if (this.account.getCard().getPin().equals(oldPin)) {
            this.account.getCard().setPin(newPin);
            return "Pin changed successfully";
        } else {
            return "The old pin do not match the existing pin";
        }
    }
}
