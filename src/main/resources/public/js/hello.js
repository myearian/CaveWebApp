/**
 * Created by MattDev on 6/20/2016.
 */
angular.module('hello', []).controller('home', function($scope, $http) {
  $http.get('/resource/').success(function(greetingData) {
    $scope.greeting = greetingData;
  })
  $http.get('/menuOptions/').success(function(menuData) {
  	$scope.menuOptions = menuData;
  })
});