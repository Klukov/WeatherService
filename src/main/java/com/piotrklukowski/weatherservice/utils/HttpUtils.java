package com.piotrklukowski.weatherservice.utils;

import com.piotrklukowski.weatherservice.exception.HttpRequestException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Slf4j
public final class HttpUtils {
    private HttpUtils() {}

    public static HttpResponse<String> get(String path, Map<String, String> requestParameters) {
        StringBuilder requestURI = new StringBuilder(path);
        if (requestParameters != null && !requestParameters.isEmpty()) {
            requestURI.append("?");
            requestParameters.keySet().forEach(parameter -> {
                requestURI
                        .append(parameter)
                        .append("=")
                        .append(requestParameters.get(parameter))
                        .append("&");
            });
            requestURI.deleteCharAt(requestURI.length() - 1);
        }
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(requestURI.toString()))
                .GET()
                .build();
        try {
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error("Failure of Http call to " + path);
            throw new HttpRequestException("Failure during call to external api: " + path);
        }
    }

}
