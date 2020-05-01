package isp.lab4.exercise3;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;

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

    public void controlStep() {
        if (getTemperatureSensor().getValue() > 50) {
            getFireAlarm().setActive(true);
        } else {
            getFireAlarm().setActive(false);
        }
        System.out.println(getFireAlarm() + " in " + getTemperatureSensor().getLocation());
    }
}