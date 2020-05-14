package isp.lab10.exercise1;

public class Aircraft implements Runnable {
    private final String id;
    private int altitude;
    private AircraftState state;
    private boolean isLanded = false;
    private Long startCruisingTime;

    public Aircraft(String id) {
        this.id = id;
        this.altitude = 0;
        this.state = AircraftState.ON_STAND;
    }

    public String getId() {
        return id;
    }

    public Integer getAltitude() {
        return altitude;
    }

    @Override
    public void run() {
        while (!isLanded) {
            switch (state) {
                case ON_STAND: {
                    System.out.println("ON_STAND -> " + this);
                    blockThread();
                    break;
                }
                case TAXING: {
                    System.out.println("TAXING -> " + this);
                    sleep(10_000L);
                    state = AircraftState.TAKING_OFF;
                    break;
                }
                case TAKING_OFF: {
                    System.out.println("TAKING_OFF -> " + this);
                    sleep(5_000L);
                    state = AircraftState.ASCENDING;
                    break;
                }
                case ASCENDING: {
                    System.out.println("ASCENDING -> " + this);
                    for (int i = 0; i <= altitude; i++) {
                        sleep(10_000L);
                    }
                    state = AircraftState.CRUISING;
                    break;
                }
                case CRUISING: {
                    System.out.println("CRUISING -> " + this);
                    startCruisingTime = System.currentTimeMillis();
                    blockThread();
                    break;
                }
                case DESCENDING: {
                    System.out.println("DESCENDING -> " + this);
                    for (int i = 0; i <= altitude; i++) {
                        sleep(10_000L);
                    }
                    System.out.println(this.getId() + " has landed ");
                    state = AircraftState.LANDED;
                    break;
                }
                case LANDED: {
                    System.out.println("LANDED -> " + this);
                    System.out.println("Aircraft " + this.getId() + " spent " + (System.currentTimeMillis() - startCruisingTime) + " milliseconds in cruising mode");
                    isLanded = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + state);
            }
        }
    }

    private void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void blockThread() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void receiveAtcMessage(AtcCommand atcCommand) {
        if (atcCommand instanceof TakeoffCommand) {
            if (state.equals(AircraftState.ON_STAND)) {
                synchronized (this) {
                    this.altitude = ((TakeoffCommand) atcCommand).getAltitude();
                    state = AircraftState.TAXING;
                    this.notify();
                }
            } else {
                System.out.println("Plane is not ON_STAND");
            }
        } else if (atcCommand instanceof LandCommand) {
            if (state.equals(AircraftState.CRUISING)) {
                synchronized (this) {
                    state = AircraftState.DESCENDING;
                    this.notify();
                }
            } else {
                System.out.println("Plane is not on CRUISING state");
            }
        } else {
            System.out.println("Bad command");
        }
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", altitude=" + altitude +
                ", state=" + state +
                ", isLanded=" + isLanded +
                '}';
    }
}
