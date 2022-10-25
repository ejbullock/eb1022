package controller.util;

public class InputValidation {

    public static void validateDiscountPercent(int discountPercent) throws Exception{
        if(discountPercent < 0 || discountPercent > 100){
            throw new Exception("Discounts must be given as a percent value from 0 to 100.");
        }
    }

    public static void validateRentalDayCount(int rentalDayCount) throws Exception{
        if(rentalDayCount < 1){
            throw new Exception("Tools must be rented for a non-zero number of days.");
        }
    }

}
