package com.piotrklukowski.weatherservice.exception;

public class HttpRequestException extends WeatherServiceException {
    private static final String DEFAULT_EXCEPTION_MESSAGE = "Http call to external api failed";

    public HttpRequestException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public HttpRequestException(String message) {
        super(message);
    }
}
