package com.test.weather.api.rest;

import com.test.weather.api.domain.CityWeatherResponse;
import com.test.weather.api.service.CityWeatherService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by agurha on 03/07/2016.
 */
@RestController
@RequestMapping(value = "/weather/v1/cities")
@Api(value = "cities", description = "Cities weather API")
public class CityWeatherController {


    @Autowired
    private CityWeatherService cityWeatherService;

    @CrossOrigin
    @RequestMapping(value = "/{name}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get weather for city", notes = "You have to provide a valid city name")
    public
    @ResponseBody
    CityWeatherResponse getWeatherForCity(@ApiParam(value = "The city name.", required = true)
                           @PathVariable("name") String cityName,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception {


        CityWeatherResponse cityWeatherResponse = this.cityWeatherService.getCityWeatherByName(cityName);
        return cityWeatherResponse;
    }

}
