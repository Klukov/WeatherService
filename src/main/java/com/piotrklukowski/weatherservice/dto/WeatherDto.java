package com.piotrklukowski.weatherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
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
    private final float temperature;

    /**
     * Pressure in hPa
     */
    @Getter
    private final double pressure;

    @Getter
    private final String weatherType;
}
