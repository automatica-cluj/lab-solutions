package isp.lab4.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor(22, "bathroom");
        printTemperatureSensorDetails(temperatureSensor);

        temperatureSensor = new TemperatureSensor();
        printTemperatureSensorDetails(temperatureSensor);
    }

    private static void printTemperatureSensorDetails(TemperatureSensor temperatureSensor) {
        System.out.println(temperatureSensor.getLocation());
        System.out.println(temperatureSensor.getValue());
        System.out.println(temperatureSensor);
    }
}
