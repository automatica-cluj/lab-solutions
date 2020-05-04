package isp.lab4.exercise3;



public class Exercise3 {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        FireAlarm fireAlarm = new FireAlarm(false);
        TemperatureSensor temperatureSensor = new TemperatureSensor(24, "living-room");

        controller.setFireAlarm(fireAlarm);
        controller.setTemperatureSensor(temperatureSensor);

        controller.controlStep();

        TemperatureSensor temperatureSensor1 = new TemperatureSensor(64, "bath-room");
        controller.setTemperatureSensor(temperatureSensor1);

        controller.controlStep();
    }
}
