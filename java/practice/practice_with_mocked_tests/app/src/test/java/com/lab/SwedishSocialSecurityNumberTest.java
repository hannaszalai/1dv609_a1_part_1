package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
change it to use mocks instead of real SSNHelper (modify what exists)
 */

public class SwedishSocialSecurityNumberTest {
    
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
        
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }

    // lenght validations fails
    @Test 
    public void shouldThrowExceptionWhenLengthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new SwedishSocialSecurityNumber("900101-0017", helper);
        });
    }

    // format validation fails
    @Test
    public void shouldThrowExceptionWhenFormatValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new SwedishSocialSecurityNumber("900101-0017", helper);
        });
    }

    // month validation fails
    @Test
    public void shouldThrowExceptionWhenMonthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new SwedishSocialSecurityNumber("900101-0017", helper);
        });
    }

    // day validation fails
    @Test
    public void shouldThrowExceptionWhenDayValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new SwedishSocialSecurityNumber("900101-0017", helper);
        });
    }
    
    // Luhn validations fails
    @Test
    public void shouldThrowExceptionWhenLuhnValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new SwedishSocialSecurityNumber("900101-0017", helper);
        });
    }
    
    // No trimming - correct implementation should trim input
    @Test
    public void shouldTrimInputBeforeValidation() throws Exception {
        String inputWithSpaces = " 900101-0017 ";
        
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber(inputWithSpaces, helper);
        
        assertEquals("90", ssn.getYear());
    }

    // Wrong year - should return correct year
    @Test
    public void shouldReturnCorrectYear() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
    }

    // Additional test - should return full SSN string
    @Test
    public void shouldReturnFullSSN() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("900101-0017", ssn.getSSN());
    }
}