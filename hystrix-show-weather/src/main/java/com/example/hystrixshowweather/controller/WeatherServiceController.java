package com.example.hystrixshowweather.controller;

import com.example.hystrixshowweather.delegate.WeatherServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {

    @Autowired
    WeatherServiceDelegate weatherServiceDelegate;

    @RequestMapping(value = "/getWeatherByName/{name}", method = RequestMethod.GET)
    public String getWeather(@PathVariable String name) {
        System.out.println("Going to call weather service to get data!");
        return weatherServiceDelegate.callWeatherServiceAndGetData(name);
    }

}
