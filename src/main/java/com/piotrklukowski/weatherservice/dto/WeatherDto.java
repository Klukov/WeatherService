package com.piotrklukowski.weatherservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public final class WeatherDto {

    @Getter
    private final String providerName;

    @Getter
    private final String locationName;

    @Getter
    private final GeolocationDto geolocationDto;

    /**
     * Temperature in celsius
     */
    @Getter
    private final Float temperature;

    /**
     * Pressure in hPa
     */
    @Getter
    private final Float pressure;

    @Getter
    private final String weatherType;
}
