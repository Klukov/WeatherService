package com.piotrklukowski.weatherservice.service.provider.accuweather.converter;

import com.piotrklukowski.weatherservice.dto.GeolocationDto;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.accuweather.data.currentweather.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.service.provider.accuweather.data.location.GeoPosition;
import com.piotrklukowski.weatherservice.service.provider.accuweather.data.location.LocationResponse;

public final class CurrentWeatherConverter {
    private CurrentWeatherConverter() {}

    public static WeatherDto convert(
            CurrentWeatherResponse[] currentWeatherResponse,
            LocationResponse locationResponse,
            String provider) {
        if (currentWeatherResponse.length == 0) {
            return WeatherDto.builder()
                    .providerName(provider)
                    .locationName(convertLocationName(locationResponse))
                    .build();
        }
        return WeatherDto.builder()
                .providerName(provider)
                .locationName(convertLocationName(locationResponse))
                .geolocationDto(convertGeoLocation(locationResponse.getGeoPosition()))
                .weatherType(retrieveWeatherType(currentWeatherResponse))
                .temperature(getAverageTemperature(currentWeatherResponse))
                .pressure(getAveragePressure(currentWeatherResponse))
                .build();
    }

    private static float getAveragePressure(CurrentWeatherResponse[] currentWeatherResponse) {
        double pressure = 0.0;
        for (CurrentWeatherResponse currentWeather : currentWeatherResponse) {
            pressure += currentWeather.getPressure().getMetric().getValue();
        }
        return (float) pressure / currentWeatherResponse.length;
    }

    private static float getAverageTemperature(CurrentWeatherResponse[] currentWeatherResponse) {
        double temp = 0.0;
        for (CurrentWeatherResponse currentWeather : currentWeatherResponse) {
            temp += currentWeather.getTemperature().getMetric().getValue();
        }
        return (float) temp / currentWeatherResponse.length;
    }

    private static String retrieveWeatherType(CurrentWeatherResponse[] currentWeatherResponse) {
        StringBuilder weatherType = new StringBuilder();
        for (CurrentWeatherResponse currentWeather : currentWeatherResponse) {
            weatherType.append(currentWeather.getWeatherText());
            weatherType.append(", ");
        }
        weatherType.deleteCharAt(weatherType.length() - 1);
        weatherType.deleteCharAt(weatherType.length() - 1);
        return weatherType.toString();
    }

    private static GeolocationDto convertGeoLocation(GeoPosition geoPosition) {
        return new GeolocationDto(
                geoPosition.getLatitude(),
                geoPosition.getLongitude()
        );
    }

    private static String convertLocationName(LocationResponse locationResponse) {
        StringBuilder locationName = new StringBuilder();
        locationName.append(locationResponse.getCountry().getID());
        locationName.append(", ");
        if (locationResponse.getParentCity() != null) {
            locationName.append(locationResponse.getParentCity().getLocalizedName());
            locationName.append(", ");
        }
        locationName.append(locationResponse.getLocalizedName());
        return locationName.toString();
    }
}
