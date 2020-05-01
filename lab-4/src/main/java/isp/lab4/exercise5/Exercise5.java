package isp.lab4.exercise5;

public class Exercise5 {

    public static void main(String[] args) {
        Controller controller = new Controller();
        House house = new House(controller);

        house.getController().controlStep();
    }
}
