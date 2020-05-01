package isp.lab7.safehome;

public class Door {
    private DoorStatus status;

    public Door() {
        this.status = DoorStatus.CLOSE;
    }

    public DoorStatus getStatus() {
        return status;
    }

    /**
     * Change door status to {@link DoorStatus#CLOSE}
     */
    public void lockDoor() {
        this.status = DoorStatus.CLOSE;
    }

    /**
     * Change door status to {@link DoorStatus#OPEN}
     */
    public void unlockDoor() {
        this.status = DoorStatus.OPEN;
    }
}
