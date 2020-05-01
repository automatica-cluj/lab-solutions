package exercise1;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        final AlarmMonitor monitor = new AlarmMonitor();
        final AlarmController alarmController = new AlarmController();

        Alarm fireAlarm = new Alarm();
        fireAlarm.register(monitor);
        fireAlarm.register(alarmController);

        fireAlarm.startAlarm();
        Thread.sleep(500);
        fireAlarm.stopAlarm();
    }
}
