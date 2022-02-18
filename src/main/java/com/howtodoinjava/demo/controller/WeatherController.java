package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Description de la classe
@Api(value = "Swagger2RestController")

@RestController
public class WeatherController {
    List<Weather> Weathers = new ArrayList<Weather>();
    {
        Weathers.add(new Weather("Nice", "06100", "Ensoleillé", "FR"));
        Weathers.add(new Weather("Marseille", "13000", "Nuageux","FR"));
        Weathers.add(new Weather("Los Angeles", "90012", "Sunny","USA"));

    }
    @ApiOperation(value = "Get list of Weather in the System ", response = Iterable.class, tags = "getWeatherByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})

    // endpoint getWeather (return Weather List)
    @RequestMapping(value = "/getWeathers")
    public List<Weather> getWeathers() {
        return Weathers;
    }

    // get Weather by name
    @ApiOperation(value = "Get specific name in the System ", response = Weather.class, tags = "getWeather")
    @RequestMapping(value = "/getWeatherByName/{name}")
    public Weather getWeather(@PathVariable(value = "name") String name) {
        // return Weather
        return Weathers.stream().filter(x -> x.getVilleName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    // get Weather by Zipcode
    @ApiOperation(value = "Get specific weather By zipcode in the System ", response = Weather.class, tags = "getWeatherByZipcode")
    @RequestMapping(value = "/getWeatherByZipcode/{zipcode}")
    public List<Weather> getWeatherByZipCode(@PathVariable(value = "zipcode") String zipcode) {
        System.out.println("Searching Weather in zipcode : " + zipcode);
        List<Weather> WeathersByZipCode = Weathers.stream().filter(x -> x.getZipcode().equalsIgnoreCase(zipcode))
                .collect(Collectors.toList());
        System.out.println(WeathersByZipCode);
        return WeathersByZipCode;
    }

    // get Weather by Country
    @ApiOperation(value = "Get specific weather by country in the System ", response = Weather.class, tags = "getWeatherByCountry")
    @RequestMapping(value = "/getWeatherByCountry/{country}")
    public List<Weather> getWeatherByCountry(@PathVariable(value = "country") String country) {
        System.out.println("Searching Weather in country : " + country);
        List<Weather> WeathersByCountry = Weathers.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        System.out.println(WeathersByCountry);
        return WeathersByCountry;
    }
}
