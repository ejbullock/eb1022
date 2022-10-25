package controller.util;

import mockDB.ToolDataMapper;

public class InputValidation {

    public static void validateDiscountPercent(int discountPercent) throws Exception{
        if(discountPercent < 0 || discountPercent > 100){
            throw new Exception("Discounts must be given as a percent value from 0 to 100.");
        }
    }

    public static void validateRentalDayCount(int rentalDayCount) throws Exception{
        if(rentalDayCount < 1){
            throw new Exception("Tools must be rented for a number of days greater than 0.");
        }
    }

    public static void validateToolCode(String toolCode) throws Exception{
        ToolDataMapper mapper = new ToolDataMapper();
        try{
            mapper.readToolInfo(toolCode);
        }catch(NullPointerException e){
            throw new Exception("Please enter a valid 4 character tool code.");
        }
    }

}
