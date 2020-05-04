package isp.lab4.exercise5;

public class FireAlarm {
    private boolean active;

    /**
     * Constructor which initialize the {@link FireAlarm} as active or inactive
     *
     * @param active true if the alarm is active or false otherwise
     */
    public FireAlarm(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "FireAlarm{" +
                "active=" + active +
                '}';
    }
}
