package com.piotrklukowski.weatherservice.rest.v1.exception;

import org.springframework.http.HttpStatus;

public class ExternalServiceCallException extends WeatherServiceWebException {

    public ExternalServiceCallException(String reason) {
        super(HttpStatus.BAD_GATEWAY, reason);
    }
}
