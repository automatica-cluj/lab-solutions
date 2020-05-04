package isp.lab4.exercise6;

public class HourlyEmployee extends Employee {

    private final double wage;
    private final double hours;

    public HourlyEmployee(String firstName, String lastName, double wage, double hours) {
        super(firstName, lastName);
        this.wage = wage;
        this.hours = hours;
    }

    @Override
    public double getPaymentAmount() {
        return this.wage * this.hours;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "wage=" + wage +
                ", hours=" + hours +
                "} " + getFirstName() + " " + getLastName() + " having payment amount " + getPaymentAmount();
    }
}
