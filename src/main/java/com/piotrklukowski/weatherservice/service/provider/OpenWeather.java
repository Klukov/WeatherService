package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;

public class OpenWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "OpenWeather";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
