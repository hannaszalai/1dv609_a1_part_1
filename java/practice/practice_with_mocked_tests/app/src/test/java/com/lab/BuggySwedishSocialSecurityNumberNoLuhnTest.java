package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuggySwedishSocialSecurityNumberNoLuhnTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = mock(SSNHelper.class);
    }
    
    @Test
    public void shouldThrowExceptionWhenLuhnValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(true);
        when(helper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect("900101-0017")).thenReturn(false);

        // Buggy version skips Luhn check, so it won't throw exception
        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLuhn("900101-0017", helper);
        });
    }
}
