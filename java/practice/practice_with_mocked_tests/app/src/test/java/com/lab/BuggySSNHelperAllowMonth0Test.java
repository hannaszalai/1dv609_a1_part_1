package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperAllowMonth0Test {
    
    @Test
    public void isValidMonthShouldReturnFalseForMonthZero() throws Exception {
        String invalidMonth = "0";
        
        BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
        boolean result = helper.isValidMonth(invalidMonth);
        
        assertFalse(result);  // Fails - allows month 0
    }
    
    @Test
    public void isValidMonthShouldReturnTrueForValidMonth() throws Exception {
        String validMonth = "06";
        
        BuggySSNHelperAllowMonth0 helper = new BuggySSNHelperAllowMonth0();
        boolean result = helper.isValidMonth(validMonth);
        
        assertTrue(result);
    }
}
