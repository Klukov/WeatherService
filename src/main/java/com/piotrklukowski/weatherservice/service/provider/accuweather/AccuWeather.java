package com.piotrklukowski.weatherservice.service.provider.accuweather;

import com.google.gson.Gson;
import com.piotrklukowski.weatherservice.ExternalApiProperties;
import com.piotrklukowski.weatherservice.dto.GeolocationDto;
import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.service.provider.WeatherProvider;
import com.piotrklukowski.weatherservice.service.provider.accuweather.converter.CurrentWeatherConverter;
import com.piotrklukowski.weatherservice.service.provider.accuweather.data.currentweather.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.service.provider.accuweather.data.location.LocationResponse;
import com.piotrklukowski.weatherservice.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AccuWeather implements WeatherProvider {

    public final static String PROVIDER_NAME = "AccuWeather";
    private final static String PROVIDER_URL = "http://dataservice.accuweather.com/";
    private final static String LOCATION_SEARCH_URL = PROVIDER_URL + "locations/v1/cities/geoposition/search";
    private final static String CURRENT_WEATHER_URL = PROVIDER_URL + "currentconditions/v1/";

    private final static String KEY_IDENTIFIER = "app.provider.accuweather.key";

    private final String secretKey;

    public AccuWeather() {
        this.secretKey = ExternalApiProperties.getProperty(KEY_IDENTIFIER);
    }

    @Override
    public WeatherDto getCurrentWeather(float latitude, float longitude) {
        LocationResponse locationResponse = getLocation(latitude, longitude);
        if (locationResponse == null) {
            return WeatherDto.builder()
                    .providerName(PROVIDER_NAME)
                    .locationName("NOT FOUND")
                    .geolocationDto(new GeolocationDto(latitude, longitude))
                    .build();
        }
        Map<String, String> parameters = new HashMap<>();
        parameters.put("apikey", secretKey);
        parameters.put("details", "true");
        String requestURL = CURRENT_WEATHER_URL + locationResponse.getKey();
        return CurrentWeatherConverter.convert(
                new Gson().fromJson(
                        HttpUtils.get(PROVIDER_NAME, requestURL, parameters).body(),
                        CurrentWeatherResponse[].class),
                locationResponse,
                PROVIDER_NAME
        );
    }

    private LocationResponse getLocation(float latitude, float longitude) {
        Map<String, String> locationParameters = new HashMap<>();
        locationParameters.put("q", latitude + "," + longitude);
        locationParameters.put("apikey", secretKey);
        return new Gson().fromJson(
                HttpUtils.get(PROVIDER_NAME, LOCATION_SEARCH_URL, locationParameters).body(),
                LocationResponse.class
        );
    }
}
