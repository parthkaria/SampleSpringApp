angular.module('loginApp').service('httpService', function($http) {

 this.postReq = function(url, data) {
  return $http.post(url, data);
 }

});