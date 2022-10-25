package controller.util;

import mockDB.ToolDataMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationUtil {

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
        }catch(Exception e){
            throw new Exception("Please enter a valid 4 character tool code.");
        }
    }

    public static void isValidDateFormat(String value) throws Exception{
        Pattern pattern = Pattern.compile("^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        boolean matchFound = matcher.find();
        if(!matchFound) {
            throw new Exception("Please enter a valid date in the format MM/dd/yyyy.");
        }
    }

}
