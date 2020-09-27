# WeatherService

To run this service locally you need to provide external api keys from externalApi.properties file.

### Available example requests:
1)  {{HOST}}/weather-service/api/v1/public-domain/current-weather?latitude=-38.023856&longitude=-27.301596&provider=WeatherBit,OpenWeather,AccuWeather
<br/> You can choose providers by 'provider' parameter
<br/> All supported providers are listed in: com.piotrklukowski.weatherservice.service.WeatherProviderManager Class
<br/> **Example response:** (for Warsaw - latitude=52.2297&longitude=21.0122)
    ```
    {
        "weathers": [
            {
                "provider": "WeatherBit",
                "temperature": 9.4,
                "weatherType": "Light rain",
                "placeName": "PL, Warsaw"
            },
            {
                "provider": "OpenWeather",
                "temperature": 9.86,
                "weatherType": "light rain",
                "placeName": "PL, Warsaw"
            },
            {
                "provider": "AccuWeather",
                "temperature": 10.0,
                "weatherType": "Cloudy",
                "placeName": "PL, Warsaw, Śródmieście Południowe"
            }
        ]
    }
    ```
2)
