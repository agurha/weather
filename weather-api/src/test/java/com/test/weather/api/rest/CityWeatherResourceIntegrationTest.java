package com.test.weather.api.rest;

import com.test.weather.api.Application;
import com.test.weather.api.util.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.test.weather.api.util.TestUtil.getTodayDateFormatted;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by agurha on 03/07/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class CityWeatherResourceIntegrationTest {

    @Autowired
    WebApplicationContext context;


    private MockMvc mvc;

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testCaseGetLondonWeather() throws Exception {


        String cityName = "London";

        String expectedDate = getTodayDateFormatted();

        mvc.perform(get("/weather/v1/cities/" + cityName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.today").value(expectedDate))
                .andExpect(jsonPath("$.cityCurrentWeather.name").value("London"))
                .andExpect(jsonPath("$.cityCurrentWeather.country").value("GB"))
                .andExpect(jsonPath("$.cityCurrentWeather.solar").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.temperature.celsius").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.temperature.fahrenheit").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.weather.description").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.weather.main").isNotEmpty());

    }


    @Test
    public void testCaseGetHongKongWeather() throws Exception {


        String cityName = "HongKong";

        String expectedDate = getTodayDateFormatted();

        mvc.perform(get("/weather/v1/cities/" + cityName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.today").value(expectedDate))
                .andExpect(jsonPath("$.cityCurrentWeather.name").value("Tsuen Wan"))
                .andExpect(jsonPath("$.cityCurrentWeather.country").value("HK"))
                .andExpect(jsonPath("$.cityCurrentWeather.solar").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.temperature.celsius").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.temperature.fahrenheit").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.weather.description").isNotEmpty())
                .andExpect(jsonPath("$.cityCurrentWeather.condition.weather.main").isNotEmpty());

    }



}
