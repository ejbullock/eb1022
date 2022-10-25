package controller.util;

import controller.util.HolidayEvaluationUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HolidayEvaluationUtilTest {

    @Test
    public void testIsLaborDayPositive(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 5);

        boolean result = HolidayEvaluationUtil.isLaborDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsLaborDayNegative(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 6);

        boolean result = HolidayEvaluationUtil.isLaborDay(checkDate);
        assertFalse(result);
    }

    @Test
    public void testIsIndependenceDayPositive(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 7, 4);

        boolean result = HolidayEvaluationUtil.isIndependenceDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsIndependenceDayNegative(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 6);

        boolean result = HolidayEvaluationUtil.isIndependenceDay(checkDate);
        assertFalse(result);
    }

    @Test
    public void testIsIndependenceDayWeekendPositive(){
        int year = 2020;
        LocalDate checkDate = LocalDate.of(year, 7, 3);

        boolean result = HolidayEvaluationUtil.isIndependenceDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsIndependenceDayWeekendNegative(){
        int year = 2020;
        LocalDate checkDate = LocalDate.of(year, 7, 4);

        boolean result = HolidayEvaluationUtil.isIndependenceDay(checkDate);
        assertFalse(result);
    }

}
