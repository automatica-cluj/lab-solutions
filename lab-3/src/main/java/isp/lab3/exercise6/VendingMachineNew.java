package isp.lab3.exercise6;

import isp.lab3.exercise5.VendingMachine;

public class VendingMachineNew {
    private VendingMachineNew vendingMachine;

    private VendingMachineNew(){
        // just to restrict access to constructor
    }

    public VendingMachineNew getInstance(){
        if (this.vendingMachine == null){
            this.vendingMachine = new VendingMachineNew();
        }
        return this.vendingMachine;
    }
    //any other methods needed
}
