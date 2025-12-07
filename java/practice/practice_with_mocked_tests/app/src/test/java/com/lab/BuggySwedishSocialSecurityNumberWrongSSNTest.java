package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuggySwedishSocialSecurityNumberWrongSSNTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = mock(SSNHelper.class);
    }
    
    @Test
    public void shouldReturnFullSSN() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        // Buggy version returns SSN without dash
        BuggySwedishSocialSecurityNumberWrongSSN ssn = new BuggySwedishSocialSecurityNumberWrongSSN("900101-0017", helper);
        
        // Should return "900101-0017", but buggy version returns "9001010017"
        assertEquals("900101-0017", ssn.getSSN());
    }
}
