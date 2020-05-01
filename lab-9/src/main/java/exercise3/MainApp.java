package exercise3;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        final DoorLockController doorLockController = new DoorLockController(new Door(), new ArrayList<>());
        new MainScreen(doorLockController);
    }
}
