package com.test.weather.api.service;

import com.test.weather.api.domain.CityWeatherResponse;

/**
 * Created by agurha on 03/07/2016.
 */
public interface CityWeatherService {

    CityWeatherResponse getCityWeatherByName(String cityName);
}
