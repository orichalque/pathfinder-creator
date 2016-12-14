angular.module("pathCreation", [])
.controller("charCtrl", ['$scope', '$http', function ($scope, $http) {

    var species = null;
    $scope.state = 0;

    $scope.name = "";
    $scope.age = "";
    $scope.sex = "assexué";

    $scope.specieChosen;

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
            species = response.data;
        }, function errorCallback(response){
        });
    };

    $scope.pickSpecie = function(species) {
        $scope.species = species;
        console.log(specie)
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

    $scope.setSpecie = function(specie) {
        $scope.specieChosen = specie;
    }
}])
.directive('repeater', function() {
return {
    restrict: 'E',
    scope:{
        specie: "="
    },
    link: function($scope, element, attrs) {

    }
}});
