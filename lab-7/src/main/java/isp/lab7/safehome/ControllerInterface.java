package isp.lab7.safehome;

public interface ControllerInterface {
    /**
     * Master key used by
     */
    String MASTER_KEY = "MasterKeyValue";

    /**
     *
     */
    String MASTER_TENANT_NAME = "MasterTenant";

    /**
     * Lock / unlock door based on <param>pin</param> input
     * If pin is wrong, {@link InvalidPinException} exception will be thrown
     * If 3 consecutive entered pins are wrong, {@link TooManyAttemptsException} exception will be thrown
     * If {@link ControllerInterface#MASTER_KEY} is used as input value, number of retries will be reset to 0 and door will be locked / unlocked based on its current state
     *
     * @param pin - pin value
     * @return current {@link DoorStatus} status
     * @throws Exception
     */
    DoorStatus enterPin(String pin) throws Exception;

    /**
     * Add new tenant in the system
     * When tenant with this name already exists, {@link TenantAlreadyExistsException} will be thrown
     *
     * @param pin  - pin to be added in the system
     * @param name - tenant name to be added in the system
     * @throws Exception
     */
    void addTenant(String pin, String name) throws Exception;

    /**
     * Remove existing tenant from the system
     * When tenant with this name not found, {@link TenantNotFoundException} will be thrown
     *
     * @param name - tenant name to be removed
     * @throws Exception
     */
    void removeTenant(String name) throws Exception;
}
