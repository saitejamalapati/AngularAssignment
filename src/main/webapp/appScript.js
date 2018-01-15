var app=angular.module('GetCall',["ngRoute"])
    .controller('getCallController',function($scope, $http){
    	$scope.getUser = function() {
            $http.get('http://localhost:8080/RestProject/webapi/users').then(function(response) {
                $scope.users=response.data;
            });
        }
       
        $scope.deleteUser = function(id){
            $http.delete('http://localhost:8080/RestProject/webapi/users/' + id).then(function(response) {
            	console.log(response.data);
            });
        }
        
        $scope.updateUser = function(id) {
            $scope.putObj={"userName": $scope.namePut, "age": $scope.agePut, "city": $scope.cityPut}
            $http.put('http://localhost:8080/RestProject/webapi/users/' + id, $scope.putObj).then(function(response){
                console.log(response);
            });
        }
        
        $scope.createUser = function() {
            $scope.postObj={"userName": $scope.namePost, "age": $scope.agePost, "city": $scope.cityPost}
            $http.post('http://localhost:8080/RestProject/webapi/users',$scope.postObj).then(function(response){
                console.log(response);
            });
        }
});
app.config(function($routeProvider){
    $routeProvider
    .when("/users",{
        templateUrl:"profile.html"
    })
    .when("/update",{
        templateUrl:"update.html"
    })
    .when("/create",{
        templateUrl:"create.html"
    })
    .when("/delete",{
        templateUrl:"delete.html"
    })
});