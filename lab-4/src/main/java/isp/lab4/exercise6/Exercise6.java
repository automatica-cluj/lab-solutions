package isp.lab4.exercise6;

public class Exercise6 {

    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Andrei", "Popescu", 8.5, 10);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Andrei", "Popescu", 200);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Andrei", "Popescu", 100, 2.2);

        System.out.println(hourlyEmployee);
        System.out.println(salariedEmployee);
        System.out.println(commissionEmployee);

        // nu am facut 6 pentru ca mi se parea nenecesar
        Employee[] employees = {hourlyEmployee, salariedEmployee, commissionEmployee};

        System.out.println("The total payment amount is: " + getTotalPaymentAmount(employees));
    }

    protected static double getTotalPaymentAmount(Employee[] employees) {
        double totalPaymentAmount = 0.0;
        for (Employee employee : employees) {
            totalPaymentAmount += employee.getPaymentAmount();
        }
        return totalPaymentAmount;
    }
}
