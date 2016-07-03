package com.test.weather.api;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.test.weather.helper.network.GetOpenWeatherData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableSwagger
public class Application  {

    private static final Class<Application> appClass = Application.class;

    public static void main(String[] args) {
        SpringApplication.run(appClass, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");

            }
        };
    }

    @Bean
    public GetOpenWeatherData getOpenWeatherData() {
        return new GetOpenWeatherData();
    }

}
