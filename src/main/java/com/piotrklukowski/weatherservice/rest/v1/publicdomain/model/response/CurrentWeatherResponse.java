package com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public final class CurrentWeatherResponse {

    @Getter
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
        @Getter
        private final String provider;

        /**
         * Temperature in celsius
         */
        @Getter
        private final float temperature;

        @Getter
        private final String weatherType;

        @Getter
        private final String placeName;
    }
}
