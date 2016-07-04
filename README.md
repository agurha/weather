# Open Weather App

In this App we are going to demonstrate how we can query the OpenWeather API and display some key fields on a webpage, here we are going to use AngularJS form to send the City name from the webpage to the WeatherAPI and receieve response. Response from the API is further bound to the Webpage to display the required fields.

## Components


* [Weather Helper] - This is library jar which is responsible for making http call to the Open Weather API 
* [Weather API] - Runs on http://localhost:8090
                  Designed as Spring MVC, Rest API. This currently has only 1 rest end point /weather/v1/cities/{name}
                  Rest endpoint calls the autowired Service which in turn calls the Open Weather API and get the required Details
                  We also have a Swagger Visual API plugged for the ease of visualising what Rest endpoints API exposes and we can 
                  also query the API easily, this way. 

* [Weather Web]  Runs on http://localhost:3000/index.html
                 Designed as a Springboot application which currently serves the index.html. This is designed as an angular app. 

#Screenshot 1 - Swagger UI showing Rest API 
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.39.59.png)
#Screenshot 2 - Showing Rest API call made via swagger UI and response received
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.39.48.png)
#Screenshot 3 - Showing Angular App for London weather retreived from Rest API which calls Open weather internally to get data
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.40.41.png)
#Screenshot 4 - Showing Angular App for Manchester weather retreived from Rest API which calls Open weather internally to get data
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.40.58.png)
#Screenshot 5 - Showing Run / Debug configuration for Web app which runs on http://localhost:3000 and serves index.html page 
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.42.46.png)
#Screenshot 5 - Showing Run / Debug configuration for Rest Api Application which runs on http://localhost:8090 and serves the API
![ScreenShot](https://github.com/agurha/weather/blob/master/screenshots/Screen%20Shot%202016-07-04%20at%2008.43.00.png)


