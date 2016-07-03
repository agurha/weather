/**
 * Created by agurha on 03/07/2016.
 */
app.controller('weatherController', ['$scope', '$http', function ($scope, $http) {
    $scope.headingTitle = "City Weather";

    $scope.exampleLocations = ["London", "HongKong"];

    $scope.message = '';
    $scope.hasState = '';

    $scope.hasData = false;

    // Get weather data for location as given in $scope.location
    $scope.getForecastByLocation = function() {

        console.log('forecast called');
        if ($scope.location == '' || $scope.location == undefined) {
            $scope.hasState = 'has-warning';
            $scope.message = 'Please provide a location';
            return;
        }

        $scope.hasState = 'has-success';

        var cityName = $scope.location;

        var queryUrl = "http://localhost:8090/weather/v1/cities/" + cityName;

        console.log('query url is ', queryUrl);

        $http.get(queryUrl).
        success(function(data, status, headers, config) {

            console.log('data is ', data);
            $scope.weather = data;

            $scope.hasData = true;

        }).
        error(function(data, status, headers, config) {
            // log error
        });


    };

    // Set $scope.location and execute search on API
    $scope.setLocation = function(loc) {

        $scope.hasData = false;
        console.log('setting location ', loc);
        $scope.location = loc;
        $scope.getForecastByLocation();
    };



}]);
