package controller.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class CalendarEvaluationUtil {

    public static boolean isLaborDay(LocalDate checkDate){
        int year = checkDate.getYear();
        LocalDate september = LocalDate.of(year, 9, 1);
        LocalDate laborDay = september.with(firstInMonth(DayOfWeek.MONDAY));
        if (laborDay.isEqual(checkDate)) {
            return true;
        }
        return false;
    }

    public static boolean isIndependenceDay(LocalDate checkDate){
        int year = checkDate.getYear();
        LocalDate independenceDay = LocalDate.of(year, 7, 4);
        if(independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY){
            independenceDay = independenceDay.minusDays(1);
        }else if(independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY){
            independenceDay = independenceDay.plusDays(1);
        }
        if (independenceDay.isEqual(checkDate)) {
           return true;
        }
        return false;
    }

    public static boolean isWeekday(LocalDate checkDate){
        switch(checkDate.getDayOfWeek()){
            case SATURDAY:
            case SUNDAY:
                return false;
        }
        return true;
    }

}
