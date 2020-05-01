package exercise1;

public class AlarmController implements Observer {
    @Override
    public void update(Object event) {
        System.out.println("Sending SMS message to owner.");
    }
}
