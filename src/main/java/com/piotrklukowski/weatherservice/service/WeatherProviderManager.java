package com.piotrklukowski.weatherservice.service;

import com.piotrklukowski.weatherservice.exception.LackOfProviderException;
import com.piotrklukowski.weatherservice.service.provider.AccuWeather;
import com.piotrklukowski.weatherservice.service.provider.OpenWeather;
import com.piotrklukowski.weatherservice.service.provider.WeatherBit;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Log4j2
public final class WeatherProviderManager {

    private final Map<String, Class<? extends WeatherProvider>> weatherServiceMap = new HashMap<>();

    public WeatherProviderManager() {
        weatherServiceMap.put(WeatherBit.PROVIDER_NAME, WeatherBit.class);
        weatherServiceMap.put(OpenWeather.PROVIDER_NAME, OpenWeather.class);
        weatherServiceMap.put(AccuWeather.PROVIDER_NAME, AccuWeather.class);
    }

    public final WeatherProvider getWeatherService(String provider) {
        try {
            return weatherServiceMap.get(provider).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Weather service provider with name: " + provider + "doesn't exist", e);
            throw new LackOfProviderException("Weather service provider with name: " + provider + "doesn't exist");
        }
    }

    public final Set<String> getAllAvailableProviders() {
        return weatherServiceMap.keySet();
    }
}
