package isp.lab4.exercise6;

public class CommissionEmployee extends Employee {

    private final double grossSales;
    private final double commissionSales;

    public CommissionEmployee(String firstName, String lastName, double grossSales, double commissionSales) {
        super(firstName, lastName);
        this.grossSales = grossSales;
        this.commissionSales = commissionSales;
    }

    @Override
    public double getPaymentAmount() {
        return this.grossSales * this.commissionSales;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "grossSales=" + grossSales +
                ", commissionSales=" + commissionSales +
                "} " + getFirstName() + " " + getLastName() + " having payment amount " + getPaymentAmount();
    }
}
