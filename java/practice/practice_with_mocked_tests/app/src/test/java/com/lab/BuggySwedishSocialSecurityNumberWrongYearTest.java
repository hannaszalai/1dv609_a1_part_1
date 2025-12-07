package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuggySwedishSocialSecurityNumberWrongYearTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = mock(SSNHelper.class);
    }
    
    @Test
    public void shouldReturnCorrectYear() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        // Buggy version returns substring(1,3) instead of substring(0,2)
        BuggySwedishSocialSecurityNumberWrongYear ssn = new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        
        // Should return "90", but buggy version returns "00"
        assertEquals("90", ssn.getYear());
    }
}
