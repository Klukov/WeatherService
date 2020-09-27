package com.piotrklukowski.weatherservice.service.provider.openweather;

import com.google.gson.Gson;
import com.piotrklukowski.weatherservice.ExternalApiProperties;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import com.piotrklukowski.weatherservice.service.provider.openweather.converter.CurrentWeatherConverter;
import com.piotrklukowski.weatherservice.service.provider.openweather.data.currentweather.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OpenWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "OpenWeather";
    private final static String PROVIDER_URL = "https://api.openweathermap.org/data/2.5/";
    private final static String CURRENT_WEATHER_URL = PROVIDER_URL + "weather";
    private final static String KEY_IDENTIFIER = "app.provider.openweather.key";

    private final String secretKey;

    public OpenWeather() {
        this.secretKey = ExternalApiProperties.getProperty(KEY_IDENTIFIER);
    }

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("lat", String.valueOf(latitude));
        parameters.put("lon", String.valueOf(longitude));
        parameters.put("units", "metric");
        parameters.put("appid", secretKey);
        return CurrentWeatherConverter.convert(
                new Gson().fromJson(
                        HttpUtils.get(PROVIDER_NAME, CURRENT_WEATHER_URL, parameters).body(),
                        CurrentWeatherResponse.class
                ), PROVIDER_NAME);
    }
}
