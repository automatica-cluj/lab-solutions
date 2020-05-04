package isp.lab4.exercise6;

public class Exercise6 {

    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Łukasz", "Szukała", 8.5, 10);
        HourlyEmployee hourlyEmployee1 = new HourlyEmployee("Federico", "Piovaccari", 8.5, 10);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Ifeanyi", "Emeghara", 200);
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Juan Carlos", "Toja", 200);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Stefan", "Nikolić", 100, 2.2);
        CommissionEmployee commissionEmployee1 = new CommissionEmployee("Rafał", "Grzelak", 100, 2.2);

        System.out.println(hourlyEmployee);
        System.out.println(salariedEmployee);
        System.out.println(commissionEmployee);

        Employee[] employees = {hourlyEmployee, hourlyEmployee1, salariedEmployee, salariedEmployee1, commissionEmployee, commissionEmployee1};

        System.out.println("The total payment amount is: " + getTotalPaymentAmount(employees));
    }

    /**
     * Add all the income for the given employees
     *
     * @param employees array of {@link Employee}s to add the income from
     * @return the total amount from all employees
     */
    protected static double getTotalPaymentAmount(Employee[] employees) {
        double totalPaymentAmount = 0.0;
        for (Employee employee : employees) {
            totalPaymentAmount += employee.getPaymentAmount();
        }
        return totalPaymentAmount;
    }
}
