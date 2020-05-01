package exercise2;

public class SensorOperationData {
    private SensorType sensorType;
    private Integer value;

    public SensorOperationData(SensorType sensorType, Integer value) {
        this.sensorType = sensorType;
        this.value = value;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public Integer getValue() {
        return value;
    }
}
