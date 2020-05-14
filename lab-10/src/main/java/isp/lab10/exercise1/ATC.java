package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ATC {

    private final List<Aircraft> aircraftList = new ArrayList<>();

    public void addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id);
        if (aircraftList.contains(aircraft)) {
            System.out.println("This aircraft already exist");
        } else {
            aircraftList.add(aircraft);
            new Thread(aircraft).start();
        }
    }

    public void sendCommand(String aircraftId, AtcCommand cmd) {
        Aircraft existingAircraft = aircraftList.stream().filter(aircraft -> aircraft.getId().equals(aircraftId)).findFirst().orElse(null);
        if (existingAircraft != null) {
            existingAircraft.receiveAtcMessage(cmd);
        } else {
            System.out.println(" This aircraft does not exist! ");
        }
    }

    public void showAircraft() {
        for (Aircraft aircraftListIterator : aircraftList) {
            System.out.println(aircraftListIterator.toString());
        }
    }

}
