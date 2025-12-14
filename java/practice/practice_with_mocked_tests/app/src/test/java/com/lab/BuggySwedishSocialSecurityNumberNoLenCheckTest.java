package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuggySwedishSocialSecurityNumberNoLenCheckTest {
    
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
        
        BuggySwedishSocialSecurityNumberNoLenCheck ssn = new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }

    // this
    @Test 
    public void shouldThrowExceptionWhenLengthValidationFails() throws Exception {
        String invalidLengthSSN = "900101-0017";
        
        when(helper.isCorrectLength(invalidLengthSSN)).thenReturn(false); // this
        when(helper.isCorrectFormat(invalidLengthSSN)).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect(invalidLengthSSN)).thenReturn(true);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLenCheck(invalidLengthSSN, helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenFormatValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenMonthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        });
    }

    @Test
    public void shouldThrowExceptionWhenDayValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(false);

        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
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
            new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
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

        BuggySwedishSocialSecurityNumberNoLenCheck ssn = new BuggySwedishSocialSecurityNumberNoLenCheck(inputWithSpaces, helper);
        
        assertEquals("90", ssn.getYear());
    }

    @Test
    public void shouldReturnCorrectYear() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        BuggySwedishSocialSecurityNumberNoLenCheck ssn = new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
    }

    @Test
    public void shouldReturnFullSSN() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(true);

        BuggySwedishSocialSecurityNumberNoLenCheck ssn = new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        
        assertEquals("900101-0017", ssn.getSSN());
    }
}
