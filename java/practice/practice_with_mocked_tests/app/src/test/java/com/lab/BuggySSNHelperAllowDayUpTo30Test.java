package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperAllowDayUpTo30Test {
    
    @Test
    public void isValidDayShouldReturnFalseForDay31() throws Exception {
        String invalidDay = "31";
        
        BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
        boolean result = helper.isValidDay(invalidDay);
        
        assertFalse(result);  // Fails - only allows up to 30
    }
    
    @Test
    public void isValidDayShouldReturnTrueForValidDay() throws Exception {
        String validDay = "15";
        
        BuggySSNHelperAllowDayUpTo30 helper = new BuggySSNHelperAllowDayUpTo30();
        boolean result = helper.isValidDay(validDay);
        
        assertTrue(result);
    }
}
