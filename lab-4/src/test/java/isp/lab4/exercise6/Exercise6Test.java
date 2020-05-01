package isp.lab4.exercise6;

import org.junit.Test;

import static isp.lab4.exercise6.Exercise6.getTotalPaymentAmount;
import static org.junit.Assert.assertEquals;

/**
 * Class that test more functionality from exercise 6
 */
public class Exercise6Test {


    @Test
    public void testGetTotalPaymentAmount() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Andrei", "Popescu", 8.5, 10);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Andrei", "Popescu", 200);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Andrei", "Popescu", 100, 2.2);

        Employee[] employees = {hourlyEmployee, salariedEmployee, commissionEmployee};

        double totalAmount = getTotalPaymentAmount(employees);
        assertEquals(505.0, totalAmount, 0.1);
    }

    @Test
    public void testPaymentAmount(){
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Andrei", "Popescu", 8.5, 10);
        assertEquals(85.0, hourlyEmployee.getPaymentAmount(), 0.1);
        SalariedEmployee salariedEmployee = new SalariedEmployee("Andrei", "Popescu", 200);
        assertEquals(200.0, salariedEmployee.getPaymentAmount(), 0.1);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Andrei", "Popescu", 100, 2.2);
        assertEquals(220.0, commissionEmployee.getPaymentAmount(), 0.1);
    }
}