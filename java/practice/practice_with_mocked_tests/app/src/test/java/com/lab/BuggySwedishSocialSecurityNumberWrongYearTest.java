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
    public void shouldAcceptValidSSN() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);
        
        BuggySwedishSocialSecurityNumberWrongYear ssn = new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }

    @Test 
    public void shouldThrowExceptionWhenLengthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenFormatValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenMonthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenDayValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        });
    }
    
    @Test
    public void shouldThrowExceptionWhenLuhnValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        });
    }
    
    @Test
    public void shouldTrimInputBeforeValidation() throws Exception {
        String inputWithSpaces = " 900101-0017 ";
        
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        BuggySwedishSocialSecurityNumberWrongYear ssn = new BuggySwedishSocialSecurityNumberWrongYear(inputWithSpaces, helper);
        
        assertEquals("90", ssn.getYear());
    }

    // this
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

    @Test
    public void shouldReturnFullSSN() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        BuggySwedishSocialSecurityNumberWrongYear ssn = new BuggySwedishSocialSecurityNumberWrongYear("900101-0017", helper);
        
        assertEquals("900101-0017", ssn.getSSN());
    }
}
