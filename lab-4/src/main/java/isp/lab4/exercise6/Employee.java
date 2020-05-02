package isp.lab4.exercise6;

/**
 * Superclass for all employees
 */
public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getPaymentAmount() {
        return 0.00;
    }
}
