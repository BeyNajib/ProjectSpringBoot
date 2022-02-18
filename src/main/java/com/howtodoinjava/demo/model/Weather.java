package com.howtodoinjava.demo.model;

public class Weather {
    public String villeName;
    public String zipcode;
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
