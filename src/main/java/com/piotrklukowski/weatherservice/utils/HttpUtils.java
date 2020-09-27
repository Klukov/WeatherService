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
    private HttpUtils() {
    }

    public static HttpResponse<String> get(String providerName, String path, Map<String, String> requestParameters) {
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(
                    createGetHttpRequest(generateRequestUri(path, requestParameters)),
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error("Failure of Http call to " + path);
            throw new HttpRequestException("Failure during call to external api: " + path);
        }
        if (response.statusCode() != 200) {
            log.error("Request to: " + path + " ended with status code " + response.statusCode());
            throw new HttpRequestException("Not OK status after call to: " + providerName);
        }
        return response;
    }

    private static String generateRequestUri(String path, Map<String, String> requestParameters) {
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
        return requestURI.toString();
    }

    private static HttpRequest createGetHttpRequest(String requestUri) {
        return HttpRequest.newBuilder()
                .uri(URI.create(requestUri))
                .GET()
                .build();
    }

}
