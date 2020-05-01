package isp.lab7.safehome;

import isp.lab7.safehome.exceptions.InvalidPinException;
import isp.lab7.safehome.exceptions.TenantAlreadyExistsException;
import isp.lab7.safehome.exceptions.TenantNotFoundException;
import isp.lab7.safehome.exceptions.TooManyAttemptsException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DoorLockController implements ControllerInterface {
    private static final String ENTER_PIN_OPERATION = "enterPin";
    private static final String ADD_TENANT_OPERATION = "addTenant";
    private static final Integer MAX_RETRIES = 3;
    private Door door;
    private Map<Tenant, AccessKey> validAccess;
    private List<AccessLog> accessLogs;
    private Integer currentRetries = 0;

    public DoorLockController(Door door, List<AccessLog> accessLogs) {
        this.door = door;
        this.accessLogs = accessLogs;
        this.validAccess = new HashMap<>();
        this.validAccess.put(new Tenant(ControllerInterface.MASTER_TENANT_NAME), new AccessKey(ControllerInterface.MASTER_KEY));
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception {
        final Map.Entry<Tenant, AccessKey> accessKeyEntry = this.validAccess
                .entrySet()
                .stream()
                .filter(tenantAccessKeyEntry -> tenantAccessKeyEntry.getValue().getPin().equals(pin))
                .findFirst().orElse(null);

        if (Objects.isNull(accessKeyEntry)) { // invalid pin
            currentRetries ++;
            if (this.isPermanentlyLocked()) { // max attempts
                this.currentRetries = 3;
                this.accessLogs.add(this.createAccessLog("", ENTER_PIN_OPERATION, "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            } else {
                this.accessLogs.add(this.createAccessLog("", ENTER_PIN_OPERATION, "InvalidPinException"));
                throw new InvalidPinException();
            }
        } else { // valid pin
            if (accessKeyEntry.getKey().getName().equals(ControllerInterface.MASTER_TENANT_NAME)) { // reset retries
                this.currentRetries = 0;
            } else if (this.isPermanentlyLocked()){
                this.accessLogs.add(this.createAccessLog("", ENTER_PIN_OPERATION, "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            }

            if (door.getStatus() == DoorStatus.OPEN) {
                door.lockDoor();
            } else {
                door.unlockDoor();
            }

            this.accessLogs.add(this.createAccessLog("", ENTER_PIN_OPERATION, ""));
            return door.getStatus();
        }
    }

    @Override
    public void addTenant(String pin, String name) throws Exception {
        final Tenant tenant = new Tenant(name);

        if (this.validAccess.containsKey(tenant)) {
            this.accessLogs.add(this.createAccessLog(name, ENTER_PIN_OPERATION, "TenantAlreadyExistsException"));
            throw new TenantAlreadyExistsException();
        }

        this.accessLogs.add(this.createAccessLog(name, ENTER_PIN_OPERATION, ""));
        this.validAccess.put(tenant, new AccessKey(pin));
    }

    @Override
    public void removeTenant(String name) throws Exception {
        final Tenant tenant = new Tenant(name);

        if (!this.validAccess.containsKey(tenant)) {
            this.accessLogs.add(this.createAccessLog(name, ADD_TENANT_OPERATION, "TenantNotFoundException"));
            throw new TenantNotFoundException();
        }

        this.accessLogs.add(this.createAccessLog(name, ADD_TENANT_OPERATION, ""));
        this.validAccess.remove(tenant);
    }

    public List<AccessLog> getAccessLogs() {
        return accessLogs;
    }

    private AccessLog createAccessLog(final String tenant, final String operation, final String errMessage) {
        return new AccessLog(tenant, LocalDateTime.now(), operation, this.door.getStatus(), errMessage);
    }

    private boolean isPermanentlyLocked() {
        return this.currentRetries >= MAX_RETRIES;
    }
}
