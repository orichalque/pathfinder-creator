angular.module("pathCreation", [])
.controller("charCtrl", ['$scope', '$http', function ($scope, $http) {
    $scope.charPrice = {7:-4, 8:-2, 9:-1, 10:0, 11:1, 12:2, 13:3, 14:5, 15:7, 16:10, 17:13, 18:17};
    $scope.chars = ["Force", "Dexterité", "Constitution", "Intelligence", "Sagesse", "Charisme"];
    $scope.capital = 20;
    $scope.skillCap = 0;
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
    $scope.skillsChosen = null;

    $scope.showWeapons = false;
    $scope.showArmors = false;
    $scope.showItems = false;
    
    $scope.stuff = [];
    $scope.golds = 100;
    
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

    $scope.getSkills = function() {
        $http({
            method: 'GET',
            url: "/skills"
        }).then(function successCallback(response) {
            $scope.skills = response.data;
            $scope.skills.forEach(function(entry)
            {
                entry.level = 0;
            });
        }, function errorCallback(response){
        });
    };

    $scope.getEquipments = function() {
        $http({
            method: 'GET',
            url: "/equipments"
        }).then(function successCallback(response) {
            $scope.weapons = [];
            $scope.armors = [];
            $scope.items = [];
            response.data.forEach(function(entry) {
                if (entry.class==="weapon") {
                    $scope.weapons.push(entry);
                }
                if (entry.class==="armor") {
                    $scope.armors.push(entry);
                }
                if (entry.class==="item") {
                    $scope.items.push(entry);
                }
            });
            $scope.weapons.sort(function(w1, w2) {
                if (w1.subclass > w2.subclass) {
                    return 1;
                } else if (w1.subclass < w2.subclass) {
                    return -1;
                } else {
                    return 0;
                }
            });
            $scope.showArmors.state = false;
            $scope.showWeapons.state = false;
            $scope.showItems.state = false;
        }, function errorCallback(response){
        });
    };

    $scope.setClass = function(classe) {
        $scope.classChosen = classe;
        $scope.skillCap = $scope.classChosen.skillsByLevel;
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

    $scope.switchWeapons = function() {
        if ($scope.showWeapons) {
            $scope.showWeapons = false;
        } else {
            $scope.showWeapons = true;
        }
    };

    $scope.switchArmors = function() {
        if ($scope.showArmors) {
            $scope.showArmors = false;
        } else {
            $scope.showArmors = true;
        }
    };

    $scope.switchItems = function() {
        if ($scope.showItems) {
            $scope.showItems = false;
        } else {
            $scope.showItems = true;
        }
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
            var capitalBefore = $scope.capital;
            var valueBefore = $scope.charValues[value];
            if ($scope.charValues[value] <= 10) {
                $scope.capital = $scope.capital - $scope.charPrice[$scope.charValues[value]-1];
                $scope.charValues[value] --;
            } else {
                $scope.capital = $scope.capital + $scope.charPrice[$scope.charValues[value]];
                $scope.charValues[value] --;
            }
            if ($scope.capital < 0) {
                $scope.capital = capitalBefore;
                $scope.charValues[value] = valueBefore;
            }
        }
    };

    $scope.increaseSkill = function(skill) {
        if ($scope.skillCap>0){
            if ($.inArray($scope.classChosen.name, skill.classes) != -1) {
                skill.level += 2;
            }
            skill.level++;
            $scope.skillCap --;
        }
    };

    $scope.decreaseSkill = function(skill) {
        if (skill.level >0){
            if ($.inArray($scope.classChosen.name, skill.classes) != -1) {
                skill.level -= 2;
            }
            skill.level--;
            $scope.skillCap ++;
        }
    };
       
    $scope.buy = function(equipment) {
    	if (equipment.price <= $scope.golds) {
    		$scope.stuff.push(equipment);	
    		$scope.golds = $scope.golds - equipment.price;
    	} else {
    		alert("Pas assez d'argent !");
    	}
    	
    	
    };
    
    $scope.clear = function() {
    	$scope.stuff = [];
    	$scope.golds = 100;
    };
    
}])
.directive('repeater', function() {
return {
    restrict: 'E',
    scope:{
        specie: "=",
        charValues: "=",
        char: "=",
        showWeapons: "=",
        showArmors: "=",
        showItems: "="
    },
    link: function($scope, element, attrs) {

    }
}});
