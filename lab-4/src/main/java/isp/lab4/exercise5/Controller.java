package isp.lab4.exercise5;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;

public class Controller {

    private TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];
    private FireAlarm fireAlarm;

    public Controller() {
        TemperatureSensor temperatureSensor1, temperatureSensor2, temperatureSensor3;
        temperatureSensor1 = new TemperatureSensor(23, "some-room");
        temperatureSensor2 = new TemperatureSensor(30, "some-other-room");
        temperatureSensor3 = new TemperatureSensor(4, "some-fridge");

        this.temperatureSensors[0] = temperatureSensor1;
        this.temperatureSensors[1] = temperatureSensor2;
        this.temperatureSensors[2] = temperatureSensor3;
        this.fireAlarm = new FireAlarm(false);
    }

    public void controlStep() {
        for (TemperatureSensor temperatureSensor : this.temperatureSensors) {
            if (temperatureSensor.getValue() > 50) {
                this.fireAlarm.setActive(true);
                System.out.println(this.fireAlarm);
                return;
            }
        }
        this.fireAlarm.setActive(false);
        System.out.println(this.fireAlarm);
    }
}
