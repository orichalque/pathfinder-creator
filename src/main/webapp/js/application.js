/**
 * Created by Vandorallen on 12/12/2016.
 */
(function () {

    /**
     * Dependances
     * $scope: Acces aux variables JS depuis le HTML
     * $http: Gestion des appels REST
     * $cookies: Gestion des cookies pour maintenir ma connexion
     * $window: Redirections
     * $q promises
     */
    var app = angular.module("pathCreation", []);
    app.controller("charCtrl", ['$scope', '$http', function ($scope, $http) {

        $scope.state = 0;

        $scope.name = "";
        $scope.age = "";
        $scope.sex = "assexué";

        $scope.species = [];

        $scope.next = function() {
            console.log($scope.state);
            $scope.state++;
        }

        $scope.previous = function() {
            console.log($scope.state);
            $scope.state--;
        }

        $scope.getSpecies = function() {
            $http({
                method: 'GET',
                url: "/species"
            }).then(function successCallback(response) {
                $scope.species = response.data;
            }, function errorCallback(response){
            });
        };

        $scope.editedItem = {
            state : false
        };

        $scope.setTrue = function($value) {
            $value.state = true;
        };

        $scope.setFalse = function($value) {
            $value.state = false;
        };

    }]);
})();
