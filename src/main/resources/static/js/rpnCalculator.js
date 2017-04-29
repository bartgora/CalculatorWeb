var app = angular.module('CalculatorWeb', []);

app.controller('controller', function($scope, $http){

        $scope.showErrors = false;
        $scope.calculate = function($http){

        $http.get('/calculate' + $scope.source)
                .then(function(response){
                    $scope.result = response.result;
                }, function(error){
                        $scope.errorCode = error.status
                        $scope.errorMessage = error.error;
                        $scope.showErrors = true;
                });
        }
})