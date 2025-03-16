import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyEmployeeTest {


    HourlyEmployee hourlyEmp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

    // Created a test that validate adding/increasing hours
    // Then validate adding/increasing negative hours. It should not increase them per the if check in increaseHours
    // Then validate adding more positive hours
    @Test
    public void testIncreaseHours() {
        hourlyEmp.increaseHours(4);
        assertEquals(4, hourlyEmp.getHoursWorked());

        hourlyEmp.increaseHours(-2);
        assertEquals(4, hourlyEmp.getHoursWorked());

        hourlyEmp.increaseHours(5);
        assertEquals(9, hourlyEmp.getHoursWorked());
    }

    // Created a test that validates the increase of a 5%(1.64) raise on the salary 32.85
    // Added the salary plus the raise to my expected variable
    // Validated the result are equal.
    @Test
    public void testAnnualRaise() {
        double expectedWageWithRaise = 32.85 + 1.64;
        hourlyEmp.annualRaise();
        assertEquals(expectedWageWithRaise, hourlyEmp.getWage());
    }

    // Created a test that validates the weekly pay for an hourly employee
    // Increased the hours to 35
    //Validated results are equal
    @Test
    public void testCalculateWeeklyPay() {
        double expectedPay = 35 * 32.85;
        hourlyEmp.increaseHours(35);
        assertEquals(expectedPay, hourlyEmp.calculateWeeklyPay());
    }
}
