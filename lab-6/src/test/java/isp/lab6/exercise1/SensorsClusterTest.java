package isp.lab6.exercise1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;

import static isp.lab6.exercise1.SensorType.*;
import static org.junit.Assert.*;

public class SensorsClusterTest {
    private final LocalDateTime someDateAndTime = LocalDateTime.of(2020, 5, 4, 12, 56, 30);
    private SensorsCluster sensorsCluster;


    @Before
    public void setUp() {
        sensorsCluster = new SensorsCluster(new ArrayList<>());
    }

    @Test
    public void testAddSensorShouldReturnNullBecauseIdAlreadyExist() {
        //given
        Sensor sensor = new Sensor(PRESSURE, "1");

        //when
        Sensor sensorAdded = sensorsCluster.addSensor("1", PRESSURE);
        Sensor sensorAddedSecondTime = sensorsCluster.addSensor("1", PRESSURE);

        //then
        assertEquals("The objects should be the same", sensor, sensorAdded);
        assertNull("The object should be because another sensor with same id already exists", sensorAddedSecondTime);
    }

    @Test
    public void testAddSensorShouldShouldWorkWhenSensorsIsNull() {
        //given
        sensorsCluster = new SensorsCluster(null);
        Sensor sensor = new Sensor(PRESSURE, "1");

        //when
        Sensor sensorAdded = sensorsCluster.addSensor("1", PRESSURE);

        //then
        assertEquals("The objects should be the same", sensor, sensorAdded);
    }

    @Test
    public void testAddSensorShouldWorkPerfectForSensorsWithDifferentIds() {
        //given
        Sensor sensor = new Sensor(PRESSURE, "1");
        Sensor sensor1 = new Sensor(TEMPERATURE, "2");
        Sensor sensor2 = new Sensor(HUMIDITY, "3");

        //when
        Sensor sensorAdded = sensorsCluster.addSensor("1", PRESSURE);
        Sensor sensorAdded1 = sensorsCluster.addSensor("2", TEMPERATURE);
        Sensor sensorAdded2 = sensorsCluster.addSensor("3", HUMIDITY);

        //then
        assertEquals("The objects should be the same", sensor, sensorAdded);
        assertEquals("The objects should be the same", sensor1, sensorAdded1);
        assertEquals("The objects should be the same", sensor2, sensorAdded2);
    }

    @Test
    public void testWriteSensorReadingShouldReturnFalseBecauseSensorNotFoundById() {
        assertFalse("The operation should fail because there is no sensor", sensorsCluster.writeSensorReading("1", 232D, someDateAndTime));
        sensorsCluster.addSensor("someRandomId", HUMIDITY);
        assertFalse("The operation should fail because there is not a sensor with the specified id", sensorsCluster.writeSensorReading("1", 232D, someDateAndTime));
    }

    @Test
    public void testWriteSensorReadingShouldWorkAndReturnTrue() {
        //given
        sensorsCluster.addSensor("1", TEMPERATURE);

        //when
        boolean isAddedSuccessfully = sensorsCluster.writeSensorReading("1", 232D, someDateAndTime);

        //then
        assertTrue("The operation should be successful", isAddedSuccessfully);
    }

    @Test
    public void testGetSensorByIdShouldReturnNullBecauseWrongIdProvided() {
        assertNull("The object should be null because the list is empty", sensorsCluster.getSensorById("someWrongID"));
        sensorsCluster.addSensor("1",PRESSURE);
        assertNull("The object should be null because a wrong id was provided", sensorsCluster.getSensorById("anotherWrongID"));
    }

    @Test
    public void testGetSensorByIdShouldWorkNice() {
        //given
        Sensor sensor = sensorsCluster.addSensor("1", TEMPERATURE);

        //when
        Sensor foundSensor = sensorsCluster.getSensorById("1");
        assertEquals("The sensors should be the same", sensor, foundSensor);
    }
}