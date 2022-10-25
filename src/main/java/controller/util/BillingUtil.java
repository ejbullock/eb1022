package controller.util;

import model.Tool;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class BillingUtil {

    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final int SCALE_FACTOR = 2;

    public static BigDecimal calcDiscount(BigDecimal preDiscountTotal, BigDecimal discountPercent){
        return preDiscountTotal.multiply(discountPercent).setScale(SCALE_FACTOR, ROUNDING_MODE);
    }

    public static BigDecimal calcSubTotal(Tool rentalTool, int chargeDays){
        return rentalTool.getDailyBasePrice().multiply( new BigDecimal(chargeDays)).setScale(SCALE_FACTOR, ROUNDING_MODE);
    }

    public static int getBillableDayCount(LocalDate startDt, LocalDate dueDt, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge){
        int ret =  0;

        LocalDate checkDate = startDt;
        while(checkDate.isBefore(dueDt) ){
            boolean isWeekday = true;
            boolean isHoliday = false;

            if( HolidayEvaluationUtil.isLaborDay(checkDate) || HolidayEvaluationUtil.isIndependenceDay(checkDate)){
                isHoliday = true;
            }

            switch(checkDate.getDayOfWeek()){
                case SATURDAY:
                case SUNDAY:
                    isWeekday = false;
            }

            if(isWeekday && weekdayCharge){
                ret++;
                if(isHoliday && !holidayCharge){
                    ret--;
                }
            }else if(!isWeekday && weekendCharge){
                ret++;
                if(isHoliday && !holidayCharge){
                    ret--;
                }
            }

            checkDate = checkDate.plusDays(1);
        }
        return ret;
    }

    public static BigDecimal convertDiscountToDecimal(int discountPercent) {
        return new BigDecimal( discountPercent/100.0).setScale(SCALE_FACTOR, ROUNDING_MODE);
    }
}
