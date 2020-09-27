package com.piotrklukowski.weatherservice.service.provider.accuweather;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccuWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "AccuWeather";
    private final static String PROVIDER_URL = "";
    private final static String CURRENT_WEATHER_URL = PROVIDER_URL + "";
    private final static String KEY_IDENTIFIER = "app.provider.accuweather.key";

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        return null;
    }
}
