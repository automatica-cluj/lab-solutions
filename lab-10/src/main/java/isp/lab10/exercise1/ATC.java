package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ATC {

    private final List<Aircraft> aircraftList = new ArrayList<>();

    /**
     * Add a new {@link Aircraft} to the aircraftList and create a new {@link Aircraft} Thread and start it
     *
     * @param id the id of the new {@link Aircraft}
     */
    public void addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id);
        if (aircraftList.contains(aircraft)) {
            System.out.println("This aircraft already exist");
        } else {
            aircraftList.add(aircraft);
            new Thread(aircraft).start();
        }
    }

    /**
     * Search for an existing {@link Aircraft} and if found then send a command to the existing {@link Aircraft}
     *
     * @param aircraftId The id of the existing {@link Aircraft}
     * @param cmd        the command to be sent to the existing {@link Aircraft}
     */
    public void sendCommand(String aircraftId, AtcCommand cmd) {
        Aircraft existingAircraft = aircraftList.stream()
                .filter(aircraft -> aircraft.getId().equals(aircraftId))
                .findFirst()
                .orElse(null);
        if (existingAircraft != null) {
            existingAircraft.receiveAtcMessage(cmd);
        } else {
            System.out.println(" This aircraft does not exist! ");
        }
    }

    /**
     * Print the existing aircrafts
     */
    public void showAircraft() {
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.toString());
        }
    }

}
