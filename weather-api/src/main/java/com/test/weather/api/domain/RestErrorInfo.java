package com.test.weather.api.domain;

/**
 * Created by agurha on 03/07/2016.
 */
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}