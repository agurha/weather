package com.test.weather.api.domain;

import com.test.weather.helper.entities.CityCurrentWeather;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by agurha on 03/07/2016.
 */
public class CityWeatherResponse {

    public CityWeatherResponse(CityCurrentWeather cityCurrentWeather) {
        this.cityCurrentWeather = cityCurrentWeather;
        this.today = getTodayDateFormatted();
    }

    private String today;
    private CityCurrentWeather cityCurrentWeather;

    public String getToday() {
        return today;
    }

    public void setToday(String today) {

        this.today = today;
    }

    public CityCurrentWeather getCityCurrentWeather() {
        return cityCurrentWeather;
    }

    public void setCityCurrentWeather(CityCurrentWeather cityCurrentWeather) {
        this.cityCurrentWeather = cityCurrentWeather;
    }

    private String getTodayDateFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
        return LocalDate.now().format(dateTimeFormatter);

    }
}
