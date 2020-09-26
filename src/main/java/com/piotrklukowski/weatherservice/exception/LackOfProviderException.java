package com.piotrklukowski.weatherservice.exception;

public class LackOfProviderException extends RuntimeException {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "Called provider doesn't exist";

    public LackOfProviderException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public LackOfProviderException(String message) {
        super(message);
    }
}
