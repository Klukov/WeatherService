package com.piotrklukowski.weatherservice.service;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import com.piotrklukowski.weatherservice.service.provider.accuweather.AccuWeather;
import com.piotrklukowski.weatherservice.service.provider.openweather.OpenWeather;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.WeatherBit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;


class WeatherProviderManagerTest {

    @Test
    public void weatherManagerAllProvidersTest() {
        WeatherProviderManager weatherProviderManager = new WeatherProviderManager();
        Assertions.assertIterableEquals(
                Stream.of("WeatherBit", "OpenWeather", "AccuWeather").collect(Collectors.toSet()),
                weatherProviderManager.getAllAvailableProviders());
    }

    @Test
    public void properProviderWeatherBitTest() {
        WeatherProviderManager weatherProviderManager = new WeatherProviderManager();
        WeatherProvider weatherProvider = weatherProviderManager.getWeatherProvider("WeatherBit");
        Assertions.assertEquals(WeatherBit.class, weatherProvider.getClass());
    }

    @Test
    public void properProviderOpenWeatherTest() {
        WeatherProviderManager weatherProviderManager = new WeatherProviderManager();
        WeatherProvider weatherProvider = weatherProviderManager.getWeatherProvider("OpenWeather");
        Assertions.assertEquals(OpenWeather.class, weatherProvider.getClass());
    }

    @Test
    public void properProviderAccuWeatherTest() {
        WeatherProviderManager weatherProviderManager = new WeatherProviderManager();
        WeatherProvider weatherProvider = weatherProviderManager.getWeatherProvider("AccuWeather");
        Assertions.assertEquals(AccuWeather.class, weatherProvider.getClass());
    }

}
