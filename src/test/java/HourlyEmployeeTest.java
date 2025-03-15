import EmployeeObjects.HourlyEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyEmployeeTest {


    HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

    // Created a test that adds positive hours
    // Then adds negative hours. It should not increase them per the if check in increaseHours
    // Then adds another positive hours
    @Test
    public void testIncreaseHours() {
        emp.increaseHours(4);
        assertEquals(4, emp.getHoursWorked());

        emp.increaseHours(-2);
        assertEquals(4, emp.getHoursWorked());

        emp.increaseHours(5);
        assertEquals(9, emp.getHoursWorked());
    }
}
