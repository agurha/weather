package com.test.weather.helper.network;

import com.google.gson.JsonObject;
import com.test.weather.helper.entities.CityCurrentWeather;
import com.test.weather.helper.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;

/**
 * Created by agurha on 03/07/2016.
 */
public class GetOpenWeatherData {

    public String createJSON(String apiRequest) throws ConnectException {


        StringBuilder sb = new StringBuilder();
        try {

            URL url = new URL(apiRequest);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp;

            while (null != (strTemp = br.readLine())) {
                sb.append(strTemp);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ConnectException("InternetConnection failed");
        }
        return sb.toString();
    }

    public CityCurrentWeather getCityObject(String cityName) throws ConnectException {

        String key = "713d9a6a9e5940714f0f60d0f56a095d";
        String request = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&APPID=" + key;
        String json = this.createJSON(request);

        JsonObject jObj = Utils.createJsonObject(json);


        return OpenWeatherDataMapper.jsonToWeather(jObj);

    }
}
