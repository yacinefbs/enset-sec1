var myApp = angular.module("myApp", []);


myApp.controller("listEtudiantController", function($scope, $http) {
	$scope.pageEtudiants=null;
	$scope.pageCourante=0;
	$scope.size=5;
	
	$scope.listEtudiants=function(){
		$http.get("etudiants?page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function(data){
			$scope.pageEtudiants=data;
		})
	};
	$scope.listEtudiants();
});



myApp.controller("InscriptionController", function($scope , $http){
	$scope.etudiant={};
	$scope.errors=null;
	$scope.mode={value:'form'};
	$scope.exception={message:null};
	
	$scope.saveEtudiant=function(){
		$http.post("etudiants", $scope.etudiant)
		.success(function(data){
			if(!data.errors){
				$scope.etudiant=data;
				$scope.errors=null;
				$scope.mode.value="confirm";
			}
			else{
				$scope.errors=data
			}
				
		})
		.error(function(data) {
			$scope.exception.message=data.message;
		})
		;
	};
});

myApp.controller("IndexController", function($scope, $http) {
	$scope.menu=["Inscription", "Listes", "Utilisateurs", "Logout"];
	$scope.selectedMenu=null;
	
	$scope.select=function(m){
		$scope.selectedMenu=m;
	};
});
