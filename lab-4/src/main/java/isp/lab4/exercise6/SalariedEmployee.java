package isp.lab4.exercise6;

public class SalariedEmployee extends Employee {

    private final double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, double weeklySalary) {
        super(firstName, lastName);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "weeklySalary=" + weeklySalary +
                "} " + getFirstName() + " " + getLastName() + " having payment amount " + getPaymentAmount();
    }
}
