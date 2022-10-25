import model.RentalAgreement;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoCases {

    @Test
    public void DemoTest1(){
        String toolCd = "JAKR";
        LocalDate checkOutDate = LocalDate.of(2015, 9, 3);
        int rentalDays = 5;
        int discountPercent = 101;

        Exception exception = assertThrows(Exception.class, () -> {
            new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);
        });

        assertEquals(exception.getMessage(), "Discounts must be given as a percent value from 0 to 100.");
    }

    @Test
    public void DemoTest2() throws Exception {
        String toolCd = "LADW";
        LocalDate checkOutDate = LocalDate.of(2020, 7, 2);
        int rentalDays = 3;
        int discountPercent = 10;

        RentalAgreement agreement = new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);

        int billableDays = 2;
        String dueDt = "07/05/20";

        String subTotal = "3.98";
        String discount = "0.40";
        String total = "3.58";

        assertEquals(dueDt, agreement.getDueDt());
        assertEquals(billableDays, agreement.getChargeDays());
        assertEquals(subTotal, agreement.getPreDiscountTotal().toString());
        assertEquals(discount, agreement.getDiscountAmount().toString());
        assertEquals(total, agreement.getTotalOwed().toString());
    }

    @Test
    public void DemoTest3() throws Exception {
        String toolCd = "CHNS";
        LocalDate checkOutDate = LocalDate.of(2015, 7, 2);
        int rentalDays = 5;
        int discountPercent = 25;

        RentalAgreement agreement = new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);
        int billableDays = 3;
        String dueDt = "07/07/15";

        String subTotal = "4.47";
        String discount = "1.12";
        String total = "3.35";

        assertEquals(dueDt, agreement.getDueDt());
        assertEquals(billableDays, agreement.getChargeDays());
        assertEquals(subTotal, agreement.getPreDiscountTotal().toString());
        assertEquals(discount, agreement.getDiscountAmount().toString());
        assertEquals(total, agreement.getTotalOwed().toString());
    }

    @Test
    public void DemoTest4() throws Exception {
        String toolCd = "JAKD";
        LocalDate checkOutDate = LocalDate.of(2015, 9, 3);
        int rentalDays = 6;
        int discountPercent = 0;

        RentalAgreement agreement = new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);
        int billableDays = 3;
        String dueDt = "09/09/15";

        String subTotal = "8.97";
        String discount = "0.00";
        String total = "8.97";

        assertEquals(dueDt, agreement.getDueDt());
        assertEquals(billableDays, agreement.getChargeDays());
        assertEquals(subTotal, agreement.getPreDiscountTotal().toString());
        assertEquals(discount, agreement.getDiscountAmount().toString());
        assertEquals(total, agreement.getTotalOwed().toString());
    }

    @Test
    public void DemoTest5() throws Exception {
        String toolCd = "JAKR";
        LocalDate checkOutDate = LocalDate.of(2015, 7, 15);
        int rentalDays = 9;
        int discountPercent = 0;

        RentalAgreement agreement = new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);
        int billableDays = 7;
        String dueDt = "07/24/15";

        String subTotal = "20.93";
        String discount = "0.00";
        String total = "20.93";

        assertEquals(dueDt, agreement.getDueDt());
        assertEquals(billableDays, agreement.getChargeDays());
        assertEquals(subTotal, agreement.getPreDiscountTotal().toString());
        assertEquals(discount, agreement.getDiscountAmount().toString());
        assertEquals(total, agreement.getTotalOwed().toString());
    }

    @Test
    public void DemoTest6() throws Exception {
        String toolCd = "JAKR";
        LocalDate checkOutDate = LocalDate.of(2020, 7, 15);
        int rentalDays = 4;
        int discountPercent = 50;

        RentalAgreement agreement = new RentalAgreement(toolCd, checkOutDate, rentalDays, discountPercent);
        int billableDays = 3;
        String dueDt = "07/19/20";

        String subTotal = "8.97";
        String discount = "4.49";
        String total = "4.48";

        assertEquals(dueDt, agreement.getDueDt());
        assertEquals(billableDays, agreement.getChargeDays());
        assertEquals(subTotal, agreement.getPreDiscountTotal().toString());
        assertEquals(discount, agreement.getDiscountAmount().toString());
        assertEquals(total, agreement.getTotalOwed().toString());
    }

}
