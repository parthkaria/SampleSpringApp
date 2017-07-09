angular.module('loginApp').controller(
 'loginController', ['$scope', 'httpService', function($scope, httpService) {
  var ctrl = this;
  ctrl.login = function() {
   var userData = {
    'userName': ctrl.username,
    'password': ctrl.password
   };

   httpService.postReq('/loginReq', userData).then(
    function successCallback(response) {
     ctrl.statusMsg = response.data.message;
     console.log(response);
    },
    function errorCallback(response) {
     ctrl.statusMsg = response.data.message;
     console.log(response);
    });
  }
 }]);