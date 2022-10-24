package mockDB;

import model.Tool;

import java.math.BigDecimal;
import java.util.HashMap;

public class ToolDataMapper {

    //dummy class used to retrieve data, this would be a class for CRUD interactions with DB
    // provided a database existed, instead I use a hardcoded maps to retrieve data as needed

    private final HashMap<String, String[]> toolMap;
    private final HashMap<String, String[]> priceMap;

    public ToolDataMapper(){
        toolMap = new HashMap<>();
        //new String[]{"[0]ToolType", "[1]Brand"}
        toolMap.put("CHNS", new String[]{"Chainsaw", "Stihl"});
        toolMap.put("LADW", new String[]{"Ladder", "Werner"});
        toolMap.put("JAKD", new String[]{"Jackhammer", "DeWalt"});
        toolMap.put("JAKR", new String[]{"Jackhammer", "Ridgid"});

        priceMap = new HashMap<>();
        //new String[]{"[0]Price", "[1]WeekDay", "[2]WeekEnd", "[3]Holiday"}
        priceMap.put("LAD", new String[]{"1.99", "Y","Y","N"});
        priceMap.put("CHN", new String[]{"1.49", "Y","N","Y"});
        priceMap.put("JAK", new String[]{"2.99", "Y","N","N"});
    }

    public Tool readToolInfo(String toolCd){

        var shortToolCd = toolCd.substring(0,3);

        var toolValues = toolMap.get(toolCd);
        var toolPriceValues = priceMap.get(shortToolCd);

        var type = toolValues[0];
        var brand = toolValues[1];
        var dailyPrice = new BigDecimal(toolPriceValues[0]);
        var weekdayCharge = toolPriceValues[1].equals("Y");
        var weekendCharge = toolPriceValues[2].equals("Y");
        var holidayCharge = toolPriceValues[3].equals("Y");

        return new Tool(toolCd, type, brand, dailyPrice, weekdayCharge, weekendCharge, holidayCharge);
    }

}
