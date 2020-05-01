package exercise3;

import exercise3.exceptions.InvalidPinException;
import exercise3.exceptions.TooManyAttemptsException;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainScreen extends JFrame {
    private final DoorLockController doorLockController;

    private JTextField pinAccessCodeTextField;
    private JButton enterPinButton;
    private JTextField doorStatusTextField;
    private JLabel errorMessageLabel;

    public MainScreen(DoorLockController doorLockController) throws HeadlessException {
        this.doorLockController = doorLockController;
        this.initializeUiComponents();
        this.initializeHandlers();
        this.setComponentsDefaultValues();
        this.initializeFrame();
    }

    /**
     * Initialize UI components
     */
    private void initializeUiComponents() {
        final JLabel typeAccessCodeLabel = new JLabel("Type access code:");
        typeAccessCodeLabel.setBounds(5, 5, 150, 20);

        this.pinAccessCodeTextField = new JTextField("");
        this.pinAccessCodeTextField.setBounds(170, 5, 200, 20);

        this.enterPinButton = new JButton("Enter code");
        this.enterPinButton.setBounds(5, 30, 365, 20);

        final JLabel doorStatusLabel = new JLabel("Door status:");
        doorStatusLabel.setBounds(5, 60, 150, 20);

        this.doorStatusTextField = new JTextField();
        this.doorStatusTextField.setBounds(170, 60, 200, 20);

        this.errorMessageLabel = new JLabel();
        this.errorMessageLabel.setBounds(5, 90, 300, 20);
        this.errorMessageLabel.setVisible(false);

        // add elements to frame
        add(typeAccessCodeLabel);
        add(pinAccessCodeTextField);
        add(enterPinButton);
        add(doorStatusLabel);
        add(doorStatusTextField);
        add(errorMessageLabel);
    }

    /**
     * Initialize frame
     */
    private void initializeFrame() {
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Initialize UI handlers
     */
    private void initializeHandlers() {
        this.enterPinButton.addActionListener(e -> {
            final String enteredPin = pinAccessCodeTextField.getText();

            try {
                final DoorStatus updatedStatus = this.doorLockController.enterPin(enteredPin);
                this.setDoorStatusTextValue(updatedStatus);
                this.setErrorMessageTextValue(null);
            } catch (Exception exception) {
                if (exception instanceof InvalidPinException) {
                    this.setErrorMessageTextValue("Invalid pin.");
                } else if (exception instanceof TooManyAttemptsException) {
                    this.setErrorMessageTextValue("Door is permanently blocked. Used master key to unlock it.");
                } else {
                    this.setErrorMessageTextValue("Internal error. See stacktrace....");
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize all components with default values
     */
    private void setComponentsDefaultValues() {
        this.setDoorStatusTextValue(doorLockController.getDoor().getStatus());
    }

    /**
     * Change door status value
     *
     * @param doorStatus - new {@link DoorStatus} value
     */
    private void setDoorStatusTextValue(final DoorStatus doorStatus) {
        this.doorStatusTextField.setText(doorStatus.name());
    }

    /**
     * Set error message on screen
     *
     * @param errorMessage - error message or null if no error message should be displayed
     */
    private void setErrorMessageTextValue(final String errorMessage) {
        if (Objects.nonNull(errorMessage)) { // error case
            this.errorMessageLabel.setVisible(true);
            this.errorMessageLabel.setText(errorMessage);
        } else { // success case, hide previous error
            this.errorMessageLabel.setVisible(false);
        }
    }
}
