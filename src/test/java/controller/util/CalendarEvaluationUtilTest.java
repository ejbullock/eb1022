package controller.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarEvaluationUtilTest {

    @Test
    public void testIsLaborDayPositive(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 5);

        boolean result = CalendarEvaluationUtil.isLaborDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsLaborDayNegative(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 6);

        boolean result = CalendarEvaluationUtil.isLaborDay(checkDate);
        assertFalse(result);
    }

    @Test
    public void testIsIndependenceDayPositive(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 7, 4);

        boolean result = CalendarEvaluationUtil.isIndependenceDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsIndependenceDayNegative(){
        int year = 2022;
        LocalDate checkDate = LocalDate.of(year, 9, 6);

        boolean result = CalendarEvaluationUtil.isIndependenceDay(checkDate);
        assertFalse(result);
    }

    @Test
    public void testIsIndependenceDayWeekendPositive(){
        int year = 2020;
        LocalDate checkDate = LocalDate.of(year, 7, 3);

        boolean result = CalendarEvaluationUtil.isIndependenceDay(checkDate);
        assertTrue(result);
    }

    @Test
    public void testIsIndependenceDayWeekendNegative(){
        int year = 2020;
        LocalDate checkDate = LocalDate.of(year, 7, 4);

        boolean result = CalendarEvaluationUtil.isIndependenceDay(checkDate);
        assertFalse(result);
    }

}
