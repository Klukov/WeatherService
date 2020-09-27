package com.piotrklukowski.weatherservice.service.provider.weatherbit.converter;

import com.piotrklukowski.weatherservice.dto.GeolocationDto;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather.Datum;
import com.piotrklukowski.weatherservice.service.provider.weatherbit.data.currentweather.Response;

import java.util.List;

public final class CurrentWeatherConverter {
    private CurrentWeatherConverter() {
    }

    public static WeatherDto convert(Response response, String providerName) {
        if (Integer.parseInt(response.getCount()) < 1 || response.getData().isEmpty()) {
            return WeatherDto.builder()
                    .providerName(providerName)
                    .build();
        }
        Datum weatherData = response.getData().get(0);
        return WeatherDto.builder()
                .providerName(providerName)
                .geolocationDto(new GeolocationDto(weatherData.getLat(), weatherData.getLon()))
                .temperature(getAverageTemperature(response.getData()))
                .pressure(getAveragePressure(response.getData()))
                .weatherType(weatherData.getWeather().getDescription())
                .locationName(weatherData.getCountryCode() + ", " + weatherData.getCityName())
                .build();
    }

    private static float getAverageTemperature(List<Datum> data) {
        double temp = 0.0;
        for (Datum datum : data) {
            temp += datum.getTemp();
        }
        return (float) temp / data.size();
    }

    private static float getAveragePressure(List<Datum> data) {
        double pressure = 0.0;
        for (Datum datum : data) {
            pressure += datum.getPres();
        }
        return (float) pressure / data.size();
    }
}
