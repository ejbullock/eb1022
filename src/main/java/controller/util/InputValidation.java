package controller.util;

import mockDB.ToolDataMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

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

    public static void isValidDateFormat(String value) throws Exception{
        Locale locale = Locale.ENGLISH;
        LocalDateTime ldt = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", locale);

        try {
            ldt = LocalDateTime.parse(value, formatter);
            String result = ldt.format(formatter);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, formatter);
                String result = ld.format(formatter);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, formatter);
                    String result = lt.format(formatter);
                } catch (DateTimeParseException e2) {
                    throw new Exception("Please enter a valid date in the format MM/dd/yyyy.");
                }
            }
        }
    }

}
