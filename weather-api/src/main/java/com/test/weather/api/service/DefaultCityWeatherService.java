package com.test.weather.api.service;

import com.test.weather.api.domain.CityWeatherResponse;
import com.test.weather.helper.entities.CityCurrentWeather;
import com.test.weather.helper.network.GetOpenWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

/**
 * Created by agurha on 03/07/2016.
 */
@Service
public class DefaultCityWeatherService implements CityWeatherService {


    @Autowired
    private GetOpenWeatherData openWeatherData;

    @Override
    public CityWeatherResponse getCityWeatherByName(String cityName) {

        CityCurrentWeather cityWeather = null;
        try {
            cityWeather = openWeatherData.getCityObject(cityName);
        } catch (ConnectException e) {
            e.printStackTrace();
        }


        CityWeatherResponse response = new CityWeatherResponse(cityWeather);
        return response;
    }
}
