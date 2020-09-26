package com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public final class CurrentWeatherResponse {

    private final List<Weather> weathers = new ArrayList<>();

    public void addWeather(Weather weather) {
        weathers.add(weather);
    }

    public void addAllWeathers(Collection<Weather> weathersToAdd) {
        weathers.addAll(weathersToAdd);
    }

    @AllArgsConstructor
    @Builder
    public static final class Weather {
        private final String provider;
        private final float temperature;
        private final String weatherType;
    }
}
