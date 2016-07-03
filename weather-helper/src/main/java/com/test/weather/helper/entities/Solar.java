package com.test.weather.helper.entities;

/**
 * Created by agurha on 03/07/2016.
 */
public class Solar {

    private String sunrise;
    private String sunset;

    public Solar(String sunrise, String sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
