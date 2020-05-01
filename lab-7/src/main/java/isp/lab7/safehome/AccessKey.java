package isp.lab7.safehome;

public class AccessKey {
    private String pin;

    public AccessKey(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
