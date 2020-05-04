package isp.lab6.exercise1;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class SensorReading implements Comparable<SensorReading> {
    private final LocalDateTime dateAndTime;
    private final double value;

    public SensorReading(LocalDateTime dateAndTime, double value) {
        this.dateAndTime = dateAndTime;
        this.value = value;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(SensorReading sensorReading) {
        return this.getDateAndTime().compareTo(sensorReading.getDateAndTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorReading that = (SensorReading) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(dateAndTime, that.dateAndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateAndTime);
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "dateAndTime=" + dateAndTime +
                ", value=" + value +
                '}';
    }


    /**
     * Comparator used to sort a {@link Collection} of {@link SensorReading} by it's value ascending
     */
    public static class ValueComparator implements Comparator<SensorReading> {

        @Override
        public int compare(SensorReading sensorReading1, SensorReading sensorReading2) {
            if (sensorReading1.getValue() - sensorReading2.getValue() > 0.01) {
                return 1;
            } else if (sensorReading1.getValue() - sensorReading2.getValue() < 0.01) {
                return -1;
            }
            return 0;
        }
    }
}

