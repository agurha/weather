package com.test.weather.helper.entities;

/**
 * Created by agurha on 03/07/2016.
 */
public class Condition {

    private Temperature temperature;
    private Weather weather;


    public Condition(Temperature temperature, Weather weather) {
        this.temperature = temperature;
        this.weather = weather;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
