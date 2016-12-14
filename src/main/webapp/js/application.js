angular.module("pathCreation", [])
.controller("charCtrl", ['$scope', '$http', function ($scope, $http) {
    $scope.charPrice = {7:-4, 8:-2, 9:-1, 10:0, 11:1, 12:2, 13:3, 14:5, 15:7, 16:10, 17:13, 18:17};
    $scope.chars = ["Force", "Dexterité", "Constitution", "Intelligence", "Sagesse", "Charisme"];
    $scope.capital = 15;
    $scope.charValues = {
        "Force" : 10,
        "Dexterité" : 10,
        "Constitution" : 10,
        "Intelligence" : 10,
        "Sagesse" : 10,
        "Charisme" : 10};

    var species = null;
    $scope.state = 0;

    $scope.name = "";
    $scope.age = "";
    $scope.sex = "assexué";

    $scope.specieChosen = null;
    $scope.classChosen = null;

    $scope.next = function() {
        $scope.state++;
    };

    $scope.previous = function() {
        $scope.state--;
    };

    $scope.getSpecies = function() {
        $http({
            method: 'GET',
            url: "/species"
        }).then(function successCallback(response) {
            $scope.species = response.data;
        }, function errorCallback(response){
        });
    };

    $scope.setSpecie = function(specie) {
        $scope.specieChosen = specie;
    };

    $scope.getClasses = function() {
        $http({
            method: 'GET',
            url: "/classes"
        }).then(function successCallback(response) {
            $scope.classes = response.data;
        }, function errorCallback(response){
        });
    };

    $scope.setClass = function(classe) {
        $scope.classChosen = classe;
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

    $scope.increase = function(value) {
        if ($scope.charValues[value]<18) {
            var capitalBefore = $scope.capital;
            var valueBefore = $scope.charValues[value];
            if ($scope.charValues[value] >= 10) {
                $scope.capital = $scope.capital - $scope.charPrice[$scope.charValues[value]+1];
                $scope.charValues[value]++;
            } else {
                $scope.capital = $scope.capital + $scope.charPrice[$scope.charValues[value]];
                $scope.charValues[value]++;
            }
            if ($scope.capital < 0) {
                $scope.capital = capitalBefore;
                $scope.charValues[value] = valueBefore;
            }
        }
    };

    $scope.decrease = function(value) {
        if ($scope.charValues[value] > 7) {
            if ($scope.charValues[value] <= 10) {
                $scope.capital = $scope.capital - $scope.charPrice[$scope.charValues[value]-1];
                $scope.charValues[value] --;
            } else {
                $scope.capital = $scope.capital + $scope.charPrice[$scope.charValues[value]];
                $scope.charValues[value] --;
            }

        }
    };
}])
.directive('repeater', function() {
return {
    restrict: 'E',
    scope:{
        specie: "=",
        charValues: "=",
        char: "="
    },
    link: function($scope, element, attrs) {

    }
}});
