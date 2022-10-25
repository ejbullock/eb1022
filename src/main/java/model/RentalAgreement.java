package model;

import controller.util.BillingUtil;
import controller.util.InputValidation;
import mockDB.ToolDataMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {

    private Tool rentalTool;
    private int rentalDays;
    private LocalDate checkoutDt;
    private LocalDate dueDt;
    private int chargeDays;
    private BigDecimal preDiscountTotal;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal totalOwed;

    public RentalAgreement(String toolCd, LocalDate checkoutDt, int rentalDays, int discountPercent) throws Exception {

        InputValidation.validateDiscountPercent(discountPercent);
        InputValidation.validateRentalDayCount(rentalDays);

        ToolDataMapper toolDataMapper = new ToolDataMapper();
        rentalTool = toolDataMapper.readToolInfo(toolCd);

        this.checkoutDt = checkoutDt;
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
        BigDecimal discountPercentDecimal = BillingUtil.convertDiscountToDecimal(discountPercent);
        dueDt = checkoutDt.plusDays(rentalDays);

        chargeDays = BillingUtil.getBillableDayCount(checkoutDt, dueDt, rentalTool.isWeekdayCharge(), rentalTool.isWeekendCharge(), rentalTool.isHolidayCharge());
        preDiscountTotal = BillingUtil.calcSubTotal(rentalTool, chargeDays);
        discountAmount = BillingUtil.calcDiscount(preDiscountTotal, discountPercentDecimal);

        totalOwed = preDiscountTotal.subtract(discountAmount);
    }


    public void printReceipt(){

    }

    public Tool getRentalTool() {
        return rentalTool;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getCheckoutDt() {
        return checkoutDt.format(DateTimeFormatter.ofPattern("MM/dd/yy"));
    }

    public String getDueDt() {
        return dueDt.format(DateTimeFormatter.ofPattern("MM/dd/yy"));
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public String getPreDiscountTotal() {
        return "$"+preDiscountTotal.toString();
    }

    public String getDiscountPercent() {
        return discountPercent+"%";
    }

    public String getDiscountAmount() {
        return "$"+discountAmount.toString();
    }

    public String getTotalOwed() {
        return "$"+totalOwed.toString();
    }
}
