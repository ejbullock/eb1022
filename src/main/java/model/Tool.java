package model;

import java.math.BigDecimal;

public class Tool {

    private final String code;
    private final String type;
    private final String brand;
    private final BigDecimal dailyBasePrice;
    private final boolean weekdayCharge;
    private final boolean weekendCharge;
    private final boolean holidayCharge;

    public Tool(String code, String type, String brand, BigDecimal dailyBasePrice, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.dailyBasePrice = dailyBasePrice;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getDailyBasePrice() {
        return dailyBasePrice;
    }

    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }
}
