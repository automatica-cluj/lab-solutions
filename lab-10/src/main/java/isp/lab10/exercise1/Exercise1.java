package isp.lab10.exercise1;

public class Exercise1 {

    public static void main(String[] args) throws InterruptedException {
        ATC atc = new ATC();

        TakeoffCommand takeoffCommand1 = new TakeoffCommand(2);
        LandCommand landCommand = new LandCommand();

        atc.addAircraft("1");
        atc.addAircraft("2");

        atc.showAircraft();

        Thread.sleep(1000);

        atc.sendCommand("1", takeoffCommand1);
        atc.sendCommand("2", takeoffCommand1);

        Thread.sleep(50000);// wait until reaching cruising

        atc.sendCommand("1", landCommand);
        atc.sendCommand("2", landCommand);
    }
}
