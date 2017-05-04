var app = angular.module('CalculatorWeb', []);

app.controller('controller', function($scope, $http){

        $scope.showErrors = false;
        $scope.calculate = function(){
        console.log($scope.source)
        $http.get('/calculate/' + $scope.source)
                .then(function(response){
                    $scope.result = response.data.result;
                    $scope.showErrors = false;
                }, function(error){
                        $scope.errorCode = error.data.status;
                        $scope.errorMessage = error.data.error;
                        $scope.showErrors = true;
                }
                );
        }
})