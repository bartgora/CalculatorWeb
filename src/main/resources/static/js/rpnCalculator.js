var app = angular.module('CalculatorWeb', []);

app.controller('controller', function($scope, $http){

        $scope.showErrors = false;
        $scope.calculate = function(){
        console.log($scope.source)
        $http.get('/calculate/' + $scope.source)
                .then(function(response){
                    $scope.result = response.data.result;
                }, function(error){
                        $scope.errorCode = error.status
                        $scope.errorMessage = error.error;
                        $scope.showErrors = true;
                }
                );
        }
})