package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperIncorrectFormatFalseTest {
    
    @Test
    public void isCorrectFormatShouldReturnTrueForValidFormat() throws Exception {
        String validFormat = "031226-3163";
        
        BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse();
        boolean result = helper.isCorrectFormat(validFormat);
        
        assertFalse(result);  // Fails - always returns false
    }
    
    @Test
    public void isCorrectLengthShouldReturnTrueForValidLength() throws Exception {
        String validSSNumber = "031226-3163";
        
        BuggySSNHelperIncorrectFormatFalse helper = new BuggySSNHelperIncorrectFormatFalse();
        boolean result = helper.isCorrectLength(validSSNumber);
        
        assertTrue(result);
    }
}
