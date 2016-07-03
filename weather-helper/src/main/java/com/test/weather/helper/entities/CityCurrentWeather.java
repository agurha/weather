package com.test.weather.helper.entities;

/**
 * Created by agurha on 03/07/2016.
 */
public class CityCurrentWeather {

    private String name;
    private String country;
    private Condition condition;
    private Solar solar;

    public CityCurrentWeather(String name, String country, Condition condition, Solar solar) {
        this.name = name;
        this.country = country;
        this.condition = condition;
        this.solar = solar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Solar getSolar() {
        return solar;
    }

    public void setSolar(Solar solar) {
        this.solar = solar;
    }
}
