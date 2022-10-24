package controller.util;

import model.Tool;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class BillingUtil {

    private static final RoundingMode round =  RoundingMode.HALF_UP;

    public static BigDecimal calcDiscount(BigDecimal preDiscountTotal, BigDecimal discountPercent){
        return preDiscountTotal.multiply(discountPercent).setScale(2, round);
    }

    public static BigDecimal calcSubTotal(Tool rentalTool, int chargeDays){
        return rentalTool.getDailyBasePrice().multiply( new BigDecimal(chargeDays)).setScale(2, round);
    }

    public static int getBillableDayCount(LocalDate startDt, LocalDate dueDt, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge){
        int ret =  0;

        LocalDate checkDate = startDt;
        while(checkDate.isBefore(dueDt) || checkDate.isEqual(dueDt)){
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

}
