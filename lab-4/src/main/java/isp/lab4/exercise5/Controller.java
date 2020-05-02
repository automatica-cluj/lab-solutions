package isp.lab4.exercise5;

public class Controller {
    private static final int NR_OF_SENSORS = 3;

    private final TemperatureSensor[] temperatureSensors = new TemperatureSensor[NR_OF_SENSORS];
    private final FireAlarm fireAlarm;


    /**
     * Constructor that initialize the controller with "NR_OF_SENSORS" {@link TemperatureSensor}s and a {@link FireAlarm}
     */
    public Controller() {
        for (int i = 0; i < NR_OF_SENSORS; i++) {
            this.temperatureSensors[i] = new TemperatureSensor(30 * i, "room " + i);
        }
        this.fireAlarm = new FireAlarm(false);
    }

    public FireAlarm getFireAlarm() {
        return fireAlarm;
    }

    /**
     * Handle system functionality<br>
     * If any sensor's value is greater than 50 then the alarm will be ON otherwise OFF
     */
    public void controlStep() {
        for (TemperatureSensor temperatureSensor : this.temperatureSensors) {
            if (temperatureSensor.getValue() > 50) {
                this.fireAlarm.setActive(true);
                System.out.println("Fire alarm started");
                return;
            }
        }
        this.fireAlarm.setActive(false);
        System.out.println("Fire alarm not started");
    }
}
