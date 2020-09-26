package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;

public class AccuWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "AccuWeather";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
