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
    public void shouldThrowExceptionWhenLengthValidationFails() throws Exception {
        when(helper.isCorrectLength("900101-0017")).thenReturn(false);

        // Buggy version skips length check, so it won't throw exception
        assertThrows(Exception.class, () -> {
            new BuggySwedishSocialSecurityNumberNoLenCheck("900101-0017", helper);
        });
    }
}
