package exercise2;

import java.util.Random;

public class TemperatureSensor extends Observable implements SensorOperations {

    @Override
    public void readSensor() {
        final Random random = new Random();
        final Integer data = random.nextInt();

        this.changeState(new SensorOperationData(SensorType.TEMPERATURE, data));
    }
}
