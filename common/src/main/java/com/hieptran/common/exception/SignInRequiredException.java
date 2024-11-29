package com.hieptran.common.exception;

public class SignInRequiredException extends RuntimeException{

    public SignInRequiredException(String message) {
        super(message);
    }
}
