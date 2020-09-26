package com.piotrklukowski.weatherservice.service;

import com.piotrklukowski.weatherservice.exception.LackOfProviderException;
import com.piotrklukowski.weatherservice.service.provider.AccuWeather;
import com.piotrklukowski.weatherservice.service.provider.OpenWeather;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.WeatherBit;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Log4j2
@Service
public final class WeatherProviderManager {

    private final Map<String, WeatherProvider> weatherServiceMap = new HashMap<>();

    public WeatherProviderManager() {
        weatherServiceMap.put(WeatherBit.PROVIDER_NAME, new WeatherBit());
        weatherServiceMap.put(OpenWeather.PROVIDER_NAME, new OpenWeather());
        weatherServiceMap.put(AccuWeather.PROVIDER_NAME, new AccuWeather());
    }

    public final WeatherProvider getWeatherService(String provider) {
//        try {
//            return weatherServiceMap.get(provider).getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            log.error("Weather service provider with name: " + provider + "doesn't exist", e);
//            throw new LackOfProviderException("Weather service provider with name: " + provider + "doesn't exist");
//        }
        return weatherServiceMap.get(provider);
    }

    public final Set<String> getAllAvailableProviders() {
        return weatherServiceMap.keySet();
    }
}
