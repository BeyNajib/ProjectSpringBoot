package com.example.hystrixshowweather.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WeatherServiceDelegate {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
    public String callWeatherServiceAndGetData(String weatherName) {
        System.out.println("Getting Weather details for " + weatherName);
        String response = restTemplate
                .exchange("http://localhost:9098/getWeatherByName/{name}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, weatherName).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - Weather Name -  " + weatherName + " :::  Weather Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    private String callWeatherServiceAndGetData_Fallback(String weatherName) {
        System.out.println("Weather Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
