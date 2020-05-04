package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Sensor {
    private List<SensorReading> sensorReadings;
    private final SensorType sensorType;
    private final String id;

    public Sensor(SensorType sensorType, String id) {
        this.sensorType = sensorType;
        this.id = id;
    }

    public List<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public String getId() {
        return id;
    }

    /**
     * Sort sensorReadings by date and time ascending
     *
     * @return Sorted sensorReadings by date and time
     */
    public List<SensorReading> getSensorReadingsSortedByDateAndTime() {
        Collections.sort(this.sensorReadings);
        return this.sensorReadings;
    }

    /**
     * Sort sensorReadings by value ascending
     *
     * @return Sorted sensorReadings by value
     */
    public List<SensorReading> getSensorReadingsSortedByValue() {
        this.sensorReadings.sort(new SensorReading.ValueComparator());
        return this.sensorReadings;
    }

    /**
     * Add a new {@link SensorReading} to the list of sensorReadings
     *
     * @param sensorReading object to be added to the list
     * @return true if the object was added successfully and false otherwise
     */
    public boolean addSensorReading(SensorReading sensorReading) {
        if (getSensorReadings() == null) {
            this.sensorReadings = new ArrayList<>();
        }
        this.sensorReadings.add(sensorReading);
        return true;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorReading=" + sensorReadings +
                ", sensorType=" + sensorType +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(sensorReadings, sensor.sensorReadings) &&
                sensorType == sensor.sensorType &&
                Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorReadings, sensorType, id);
    }
}
