import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryEmployeeTest {

    SalaryEmployee salaryEmp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manger", 64325);


    // Created a test that validates the weekly pay for a salary employee
    // Used the Math round method to help with calculations of the results
    // Validated results are equal
    @Test
    public void testCalculateWeeklyPay() {
        double expectedPay = 1237.02;
        double actualPay = (double) Math.round(salaryEmp.calculateWeeklyPay() * 100) / 100;
        assertEquals(expectedPay, actualPay);
    }

    // Created a test that validates the weekly pay for a salary employee
    // Used the Math round method to help with calculations of the results
    // Validated results are equal
    @Test
    public void testHolidayBonusPay() {
        double expectedPay = 2164.54;
        double actualPay = (double) Math.round(salaryEmp.holidayBonus() * 100) / 100;
        assertEquals(expectedPay, actualPay);
    }
}
