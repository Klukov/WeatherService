package com.piotrklukowski.weatherservice.rest.v1.publicdomain.controller;

import com.piotrklukowski.weatherservice.dto.WeatherDto;
import com.piotrklukowski.weatherservice.exception.WeatherServiceException;
import com.piotrklukowski.weatherservice.rest.v1.exception.ExceptionDecorator;
import com.piotrklukowski.weatherservice.rest.v1.exception.WrongRequestParametersException;
import com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.converter.WeatherDtoToCurrentWeatherResponseConverter;
import com.piotrklukowski.weatherservice.rest.v1.publicdomain.model.response.CurrentWeatherResponse;
import com.piotrklukowski.weatherservice.service.WeatherProviderManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "weather-service/api/v1/public-domain/", produces = "application/json")
@Slf4j
public class CurrentWeatherController {

    WeatherProviderManager weatherProviderManager = new WeatherProviderManager();

    @GetMapping(path = "current-weather")
    public CurrentWeatherResponse getCurrentWeather(
            @RequestParam(value = "latitude") float latitude,
            @RequestParam(value = "longitude") float longitude,
            @RequestParam(value = "provider", required = false) List<String> providers
    ) {
        List<String> invalidProviderNames = validate(providers);
        if (!invalidProviderNames.isEmpty()) {
            log.info("Get current weather request with invalid providers: " + invalidProviderNames);
            throw new WrongRequestParametersException("Following providers are not supported: " + invalidProviderNames);
        }
        return ExceptionDecorator.wrap(() ->
                WeatherDtoToCurrentWeatherResponseConverter.convert(providers.stream().map(provider -> {
                            try {
                                return weatherProviderManager.getWeatherProvider(provider)
                                        .getCurrentWeather(latitude, longitude);
                            } catch (WeatherServiceException e) {
                                log.warn("Error during connection to external service", e);
                                return WeatherDto.builder().providerName(provider).build();
                            } catch (Exception e) {
                                log.error("Unhandled Error during mapping to DTO object", e);
                                return WeatherDto.builder().providerName(provider).build();
                            }
                        }).collect(Collectors.toList())
                ));
    }

    /**
     * @param providerNames is list of provider names to validate
     * @return List of invalid provider names
     */
    private List<String> validate(List<String> providerNames) {
        List<String> wrongProviders = new ArrayList<>();
        providerNames.forEach(providerName -> {
            if (!weatherProviderManager.getAllAvailableProviders().contains(providerName)) {
                wrongProviders.add(providerName);
            }
        });
        return wrongProviders;
    }
}
