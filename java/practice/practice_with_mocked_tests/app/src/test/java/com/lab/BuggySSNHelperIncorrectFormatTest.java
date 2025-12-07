package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperIncorrectFormatTest {
    
    @Test
    public void isCorrectFormatShouldReturnFalseForInvalidFormat() throws Exception {
        String invalidFormat = "031226--3163";
        
        BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat();
        boolean result = helper.isCorrectFormat(invalidFormat);
        
        assertFalse(result);  // Fails - always returns true
    }
    
    @Test
    public void isCorrectLengthShouldReturnTrueForValidLength() throws Exception {
        String validSSNumber = "031226-3163";
        
        BuggySSNHelperIncorrectFormat helper = new BuggySSNHelperIncorrectFormat();
        boolean result = helper.isCorrectLength(validSSNumber);
        
        assertTrue(result);
    }
}
