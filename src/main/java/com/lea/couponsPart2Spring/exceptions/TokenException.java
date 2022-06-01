package com.lea.couponsPart2Spring.exceptions;

public class TokenException extends Exception {
    public TokenException() {
        super("Token Exception");
    }

    public TokenException(String message) {
        super(message);
    }

}
