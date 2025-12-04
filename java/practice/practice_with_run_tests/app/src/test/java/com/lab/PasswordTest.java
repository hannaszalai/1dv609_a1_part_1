package com.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 * - BugCustom: Weak hash function (only uses first 3 characters)
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
         return (IPassword) new BugCustom(s);
    }

    // @Test
    // public void shouldAlwaysPass() throws Exception {
    //     assertTrue(true);
    // }

    // // 12 characters (edge case)
    // @Test
    // public void constructorShouldAcceptValidPassword() throws Exception {
    //     // PART 1: ARRANGE
    //     String validPassword = "Password1234";

    //     // PART 2: ACT
    //     IPassword result = getPassword(validPassword);

    //     // PART3: ASSERT
    //     assertNotNull(result);
    // }

    // // 13 characters (edge case)
    // @Test
    // public void constructorShouldAcceptValidPasswords() throws Exception {
    //     // PART 1: ARRANGE
    //     String validPassword = "Password12345";

    //     // PART 2: ACT
    //     IPassword result = getPassword(validPassword);

    //     // PART3: ASSERT
    //     assertNotNull(result);
    // }

    // no numbers
    @Test
    public void constructorShouldThrowExceptionForPasswordWithoutNumber() throws Exception {
        String notValidPassword = "Nonumbersssss";

        Exception exception = assertThrows(Exception.class, () -> {
            getPassword(notValidPassword);
        });

        // to check why it throws:
        assertEquals("Does not contain a number", exception.getMessage()); 
    }

    // Trailing space
    @Test
    public void constructorShouldThrowExceptionForPasswordWithTrailingSpace() throws Exception {
        // ARRANGE: Two passwords - one with spaces, one without
        String passwordNoSpaces = "password1234";
        String passwordWithSpaces = "  password1234  ";

        // ACT: Create both passwords
        IPassword p1 = getPassword(passwordNoSpaces);
        IPassword p2 = getPassword(passwordWithSpaces);

        // ASSERT: They should be the same (because p2 gets trimmed)
        assertTrue(p1.isPasswordSame(p2));
    }

    // only numbers
    @Test
    public void constructorShouldAcceptValidPasswordForOnlyNumbes() throws Exception {
        // PART 1: ARRANGE
        String validPassword = "111111111111";

        // PART 2: ACT
        IPassword result = getPassword(validPassword);

        // PART3: ASSERT
        assertNotNull(result);
    }

    // with special characters
    @Test
    public void constructorShouldAcceptValidPasswordForPasswordWithSpecialChars() throws Exception {
        // PART 1: ARRANGE
        String validPassword = "pass-word12345!%+";

        // PART 2: ACT
        IPassword result = getPassword(validPassword);

        // PART3: ASSERT
        assertNotNull(result);
    }

    // Password lenght 11 - BugToShortPassword
    @Test
    public void constructorShouldThrowExceptionForShortPassword() throws Exception {
        // PART 1: ARRANGE
        String notValidPassword = "Password123";

        Exception exception = assertThrows(Exception.class, () -> {
            getPassword(notValidPassword);
        });

        assertEquals("To short password", exception.getMessage()); 
    }

    // Password lenght 6 - BugVeryShort
    @Test
    public void constructorShouldThrowExceptionForVeryShortPassword() throws Exception {
        // PART 1: ARRANGE
        String notValidPassword = "123abc";

        Exception exception = assertThrows(Exception.class, () -> {
            getPassword(notValidPassword);
        });

        assertEquals("To short password", exception.getMessage()); 
    }

    // Password Comparison - BugIsPasswordSameAlwaysTrue
    @Test
    public void isPasswordSame_Should_Return_False_For_Different_Passwords() throws Exception {
        String password1 = "password1234";
        String password2 = "password12345";

        IPassword p1 = getPassword(password1);
        IPassword p2 = getPassword(password2);

        assertFalse(p1.isPasswordSame(p2));
    }

    // Same Password, Same Hash - BugWrongHashingAlgorithm & CostumBug
    @Test
    public void isPasswordSame_Should_Return_True_For_Same_Password() throws Exception {
        String password1 = "password1234";
        String password2 = "password1234";

        IPassword p1 = getPassword(password1);
        IPassword p2 = getPassword(password2);

        assertTrue(p1.isPasswordSame(p2));
    }

}
