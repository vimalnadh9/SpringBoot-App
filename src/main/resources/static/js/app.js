var app = angular.module('myApp', ['ngResource']);

app.controller('PatientController', ['$scope', '$resource',function($scope,$resource) {
    
    function fetchAllPatients(){
        $scope.patients = $resource('http://localhost:8080/patient'
        ).query(function(data){return data;});
    };
    fetchAllPatients();
    
    $scope.refresh = function(){
    	fetchAllPatients();
    };
    
    $scope.create = function(){
    	User = $resource(
    		    "http://localhost:8080/create",
    		    {},
    		    {save: {method:'PUT',isArray:false}}
    	);
    	
    	var user = {};
		
		user.id = $scope.patientForm.id;
		user.name = $scope.patientForm.name;
		user.phoneNo = $scope.patientForm.mobile;
		
		user.email = $scope.patientForm.email;
		
		$scope.Message = User.save(user);
				
		$scope.patientForm.id = "";
		$scope.patientForm.name="";
		$scope.patientForm.mobile="";
		$scope.patientForm.email="";
    };
    
    $scope.deleteRec = function(){
    	User = $resource(
    		    "http://localhost:8080/delete/:id",
    		    {},
    		    {save: {method:'DELETE', params: {id: '@id'}}}
    	);
    	
			
		User.delete({id: $scope.patientForm.id}).then(function successCallback(response) {
			$scope.Message = response;
		}, function errorCallback(response) {
		    
		});
				
		$scope.patientForm.id = "";
		$scope.patientForm.name="";
		$scope.patientForm.mobile="";
		$scope.patientForm.email="";
    };
    
    
    $scope.update = function(){
    		
    	User = $resource(
    		    "http://localhost:8080/update/:id",
    		    {},
    		    {save: {method:'PUT', params: {id: '@id'}}}
    	);
    	
		var user = {};
		
		user.id = $scope.patientForm.id;
		user.name = $scope.patientForm.name;
		user.phoneNo = $scope.patientForm.mobile;
		user.email = $scope.patientForm.email;
		
		$scope.Message = User.save({id: $scope.patientForm.id}, user);
				
		$scope.patientForm.id = "";
		$scope.patientForm.name="";
		$scope.patientForm.mobile="";
		$scope.patientForm.email="";
    };
    
}]);