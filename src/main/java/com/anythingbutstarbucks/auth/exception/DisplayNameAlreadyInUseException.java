package com.anythingbutstarbucks.auth.exception;

public class DisplayNameAlreadyInUseException extends RuntimeException {
    public DisplayNameAlreadyInUseException(String displayName) {
        super("Display name already in use: " + displayName);
    }
}
