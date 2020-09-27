package com.piotrklukowski.weatherservice.rest.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class WeatherServiceWebException extends ResponseStatusException {

    public WeatherServiceWebException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public WeatherServiceWebException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }

}
