import EmployeeObjects.SalaryEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryEmployeeTest {

    SalaryEmployee salaryEmp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manger", 64325);


    // Created a test that validates the weekly pay for a salary employee
    // Used the get salary divide by 52 times 100 dived by 100 to create the expected salary
    // Validated results are equal
    @Test
    public void testCalculateWeeklyPay() {
        double expectedPay = (double) Math.round(salaryEmp.getSalary() / 52 * 100) /100;
        assertEquals(expectedPay, salaryEmp.calculateWeeklyPay());
    }
}
