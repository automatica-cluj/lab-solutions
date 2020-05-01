package isp.lab8.safehome;

import java.util.ArrayList;

public class SafeHome {

    public static void main(String[] args) throws Exception {
        final DoorLockController doorLockController = new DoorLockController(new Door(), new ArrayList<>());
        doorLockController.addTenant("123", "123");
    }
}
