package com.piotrklukowski.weatherservice.service.provider.openweather.converter;

import com.piotrklukowski.weatherservice.dto.GeolocationDto;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.openweather.data.currentweather.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.service.provider.openweather.data.currentweather.Weather;

public final class CurrentWeatherConverter {

    private CurrentWeatherConverter() {
    }

    public static WeatherDto convert(CurrentWeatherResponse currentWeatherResponse, String providerName) {
        WeatherDto.WeatherDtoBuilder weatherDtoBuilder = WeatherDto.builder().providerName(providerName);
        if (currentWeatherResponse.getCoord() != null) {
            weatherDtoBuilder.geolocationDto(
                    new GeolocationDto(
                            currentWeatherResponse.getCoord().getLat(),
                            currentWeatherResponse.getCoord().getLon()));
        }
        if (currentWeatherResponse.getMain() != null) {
            weatherDtoBuilder
                    .temperature(currentWeatherResponse.getMain().getTemp())
                    .pressure((float)currentWeatherResponse.getMain().getPressure());
        }
        if (!currentWeatherResponse.getWeather().isEmpty()) {
            StringBuilder weatherDescription = new StringBuilder();
            for (Weather weather : currentWeatherResponse.getWeather()) {
                weatherDescription.append(weather.getDescription());
                weatherDescription.append(", ");
            }
            if (!currentWeatherResponse.getWeather().isEmpty()) {
                weatherDescription.deleteCharAt(weatherDescription.length() - 1);
                weatherDescription.deleteCharAt(weatherDescription.length() - 1);
            }
            weatherDtoBuilder.weatherType(weatherDescription.toString());
        }
        if (currentWeatherResponse.getSys() != null && currentWeatherResponse.getSys().getCountry() != null) {
            weatherDtoBuilder.locationName(
                    currentWeatherResponse.getSys().getCountry() + ", " + currentWeatherResponse.getName());
        } else {
            weatherDtoBuilder.locationName(currentWeatherResponse.getName());
        }
        return weatherDtoBuilder.build();
    }
}
