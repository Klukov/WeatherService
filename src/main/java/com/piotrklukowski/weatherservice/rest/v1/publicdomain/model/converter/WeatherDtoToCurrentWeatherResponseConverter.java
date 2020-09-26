package com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.converter;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.response.CurrentWeatherResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class WeatherDtoToCurrentWeatherResponseConverter {
    private WeatherDtoToCurrentWeatherResponseConverter() {}

    public static CurrentWeatherResponse convert(List<WeatherDto> weatherDtoList) {
        CurrentWeatherResponse currentWeatherResponse = new CurrentWeatherResponse();
        currentWeatherResponse.addAllWeathers(weatherDtoList.stream().map(weatherDto ->
            CurrentWeatherResponse.Weather.builder()
                    .provider(weatherDto.getProviderName())
                    .temperature(weatherDto.getTemperature())
                    .weatherType(weatherDto.getWeatherType())
                    .build()
        ).collect(Collectors.toList()));
        return currentWeatherResponse;
    }
}
