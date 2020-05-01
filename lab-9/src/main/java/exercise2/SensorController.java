package exercise2;

public class SensorController implements Observer {
    @Override
    public void update(Object event) {
        if (!(event instanceof SensorOperationData)) {
            System.out.println("!!! different event");
            return;
        }

        final SensorOperationData sensorOperationData = (SensorOperationData) event;
        System.out.println("Sensor type = " + sensorOperationData.getSensorType() + "; Sensor data = " + sensorOperationData.getValue());
    }
}
