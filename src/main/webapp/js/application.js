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

    $scope.specieChosen = {};
    $scope.classChosen = {};
    $scope.skillsChosen = null;
    $scope.giftsChosen = [];
    $scope.alignments = [];

    $scope.showWeapons = false;
    $scope.showArmors = false;
    $scope.showItems = false;
    
    $scope.stuff = [];
    $scope.golds = 100;
    $scope.giftCapital = 1;

    $scope.skills = null;
    $scope.gifts = null;

    $scope.alignChosen = null;

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

    $scope.getAlignments = function() {
        $http({
            method: 'GET',
            url: "/alignments"
        }).then(function successCallback(response) {
            $scope.alignments = response.data;
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

    $scope.getGifts = function() {
        $http({
            method: 'GET',
            url: "/gifts"
        }).then(function successCallback(response) {
            $scope.gifts = response.data;
            var i = 0;
            $scope.gifts.forEach(function(gift)
            {
                gift.nb = i;
                i++;
            });

            $scope.giftCapital = 1;
            if ($scope.specieChosen.hasOwnProperty("bonusGift")) {
                $scope.giftCapital = $scope.giftCapital + $scope.specieChosen.bonusGift;
            }

            if ($scope.classChosen.hasOwnProperty("bonusGift")) {
                $scope.giftCapital = $scope.giftCapital + $scope.classChosen.bonusGift;
            }
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

    $scope.send = function() {
        var character = {
            "name" : $scope.name,
            "age" : $scope.age,
            "sex" : $scope.sex,
            "specie" : $scope.specieChosen.name,
            "class" : $scope.classChosen.name,
            "alignment" : $scope.alignChosen,
            "charac" : $scope.charValues,
            "skills" : $scope.getOwnedSkills(),
            "equipments" : $scope.stuff,
            "gifts" : $scope.getOwnedGifts()
        };

        $http({
            method: "POST",
            url: '/validate',
            data: { 'character' : character }
        })
        .then(function(response) {
                // success
            },
        function(response) { // optional
            // failed
        });
        $scope.state += 1;
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

    $scope.getOwnedSkills = function() {
        var ownedSkills = [];

        if ($scope.skills != null) {
            $scope.skills.forEach(function(entry) {
                if (entry.level > 0) {
                    ownedSkills.push(entry);
                }
            });
        }
        return ownedSkills;
    };

    $scope.buy = function(equipment) {
    	if (equipment.price <= $scope.golds && $.inArray(equipment, $scope.stuff) === -1) {
                $scope.stuff.push(equipment);
                $scope.golds = $scope.golds - equipment.price;
    	} else {
    		alert("Pas assez d'argent, ou déjà dans l'inventaire.");
    	}
    };
    
    $scope.clear = function() {
    	$scope.stuff = [];
    	$scope.golds = 100;
    };

    $scope.getOwnedGifts = function() {
        var ownedGifts = [];
        $scope.giftsChosen.forEach(function(giftChosen) {
            ownedGifts.push($scope.gifts[giftChosen].name);
        });
        return ownedGifts;
    };

    $scope.addOrRemoveGift = function($gift) {

        if ($.inArray($gift.nb, $scope.giftsChosen) == -1 && $scope.giftCapital > 0) {
            $scope.giftsChosen.push($gift.nb);
            $scope.giftCapital --;
            $gift.checked = true;
        } else if($.inArray($gift.nb, $scope.giftsChosen) != -1 ) {
            $scope.giftsChosen.splice($.inArray($gift.nb, $scope.giftsChosen), 1);
            $scope.giftCapital ++;
            $gift.checked = false;
        }
    };

    $scope.setAlignment = function($align) {
        $scope.alignChosen = $align.name;
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
