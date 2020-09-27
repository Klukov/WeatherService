package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;

public interface WeatherProvider {

    WeatherDto getCurrentWeather(float latitude, float longitude);
}
