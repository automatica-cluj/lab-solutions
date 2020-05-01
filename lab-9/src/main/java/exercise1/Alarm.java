package exercise1;

public class Alarm extends Observable {
    void startAlarm() {
        System.out.println("Alarm has been started!");
        this.changeState("START");
    }

    void stopAlarm() {
        System.out.println("Alarm has been stopped!");
        this.changeState("STOP");
    }
}
