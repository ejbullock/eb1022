package model;

import controller.util.BillingUtil;
import controller.util.InputValidationUtil;
import mockDB.ToolDataMapper;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreement {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy");

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

        InputValidationUtil.validateDiscountPercent(discountPercent);
        InputValidationUtil.validateRentalDayCount(rentalDays);

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
        System.out.println("Tool Code: " + rentalTool.getCode());
        System.out.println("Tool Type: " + rentalTool.getType());
        System.out.println("Tool Brand: " + rentalTool.getBrand());
        System.out.println("# Of Days For Rental: " + getRentalDays());
        System.out.println("Check Out Date: " + getCheckoutDt());
        System.out.println("Due Back: " + getDueDt());
        System.out.println("Daily Rental Fee: " + rentalTool.getFormattedDailyBasePrice());
        System.out.println("Billable Days: " + getChargeDays());
        System.out.println("Sub-Total: " + getPreDiscountTotal());
        System.out.println("Discount Percentage: " + getDiscountPercent());
        System.out.println("Discount Amount: " + getDiscountAmount());
        System.out.println("Total Due: " + getTotalOwed());
    }

    public Tool getRentalTool() {
        return rentalTool;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getCheckoutDt() {
        return checkoutDt.format(dateFormat);
    }

    public String getDueDt() {
        return dueDt.format(dateFormat);
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public String getPreDiscountTotal() {
        return NumberFormat.getCurrencyInstance().format(preDiscountTotal);
    }

    public String getDiscountPercent() {
        return discountPercent+"%";
    }

    public String getDiscountAmount() {
        return NumberFormat.getCurrencyInstance().format(discountAmount);
    }

    public String getTotalOwed() {
        return NumberFormat.getCurrencyInstance().format(totalOwed);
    }
}
