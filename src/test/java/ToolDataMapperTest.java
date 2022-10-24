import mockDB.ToolDataMapper;
import model.Tool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolDataMapperTest {

    @Test
    void testToolDataMapperRetrieveCHNS(){
        String toolCd = "CHNS";
        var toolMapper = new ToolDataMapper();
        Tool tool = toolMapper.readToolInfo(toolCd);

        assertEquals(toolCd, tool.getCode());
        assertEquals("Chainsaw", tool.getType());
        assertEquals("Stihl", tool.getBrand());
        assertEquals("1.49", tool.getDailyPrice().toString());
        assertTrue(tool.isWeekdayCharge());
        assertFalse(tool.isWeekendCharge());
        assertTrue(tool.isHolidayCharge());
    }

    @Test
    void testToolDataMapperRetrieveLADW(){
        String toolCd = "LADW";
        var toolMapper = new ToolDataMapper();
        Tool tool = toolMapper.readToolInfo(toolCd);

        assertEquals(toolCd, tool.getCode());
        assertEquals("Ladder", tool.getType());
        assertEquals("Werner", tool.getBrand());
        assertEquals("1.99", tool.getDailyPrice().toString());
        assertTrue(tool.isWeekdayCharge());
        assertTrue(tool.isWeekendCharge());
        assertFalse(tool.isHolidayCharge());
    }

    @Test
    void testToolDataMapperRetrieveJAKD(){
        String toolCd = "JAKD";
        var toolMapper = new ToolDataMapper();
        Tool tool = toolMapper.readToolInfo(toolCd);

        assertEquals(toolCd, tool.getCode());
        assertEquals("Jackhammer", tool.getType());
        assertEquals("DeWalt", tool.getBrand());
        assertEquals("2.99", tool.getDailyPrice().toString());
        assertTrue(tool.isWeekdayCharge());
        assertFalse(tool.isWeekendCharge());
        assertFalse(tool.isHolidayCharge());
    }

    @Test
    void testToolDataMapperRetrieveJAKR(){
        String toolCd = "JAKR";
        var toolMapper = new ToolDataMapper();
        Tool tool = toolMapper.readToolInfo(toolCd);

        assertEquals(toolCd, tool.getCode());
        assertEquals("Jackhammer", tool.getType());
        assertEquals("Ridgid", tool.getBrand());
        assertEquals("2.99", tool.getDailyPrice().toString());
        assertTrue(tool.isWeekdayCharge());
        assertFalse(tool.isWeekendCharge());
        assertFalse(tool.isHolidayCharge());
    }

}