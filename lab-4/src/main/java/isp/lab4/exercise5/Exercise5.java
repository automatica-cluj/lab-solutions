package isp.lab4.exercise5;

public class Exercise5 {

    public static void main(String[] args) {
        Controller controller = new Controller();
        House house = new House(controller);

        System.out.println(house.getController().getFireAlarm().isActive());
        house.getController().controlStep();
        System.out.println(house.getController().getFireAlarm().isActive());
    }
}
