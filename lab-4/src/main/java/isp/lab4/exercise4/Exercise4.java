package isp.lab4.exercise4;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;

public class Exercise4 {

    public static void main(String[] args) {
        TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor1 = new TemperatureSensor(22, "room");
        TemperatureSensor temperatureSensor2 = new TemperatureSensor(35, "other-room");
        TemperatureSensor temperatureSensor3 = new TemperatureSensor(55, "fridge");

        temperatureSensors[0] = temperatureSensor1;
        temperatureSensors[1] = temperatureSensor2;
        temperatureSensors[2] = temperatureSensor3;

        Controller controller = new Controller(temperatureSensors, fireAlarm);
        controller.controlStep();

        TemperatureSensor temperatureSensor4 = new TemperatureSensor(55, "room");
        TemperatureSensor temperatureSensor5 = new TemperatureSensor(66, "other-room");
        TemperatureSensor temperatureSensor6 = new TemperatureSensor(70, "fridge");

        temperatureSensors[0] = temperatureSensor4;
        temperatureSensors[1] = temperatureSensor5;
        temperatureSensors[2] = temperatureSensor6;

        controller.setTemperatureSensors(temperatureSensors);
        controller.controlStep();
    }
}
