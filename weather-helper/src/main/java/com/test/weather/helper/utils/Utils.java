package com.test.weather.helper.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by agurha on 03/07/2016.
 */
public class Utils {

    public static double celsiusToFahrenheit(double temperature) {
        return ((9 * temperature / 5) + 32);
    }

    public static String dateToString(long date) {
        if (date == 0)
            return null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return localDateTime.format(formatter);
    }

    public static JsonObject createJsonObject(String json) {
        JsonParser parser = new JsonParser();
        return parser.parse(json).getAsJsonObject();
    }
}
