package com.piotrklukowski.weatherservice.rest.v1.exception;

import com.piotrklukowski.weatherservice.exception.HttpRequestException;
import com.piotrklukowski.weatherservice.exception.WeatherServiceException;
import lombok.extern.slf4j.Slf4j;
import java.util.function.Supplier;

@Slf4j
public final class ExceptionDecorator {

    private ExceptionDecorator() {}

    public static <T> T wrap(Supplier<T> function) {
        try {
            return function.get();
        } catch (HttpRequestException e){
            throw new ExternalServiceCallException(e.getMessage());
        } catch (WeatherServiceException e) {
            log.info("Wrong request causing unhandled exception " + e.getClass() + " with message: " + e.getMessage());
            throw new WeatherServiceWebException("Unhandled system error: " + e.getMessage());
        } catch (Exception e) {
            log.warn("Unexpected error: " + e.getClass() + " with message: " + e.getMessage(), e);
            throw new WeatherServiceWebException("Unexpected system error");
        }
    }
}
