var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: '/views/weather.html',
            controller: 'weatherController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});