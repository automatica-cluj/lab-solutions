package isp.lab4.exercise4;


public class Controller {
    private static final int NR_OF_SENSORS = 3;

    TemperatureSensor[] temperatureSensors = new TemperatureSensor[NR_OF_SENSORS];
    FireAlarm fireAlarm;

    public Controller(TemperatureSensor[] temperatureSensors, FireAlarm fireAlarm) {
        if (temperatureSensors.length == NR_OF_SENSORS) {
            System.arraycopy(temperatureSensors, 0, this.temperatureSensors, 0, temperatureSensors.length);
        } else {
            throw new IllegalArgumentException("You should provide an array containing exactly " + NR_OF_SENSORS + " elements");
        }
        this.fireAlarm = fireAlarm;
    }

    public void setTemperatureSensors(TemperatureSensor[] temperatureSensors) {
        this.temperatureSensors = temperatureSensors;
    }

    /**
     * Handle system functionality<br>
     * If any sensor's value is lower than 50 then the alarm will be OFF otherwise ON
     */
    public void controlStep() {
        for (TemperatureSensor temperatureSensor : this.temperatureSensors) {
            if (temperatureSensor.getValue() < 50) {
                this.fireAlarm.setActive(false);
                System.out.println("Fire alarm not started");
                return;
            }
        }
        this.fireAlarm.setActive(true);
        System.out.println("Fire alarm started");
    }
}
