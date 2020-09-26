package com.piotrklukowski.weatherservice.service.provider;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OpenWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "OpenWeather";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
