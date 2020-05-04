package isp.lab4.exercise5;

public class TemperatureSensor {
    private int value;
    private String location;

    /**
     * Default constructor which use defaults values from java
     */
    public TemperatureSensor() {
    }

    /**
     * Constructor which sets the value and the location
     *
     * @param value    to be set
     * @param location to be set
     */
    public TemperatureSensor(int value, String location) {
        this.value = value;
        this.location = location;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" + "value=" + value + ", location='" + location + '\'' + '}';
    }
}
