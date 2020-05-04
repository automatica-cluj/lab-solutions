package isp.lab6.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SensorsCluster {
    private List<Sensor> sensors;

    public SensorsCluster(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    /**
     * Add a new {@link Sensor} to sensors list with the specified id and type if sensorId is unique
     *
     * @param sensorId   id of the new sensor
     * @param sensorType type of the new sensor
     * @return the newly added {@link Sensor} or null if operation fails
     */
    public Sensor addSensor(String sensorId, SensorType sensorType) {
        if (this.sensors == null) {
            sensors = new ArrayList<>();
        }
        for (Sensor sensor : this.sensors) {
            if (sensor.getId().equals(sensorId)) {
                return null;
            }
        }
        Sensor sensor = new Sensor(sensorType, sensorId);
        this.sensors.add(sensor);
        return sensor;
    }

    /**
     * This method add a new {@link SensorReading} to the list of sensorReadings of a specific {@link Sensor} specified by sensorId
     *
     * @param sensorId the id of the {@link Sensor} used to add a new {@link SensorReading}
     * @param value    the value of the new {@link SensorReading}
     * @param dateTime the date and time of the new {@link SensorReading}
     * @return true if operation ends successfully or false otherwise
     */
    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime) {
        if (this.sensors != null) {
            Sensor existingSensor = getSensorById(sensorId);
            if (existingSensor != null){
                return existingSensor.addSensorReading(new SensorReading(dateTime, value));
            }
        }
        return false;
    }

    /**
     * Get a sensor by a specified id
     *
     * @param sensorId The id of the sensor we want to get
     * @return the existing sensor in the sensors list or null if the requested object does not exist
     */
    public Sensor getSensorById(String sensorId) {
        for (Sensor sensor : this.sensors) {
            if (sensor.getId().equals(sensorId)) {
                return sensor;
            }
        }
        return null;
    }
}