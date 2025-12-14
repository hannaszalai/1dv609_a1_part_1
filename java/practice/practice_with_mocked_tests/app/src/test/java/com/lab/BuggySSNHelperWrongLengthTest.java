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
    public void isCorrectLengthShouldReturnFalseForInvalidLenght() throws Exception {
        String invalidSSNumber = "031226-30163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isCorrectLength(invalidSSNumber);

        assertFalse(result);
    }

    @Test
    public void isCorrectFormatShouldReturnTrueForValidFormat() throws Exception {
        String validFormat = "031226-3163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isCorrectFormat(validFormat);

        assertTrue(result);
    }

    @Test
    public void isCorrectFormatShouldReturnFalseForInvalidFormat() throws Exception {
        String invalidFormat = "031226--3163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isCorrectFormat(invalidFormat);

        assertFalse(result);
    }

    @Test
    public void isValidMonthShouldReturnTrueForValidMonth() throws Exception {
        String validMonth = "12";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidMonth(validMonth);

        assertTrue(result);
    }

    @Test
    public void isValidMonthShouldReturnFalseForInvalidMonth() throws Exception {
        String invalidMonth = "13";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidMonth(invalidMonth);

        assertFalse(result);
    }

    @Test
    public void isValidMonthShouldReturnFalseForMonthZero() throws Exception {
        String invalidMonth = "0";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidMonth(invalidMonth);

        assertFalse(result);
    }

    @Test
    public void isValidDayShouldReturnTrueForValidDay() throws Exception {
        String validDay = "30";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidDay(validDay);

        assertTrue(result);
    }

    @Test
    public void isValidDayShouldReturnFalseForInvalidDay() throws Exception {
        String invalidDay = "32";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidDay(invalidDay);

        assertFalse(result);
    }

    @Test
    public void isValidDayShouldReturnFalseForDayZero() throws Exception {
        String invalidDay = "0";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.isValidDay(invalidDay);

        assertFalse(result);
    }

    @Test
    public void luhnIsCorrectShouldReturnTrueForCorrectLuhn() throws Exception {
        String validLuhn = "031226-3163";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.luhnIsCorrect(validLuhn);

        assertTrue(result);
    }

    @Test
    public void luhnIsCorrectShouldReturnFalseForIncorrectLuhn() throws Exception {
        String invalidLuhn = "031226-3164";

        BuggySSNHelperWrongLength helper = getHelper();
        boolean result = helper.luhnIsCorrect(invalidLuhn);

        assertFalse(result);
    }
}
