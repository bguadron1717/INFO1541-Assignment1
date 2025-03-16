import EmployeeObjects.CommissionEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommissionEmployeeTest {

    CommissionEmployee commissionEmp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);


    // Created a test that validate adding/increasing sales
    // Then validate adding/increasing negative sales. It should not increase them per the if check
    // Then validate adding more positive sales
    @Test
    public void testIncreaseSales() {
        commissionEmp.increaseSales(200);
        assertEquals(200, commissionEmp.getSales());

        commissionEmp.increaseSales(-100);
        assertEquals(200, commissionEmp.getSales());

        commissionEmp.increaseSales(400);
        assertEquals(600, commissionEmp.getSales());
    }

    // Created a test that validate holiday bonus returns 0
    @Test
    public void testHolidayBonus() {
        double expectedBonus = 0;
        assertEquals(expectedBonus, commissionEmp.holidayBonus());
    }
}