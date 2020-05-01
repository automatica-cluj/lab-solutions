package isp.lab4.exercise4;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;

public class Controller {

    TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];
    FireAlarm fireAlarm;

    public Controller(TemperatureSensor[] temperatureSensors, FireAlarm fireAlarm) {
        if (temperatureSensors.length == 3) {
            System.arraycopy(temperatureSensors, 0, this.temperatureSensors, 0, temperatureSensors.length);
//            for (int i = 0; i < temperatureSensors.length; i++) {
//                this.temperatureSensors[i] = temperatureSensors[i];
//            }
        } else {
            throw new IllegalArgumentException("You should provide an array containing exactly 3 elements");
        }
        this.fireAlarm = fireAlarm;
    }

    public TemperatureSensor[] getTemperatureSensors() {
        return temperatureSensors;
    }

    public void setTemperatureSensors(TemperatureSensor[] temperatureSensors) {
        this.temperatureSensors = temperatureSensors;
    }

    public FireAlarm getFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(FireAlarm fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    public void controlStep() {
        for (TemperatureSensor temperatureSensor : this.temperatureSensors) {
            if (temperatureSensor.getValue() < 50) {
                this.fireAlarm.setActive(false);
                System.out.println(this.fireAlarm);
                return;
            }
        }
        this.fireAlarm.setActive(true);
        System.out.println(this.fireAlarm);
    }
}
