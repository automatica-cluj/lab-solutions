package isp.lab6.exercise1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static isp.lab6.exercise1.SensorType.PRESSURE;
import static isp.lab6.exercise1.SensorType.TEMPERATURE;
import static java.time.LocalDateTime.now;
import static org.junit.Assert.*;

public class SensorTest {
    private SensorsCluster sensorsCluster;
    private final List<SensorReading> sortedSensorReadingsByDateAndTime = new ArrayList<>();
    private final List<SensorReading> sortedSensorReadingsByValue = new ArrayList<>();
    private final LocalDateTime someDateAndTime = LocalDateTime.of(2020, 5, 4, 12, 56, 30);

    @Before
    public void setUp() {
        sensorsCluster = new SensorsCluster(new ArrayList<>());
        sensorsCluster.addSensor("1", TEMPERATURE);
        sensorsCluster.addSensor("2", PRESSURE);

        sensorsCluster.writeSensorReading("1", 42D, someDateAndTime.plusMinutes(2));
        sensorsCluster.writeSensorReading("1", 44D, someDateAndTime.plusMinutes(1));
        sensorsCluster.writeSensorReading("1", 43D, someDateAndTime);
    }

    @Test
    public void testGetSensorReadingsSortedByDateAndTime() {
        //given
        sortedSensorReadingsByDateAndTime.add(new SensorReading(someDateAndTime, 43D));
        sortedSensorReadingsByDateAndTime.add(new SensorReading(someDateAndTime.plusMinutes(1), 44D));
        sortedSensorReadingsByDateAndTime.add(new SensorReading(someDateAndTime.plusMinutes(2), 42D));

        //when
        List<SensorReading> ourSortedSensorReadingsByDateAndTime = sensorsCluster.getSensors().get(0).getSensorReadingsSortedByDateAndTime();

        //then
        for (int i = 0; i < ourSortedSensorReadingsByDateAndTime.size(); i++) {
            assertEquals("Each object from first list should be the same as the one in the other list", ourSortedSensorReadingsByDateAndTime.get(i), sortedSensorReadingsByDateAndTime.get(i));
        }
    }

    @Test
    public void testGetSensorReadingsSortedByDateAndTimeShouldReturnNullIfTheListIsNull() {
        //when
        List<SensorReading> ourSortedSensorReadingsByDateAndTime = sensorsCluster.getSensors().get(1).getSensorReadingsSortedByDateAndTime();

        //then
        assertNull("Each object from first list should be the same as the one in the other list", ourSortedSensorReadingsByDateAndTime);
    }

    @Test
    public void testGetSensorReadingsSortedByValue() {

        //given
        sortedSensorReadingsByValue.add(new SensorReading(someDateAndTime.plusMinutes(2), 42D));
        sortedSensorReadingsByValue.add(new SensorReading(someDateAndTime, 43D));
        sortedSensorReadingsByValue.add(new SensorReading(someDateAndTime.plusMinutes(1), 44D));

        //when
        List<SensorReading> ourSortedSensorReadingsByValue = sensorsCluster.getSensors().get(0).getSensorReadingsSortedByValue();

        //then
        for (int i = 0; i < ourSortedSensorReadingsByValue.size(); i++) {
            assertEquals("Each object from first list should be the same as the one in the other list", ourSortedSensorReadingsByValue.get(i), sortedSensorReadingsByValue.get(i));
        }
    }

    @Test
    public void testGetSensorReadingsSortedByValueShouldReturnNullIfTheListIsNull() {
        //when
        List<SensorReading> ourSortedSensorReadingsByValue = sensorsCluster.getSensors().get(1).getSensorReadingsSortedByValue();

        //then
        assertNull("The list should be null because no SensorReading was added to the current sensor", ourSortedSensorReadingsByValue);
    }

    @Test
    public void testAddSensorReading() {
        Sensor sensor = new Sensor(PRESSURE, "1");
        SensorReading sensorReading = new SensorReading(now(), 45D);
        assertTrue(sensor.addSensorReading(sensorReading));
        assertEquals("the object from the list should be the one added", sensorReading, sensor.getSensorReadings().get(0));
        assertEquals("There should be one element in the sensorReadings", 1, sensor.getSensorReadings().size());

        SensorReading sensorReading1 = new SensorReading(now().plusDays(1), 46D);
        assertTrue(sensor.addSensorReading(sensorReading1));
        assertEquals("the object from the list should be the one added", sensorReading, sensor.getSensorReadings().get(0));
        assertEquals("the object from the list should be the one added", sensorReading1, sensor.getSensorReadings().get(1));
        assertEquals("There should be thw elements in the sensorReadings", 2, sensor.getSensorReadings().size());
    }
}