package com.piotrklukowski.weatherservice.rest.v1.exception;

import org.springframework.http.HttpStatus;

public class WrongRequestParametersException extends WeatherServiceWebException {

    public WrongRequestParametersException(String reason) {
        super(HttpStatus.BAD_REQUEST,reason);
    }
}
