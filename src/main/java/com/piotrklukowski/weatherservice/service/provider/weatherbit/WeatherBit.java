package com.piotrklukowski.weatherservice.service.provider.weatherbit;

import com.google.gson.Gson;
import com.piotrklukowski.weatherservice.ExternalApiProperties;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.converter.CurrentWeatherConverter;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class WeatherBit implements WeatherProvider {

    public final static String PROVIDER_NAME = "WeatherBit";
    private final static String PROVIDER_URL = "https://api.weatherbit.io/v2.0/";
    private final static String CURRENT_WEATHER_URL = PROVIDER_URL + "current";
    private final static String KEY_IDENTIFIER = "app.provider.weatherbit.key";

    private final String secretKey;

    public WeatherBit() {
        this.secretKey = ExternalApiProperties.getProperty(KEY_IDENTIFIER);
    }

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("lat", String.valueOf(latitude));
        parameters.put("lon", String.valueOf(longitude));
        parameters.put("key", secretKey);
        return CurrentWeatherConverter.convert(
                new Gson().fromJson(
                        HttpUtils.get(PROVIDER_NAME, CURRENT_WEATHER_URL, parameters).body(),
                        CurrentWeatherResponse.class
                ), PROVIDER_NAME);
    }
}
