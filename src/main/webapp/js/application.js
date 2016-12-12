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
    app.controller("charCtrl", ['$scope', function ($scope) {

        $scope.state = 0;

        $scope.name = "";
        $scope.age = "";
        $scope.sex = "assexué";
        
        $scope.start = function() {
            console.log($scope.state);
            $scope.state = 1;
        }

    }]);
})();
