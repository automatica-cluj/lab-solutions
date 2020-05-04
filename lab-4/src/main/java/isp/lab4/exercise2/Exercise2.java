package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FireAlarm fireAlarm = new FireAlarm(false);
        System.out.println(fireAlarm);
        fireAlarm.setActive(true);
        System.out.println(fireAlarm);
    }
}
