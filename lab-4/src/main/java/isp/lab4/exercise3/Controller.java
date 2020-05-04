package isp.lab4.exercise3;

public class Controller {

    TemperatureSensor temperatureSensor;
    FireAlarm fireAlarm;

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public FireAlarm getFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(FireAlarm fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    /**
     * Handle system functionality<br>
     * Turn the alarm ON if the temperature sensor value is greater than 50
     */
    public void controlStep() {
        if (getTemperatureSensor().getValue() > 50) {
            getFireAlarm().setActive(true);
            System.out.println("Fire alarm started");
        } else {
            getFireAlarm().setActive(false);
            System.out.println("Fire alarm not started");
        }
    }
}