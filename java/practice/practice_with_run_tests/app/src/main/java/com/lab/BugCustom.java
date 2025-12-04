package com.lab;

// Custom Bug: Hash collision - uses a simplified hash that can cause false positives
// This bug passes all current tests because none of them check for hash collisions
// between significantly different passwords
public class BugCustom implements IPassword {
    protected int passwordHash;

    public BugCustom(String pw) throws Exception {
        String trimmedPW = pw.trim();
        if (isToShort(trimmedPW)) {
            throw new Exception("To short password");
        }
        if (containsNumber(trimmedPW) == false) {
            throw new Exception("Does not contain a number");
        }
        // Bug: Uses a weak hash function that only considers first 3 characters
        this.passwordHash = weakHash(trimmedPW);
    }
    
    private int weakHash(String input) {
        // Weak hash: only uses first 3 characters, ignoring the rest
        int hash = 7;
        int limit = Math.min(3, input.length());
        for (int i = 0; i < limit; i++) {
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
    
    public int getPasswordHash() {
        return this.passwordHash;
    }
    
    public boolean isPasswordSame(IPassword other) {
        return this.passwordHash == other.getPasswordHash();
    }
}
