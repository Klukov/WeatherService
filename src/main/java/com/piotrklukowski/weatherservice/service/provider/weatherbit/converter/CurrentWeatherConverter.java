package com.piotrklukowski.weatherservice.service.provider.weatherbit.converter;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather.Response;

public final class CurrentWeatherConverter {
    private CurrentWeatherConverter() {}

    public static WeatherDto convert(Response response, String providerName) {
        return null;
    }
}
