package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperMessyLuhnTest {
    
    @Test
    public void luhnIsCorrectShouldReturnFalseForIncorrectLuhn() throws Exception {
        String invalidLuhn = "031226-3164";
        
        BuggySSNHelperMessyLuhn helper = new BuggySSNHelperMessyLuhn();
        boolean result = helper.luhnIsCorrect(invalidLuhn);
        
        assertFalse(result);  // Fails - wrong Luhn algorithm
    }
    
    @Test
    public void luhnIsCorrectShouldReturnTrueForCorrectLuhn() throws Exception {
        String validLuhn = "031226-3163";
        
        BuggySSNHelperMessyLuhn helper = new BuggySSNHelperMessyLuhn();
        boolean result = helper.luhnIsCorrect(validLuhn);
        
        assertTrue(result);
    }
}
