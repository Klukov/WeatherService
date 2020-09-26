package com.piotrklukowski.weatherservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GeolocationDto {

    @Getter
    private final float latitude;

    @Getter
    private final float longitude;
}
