/**
 * @author Avijit
 * @Description main App.js along with Controllers
 */
(function(){
var app = angular.module('portal' , []);

app.controller('TabController', function(){
	this.tab = 1;
	
	this.selectTab = function(setTab){
		this.tab = setTab;
	};
	
	this.isSelected = function(checkTab){
		return this.tab === checkTab;
	};
});

app.controller('DropdownController', function(){
	/*$scope.modelList = {
			name: 'Model A',
			value: 'A',
	};*/
	console.log("Inside controller");
	this.models = {
			name: 'Model A',
			value: 'A'
	};
	console.log(this.models);
});

})();