package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;

public class WeatherBit implements WeatherProvider {

    public final static String PROVIDER_NAME = "WeatherBit";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
