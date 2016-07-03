package com.test.weather.api.service;

import com.test.weather.api.domain.CityWeatherResponse;
import com.test.weather.api.util.TestUtil;
import com.test.weather.helper.entities.*;
import com.test.weather.helper.network.GetOpenWeatherData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by agurha on 03/07/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityWeatherServiceTest {

    @InjectMocks
    private CityWeatherService bidService = new DefaultCityWeatherService();


    @Mock
    private GetOpenWeatherData openWeatherData;

    @Test
    public void getCityWeatherForLondon() throws Exception {


        String cityName = "London";

        when(openWeatherData.getCityObject(cityName)).thenReturn(stubbedLondonWeather());

        CityWeatherResponse cityWeatherByName = bidService.getCityWeatherByName(cityName);

        assertEquals(cityWeatherByName.getToday(), TestUtil.getTodayDateFormatted());
        assertNotNull(cityWeatherByName.getCityCurrentWeather().getCondition());

    }

    @Test
    public void getCityWeatherForHondKong() throws Exception {


        String cityName = "HongKong";

        when(openWeatherData.getCityObject(cityName)).thenReturn(stubbedHKWeather());

        CityWeatherResponse cityWeatherByName = bidService.getCityWeatherByName(cityName);

        assertEquals(cityWeatherByName.getToday(), TestUtil.getTodayDateFormatted());
        assertNotNull(cityWeatherByName.getCityCurrentWeather().getName());

    }


    private CityCurrentWeather stubbedLondonWeather() {

        CityCurrentWeather weather = new CityCurrentWeather("London", "GB", new Condition(new Temperature(65.156, 18.42), new Weather(801, "Clouds", "few clouds", "02d")), new Solar("04.50 AM", "09.19 PM"));

        return weather;
    }



    private CityCurrentWeather stubbedHKWeather() {

        CityCurrentWeather weather = new CityCurrentWeather("Tsuen Wan", "HK", new Condition(new Temperature(83.102, 28.39), new Weather(803, "Clouds", "broken clouds", "04n")), new Solar("10.44 PM", "12.11 PM"));

        return weather;
    }


}
