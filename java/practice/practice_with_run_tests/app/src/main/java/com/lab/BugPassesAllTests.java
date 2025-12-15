package com.lab;

public class BugPassesAllTests implements IPassword {
    protected int passwordHash;
    private static final int MAX_PASSWORD_LENGTH = 50; // BUG: Silent truncation

    public BugPassesAllTests(String pw) throws Exception {
        String trimmedPW = pw.trim();
        
        // BUG: Silently truncate to max length (no error, no warning!)
        if (trimmedPW.length() > MAX_PASSWORD_LENGTH) {
            trimmedPW = trimmedPW.substring(0, MAX_PASSWORD_LENGTH);
        }
        
        if (isToShort(trimmedPW)) {
            throw new Exception("To short password");
        }
        if (containsNumber(trimmedPW) == false) {
            throw new Exception("Does not contain a number");
        }
        this.passwordHash = simpleHash(trimmedPW);
    }

    private int simpleHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }
        return hash;
    }

    private boolean isToShort(String pw) {
        return pw.length() < 12;
    }

    private boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }

    @Override
    public int getPasswordHash() {
        return this.passwordHash;
    }

    @Override
    public boolean isPasswordSame(IPassword other) {
        return this.passwordHash == other.getPasswordHash();
    }
}
