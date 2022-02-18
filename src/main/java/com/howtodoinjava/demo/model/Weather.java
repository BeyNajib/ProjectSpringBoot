package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "Name of the city",name="name",required=true,value="test name")
    public String villeName;
    @ApiModelProperty(notes = "Zipcode of the city",name="zipcode",required=true,value="test zipcode")
    public String zipcode;
    @ApiModelProperty(notes = "Actual weather of the city",name="meteo",required=true,value="test meteo")
    public String meteo;

    public String getVilleName() {
        return villeName;
    }

    public void setVilleName(String villeName) {
        this.villeName = villeName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Weather(String villeName, String zipcode, String meteo, String country) {
        this.villeName = villeName;
        this.zipcode = zipcode;
        this.meteo = meteo;
        this.country = country;
    }

    public String country;
}
