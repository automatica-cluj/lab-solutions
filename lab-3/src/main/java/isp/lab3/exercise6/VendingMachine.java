package isp.lab3.exercise6;

public class VendingMachine {
    private static VendingMachine instance;

    private VendingMachine(){
        // just to restrict access to constructor
    }

    public static VendingMachine getInstance(){
        if (instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "VendingMachine{}";
    }

    //any other methods needed
}
