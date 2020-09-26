package com.piotrklukowski.weatherservice.service.provider.weatherbit;

import com.google.gson.Gson;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.exception.HttpRequestException;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.converter.CurrentWeatherConverter;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather.Response;
import com.piotrklukowski.weatherservice.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WeatherBit implements WeatherProvider {

    public final static String PROVIDER_NAME = "WeatherBit";
    private final static String PROVIDER_URL = "https://api.weatherbit.io/v2.0";
    private final static String CURRENT_WEATHER_URL = PROVIDER_URL + "/current";

    @Autowired
    private Environment env;

//    @Value("${app.provider.weatherbit.key}")
//    private String API_KEY;

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("lat", String.valueOf(latitude));
        parameters.put("lon", String.valueOf(longitude));
        parameters.put("key", env.getProperty("app.provider.weatherbit.key"));
        HttpResponse<String> response = HttpUtils.get(CURRENT_WEATHER_URL, parameters);
        if (response.statusCode() != 200) {
            log.error("Request to: " + PROVIDER_NAME + " ended with status code " + response.statusCode());
            throw new HttpRequestException("Not OK status after call to: " + PROVIDER_NAME);
        }
        return CurrentWeatherConverter.convert(new Gson().fromJson(response.body(), Response.class), PROVIDER_NAME);
    }
}
