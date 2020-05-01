package exercise2;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // initialize observers
        final SensorController sensorController = new SensorController();

        // initialize observables objects
        final List<Observable> sensorOperations = Arrays.asList(
                new TemperatureSensor(),
                new HumiditySensor(),
                new PressureSensor()
        );

        // register observer for each observable
        sensorOperations.forEach(sensor -> sensor.register(sensorController));

        // change some data
        sensorOperations.forEach(sensor -> ((SensorOperations)sensor).readSensor());
        sensorOperations.forEach(sensor -> ((SensorOperations)sensor).readSensor());
    }
}
