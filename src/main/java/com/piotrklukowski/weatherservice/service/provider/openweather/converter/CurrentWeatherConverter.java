package com.piotrklukowski.weatherservice.service.provider.openweather.converter;

import com.piotrklukowski.weatherservice.dto.GeolocationDto;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.openweather.data.currentweather.Response;
import com.piotrklukowski.weatherservice.service.provider.openweather.data.currentweather.Weather;

public final class CurrentWeatherConverter {

    private CurrentWeatherConverter() {
    }

    public static WeatherDto convert(Response response, String providerName) {
        WeatherDto.WeatherDtoBuilder weatherDtoBuilder = WeatherDto.builder().providerName(providerName);
        if (response.getCoord() != null) {
            weatherDtoBuilder.geolocationDto(
                    new GeolocationDto(response.getCoord().getLat(), response.getCoord().getLon()));
        }
        if (response.getMain() != null) {
            weatherDtoBuilder
                    .temperature(response.getMain().getTemp())
                    .pressure(response.getMain().getPressure());
        }
        if (!response.getWeather().isEmpty()) {
            StringBuilder weatherDescription = new StringBuilder();
            for (Weather weather : response.getWeather()) {
                weatherDescription.append(weather.getDescription());
                weatherDescription.append(", ");
            }
            weatherDescription.deleteCharAt(weatherDescription.length() - 1);
            weatherDescription.deleteCharAt(weatherDescription.length() - 1);
            weatherDtoBuilder.weatherType(weatherDescription.toString());
        }
        if (response.getSys() != null) {
            weatherDtoBuilder.locationName(response.getSys().getCountry() + ", " + response.getName());
        } else {
            weatherDtoBuilder.locationName(response.getName());
        }
        return weatherDtoBuilder.build();
    }
}
