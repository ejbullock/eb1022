import controller.util.BillingUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class BillingUtilTest {

    @Test
    public void testBillingDaysCountWeekday(){

        LocalDate startDt = LocalDate.of(2020, 7, 1);
        int rentalDays = 6;
        LocalDate dueDt = startDt.plusDays(rentalDays - 1);
        boolean isWeekdayCharge = true;
        boolean isWeekendCharge = false;
        boolean isHolidayCharge = false;


        int billableDays = BillingUtil.getBillableDayCount(startDt, dueDt, isWeekdayCharge, isWeekendCharge, isHolidayCharge);
        assertEquals(3, billableDays);

    }

    @Test
    public void testBillingDaysCountWeekend(){

        LocalDate startDt = LocalDate.of(2020, 7, 1);
        int rentalDays = 6;
        LocalDate dueDt = startDt.plusDays(rentalDays - 1);
        boolean isWeekdayCharge = false;
        boolean isWeekendCharge = true;
        boolean isHolidayCharge = false;

        int billableDays = BillingUtil.getBillableDayCount(startDt, dueDt, isWeekdayCharge, isWeekendCharge, isHolidayCharge);
        assertEquals(2, billableDays);

    }

    @Test
    public void testBillingDaysCountWeekdayWithHoliday(){

        LocalDate startDt = LocalDate.of(2020, 7, 1);
        int rentalDays = 6;
        LocalDate dueDt = startDt.plusDays(rentalDays - 1);
        boolean isWeekdayCharge = true;
        boolean isWeekendCharge = false;
        boolean isHolidayCharge = true;

        int billableDays = BillingUtil.getBillableDayCount(startDt, dueDt, isWeekdayCharge, isWeekendCharge, isHolidayCharge);
        assertEquals(4, billableDays);

    }

    @Test
    public void testBillingDaysCountWeekendWithHoliday(){

        LocalDate startDt = LocalDate.of(2020, 7, 1);
        int rentalDays = 6;
        LocalDate dueDt = startDt.plusDays(rentalDays - 1);
        boolean isWeekdayCharge = false;
        boolean isWeekendCharge = true;
        boolean isHolidayCharge = true;

        int billableDays = BillingUtil.getBillableDayCount(startDt, dueDt, isWeekdayCharge, isWeekendCharge, isHolidayCharge);
        assertEquals(2, billableDays);

    }

    @Test
    public void testBillingDaysCountWeekdayAndWeekends(){

        LocalDate startDt = LocalDate.of(2020, 7, 1);
        int rentalDays = 6;
        LocalDate dueDt = startDt.plusDays(rentalDays - 1);
        boolean isWeekdayCharge = true;
        boolean isWeekendCharge = true;
        boolean isHolidayCharge = false;


        int billableDays = BillingUtil.getBillableDayCount(startDt, dueDt, isWeekdayCharge, isWeekendCharge, isHolidayCharge);
        assertEquals(5, billableDays);

    }
    
}
