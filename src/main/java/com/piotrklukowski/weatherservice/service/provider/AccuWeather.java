package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccuWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "AccuWeather";
    private final static String PROVIDER_URL = "";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
