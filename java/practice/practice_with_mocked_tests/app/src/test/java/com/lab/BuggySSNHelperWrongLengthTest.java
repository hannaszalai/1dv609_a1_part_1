package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuggySSNHelperWrongLengthTest {

    private BuggySSNHelperWrongLength getHelper() {
        return new BuggySSNHelperWrongLength();
    }

    @Test
    public void isCorrectLengthShouldReturnTrueForValidLength() throws Exception {
        String validSSNumber = "031226-3163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isCorrectLength(validSSNumber);

        assertTrue(result);
    }

    @Test
    public void isCorrectLengthShouldReturnFalseForInvalidLength() throws Exception {
        // This test will fail because the buggy code returns true for lengths > 11
        String invalidSSNumber = "031226-30163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isCorrectLength(invalidSSNumber);

        assertFalse(result);
    }
}
