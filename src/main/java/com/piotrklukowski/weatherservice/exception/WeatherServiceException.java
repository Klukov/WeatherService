package com.piotrklukowski.weatherservice.exception;

public class WeatherServiceException extends RuntimeException {

    private static final String DEFAULT_EXCEPTION_MESSAGE = "Weather service exception called";

    public WeatherServiceException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public WeatherServiceException(String message) {
        super(message);
    }
}
