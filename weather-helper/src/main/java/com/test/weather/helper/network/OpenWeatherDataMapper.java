package com.test.weather.helper.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.test.weather.helper.entities.*;
import com.test.weather.helper.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by agurha on 03/07/2016.
 */
class OpenWeatherDataMapper {

    private static final Logger Log = LoggerFactory.getLogger(OpenWeatherDataMapper.class);

    private static String system = "sys";
    private static String weather = "weather";
    private static String main = "main";

    private static String country = "country";
    private static String sunrise = "sunrise";
    private static String sunset = "sunset";

    private static String weather_id = "id";
    private static String weather_main = "main";
    private static String weather_description = "description";
    private static String weather_icon = "icon";

    private static String temp = "temp";

    private static String city_name = "name";


    public static CityCurrentWeather jsonToWeather(JsonObject openWeatherObject) {
        try {


            String cityName = openWeatherObject.get(city_name).getAsString();

            JsonArray weatherAr = openWeatherObject
                    .getAsJsonArray(weather);

            JsonObject weatherOb = weatherAr.get(0).getAsJsonObject();

            int weatherId = weatherOb.get(weather_id).getAsInt();
            String weatherMain = weatherOb.get(weather_main).getAsString();
            String weatherDesc = weatherOb
                    .get(weather_description).getAsString();
            String weatherIcon = weatherOb.get(weather_icon).getAsString();


            JsonObject sysOb = openWeatherObject.getAsJsonObject(system);
            String countryName = sysOb.get(country).getAsString();

            long unixSunrise = sysOb.get(sunrise).getAsLong();
            long unixSunset = sysOb.get(sunset).getAsLong();
            String sunriseTime = Utils.dateToString(unixSunrise);
            String sunsetTime = Utils.dateToString(unixSunset);


            JsonObject mainOb = openWeatherObject.getAsJsonObject(main);
            double currentTemp = mainOb.get(temp).getAsDouble();

            double fahrenheitTemp = Utils.celsiusToFahrenheit(currentTemp);


            return new CityCurrentWeather(cityName, countryName
                    , new Condition(new Temperature(fahrenheitTemp, currentTemp)
                    , new Weather(weatherId, weatherMain, weatherDesc, weatherIcon))
                    , new Solar(sunriseTime, sunsetTime));

        } catch (Exception e) {
            Log.error("jsonToWeather: " + e.toString());
            return null;
        }
    }
}
