package isp.lab6.exercise1;

import java.util.ArrayList;

import static isp.lab6.exercise1.SensorType.*;
import static java.time.LocalDateTime.now;

public class Exercise1 {
    private static final String SUCCESS_MESSAGE = "SensorReading added successfully";
    private static final String ERROR_MESSAGE = "Error adding SensorReading";

    public static void main(String[] args) {
        SensorsCluster sensorsCluster = new SensorsCluster(new ArrayList<>());

        sensorsCluster.addSensor("1", TEMPERATURE);
        sensorsCluster.addSensor("2", HUMIDITY);
        Sensor sensor2 = sensorsCluster.addSensor("3", PRESSURE);
        sensorsCluster.addSensor("3", TEMPERATURE);

        if (sensorsCluster.writeSensorReading("1", 22D, now())) {
            System.out.println(SUCCESS_MESSAGE);
        }
        if (sensorsCluster.writeSensorReading("1", 24D, now().plusMinutes(1))) {
            System.out.println(SUCCESS_MESSAGE);
        }
        if (sensorsCluster.writeSensorReading("1", 23D, now().plusMinutes(2))) {
            System.out.println(SUCCESS_MESSAGE);
        }

        sensorsCluster.writeSensorReading("2", 32D, now());
        sensorsCluster.writeSensorReading("2", 34D, now().plusMinutes(1));
        sensorsCluster.writeSensorReading("2", 33D, now().plusMinutes(2));

        sensorsCluster.writeSensorReading("3", 42D, now().plusMinutes(2));
        sensorsCluster.writeSensorReading("3", 44D, now().plusMinutes(1));
        sensorsCluster.writeSensorReading("3", 43D, now());

        if (sensorsCluster.writeSensorReading("4", 43D, now())) {
            System.out.println(SUCCESS_MESSAGE);
        } else {
            System.out.println(ERROR_MESSAGE);
        }

        Sensor sensor = sensorsCluster.getSensorById("1");
        Sensor sensor1 = sensorsCluster.getSensorById("2");
        Sensor sensor3 = sensorsCluster.getSensorById("4");
        System.out.println(sensor);
        System.out.println(sensor1);
        System.out.println(sensor2);
        System.out.println(sensor3);

        System.out.println(sensor.getSensorReadingsSortedByDateAndTime());
        System.out.println(sensor.getSensorReadingsSortedByValue());
        System.out.println(sensor1.getSensorReadingsSortedByDateAndTime());
        System.out.println(sensor1.getSensorReadingsSortedByValue());
        System.out.println(sensor2.getSensorReadingsSortedByDateAndTime());
        System.out.println(sensor2.getSensorReadingsSortedByValue());
    }
}
