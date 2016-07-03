package com.test.weather.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by agurha on 03/07/2016.
 */
public class TestUtil {

    public static String getTodayDateFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
        return LocalDate.now().format(dateTimeFormatter);

    }
}
