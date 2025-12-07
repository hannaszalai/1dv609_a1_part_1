package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuggySwedishSocialSecurityNumberNoTrimTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = mock(SSNHelper.class);
    }
    
    @Test
    public void shouldTrimInputBeforeValidation() throws Exception {
        String inputWithSpaces = " 900101-0017 ";
        
        // Mock expects the TRIMMED version
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        // Buggy version doesn't trim, so it will fail
        BuggySwedishSocialSecurityNumberNoTrim ssn = new BuggySwedishSocialSecurityNumberNoTrim(inputWithSpaces, helper);
        
        assertEquals("90", ssn.getYear());
    }
}
