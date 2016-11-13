angular.module('hello', [ 'ngRoute' ]).config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('navigation',

		function($rootScope, $http, $location, $route) {
			
			var self = this;
			self.credentials = {};

			self.tab = function(route) {
				return $route.current && route === $route.current.controller;
			};

			self.login = function() {
				authenticate(self.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded")
						$location.path("/");
						self.error = false;
						$rootScope.authenticated = true;
					} else {
						console.log("Login failed")
						$location.path("/login");
						self.error = true;
						$rootScope.authenticated = false;
					}
				})
			};

			self.logout = function() {
				$http.post('logout', {}).finally(function() {
					$rootScope.authenticated = false;
					$location.path("/");
				});
			}
			
			var authenticate = function(credentials, callback) {

				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {
					headers : headers
				}).then(function(response) {
					if (response.data.name) {
						$rootScope.authenticated = true;
					} else {
						$rootScope.authenticated = false;
					}
					callback && callback($rootScope.authenticated);
				}, function() {
					$rootScope.authenticated = false;
					callback && callback(false);
				});

			}
			
			authenticate();


		}).controller('home', function($http, $scope, $route) {
			var self = this;
			self.sortType     = 'name'; // set the default sort type
			self.sortReverse  = false;  // set the default sort order
			self.searchOrg   = '';     // set the default search/filter term
			  
			self.send = function(){
			var org = {"name" : $scope.org.name, 
						"type": $scope.org.type, 
						"location": $scope.org.location 
			}
			$http.post('/create/', org).
		    success(function(data, status, headers, config) {
		    	self.rest.list=data.list;
		    	console.log(data.dblog);
		      }).
		      error(function(data, status, headers, config) {
		    	  console.log(data);
		      });
			}
			$http.get('/resource/').then(function(response) {
				self.rest = response.data;
			})
	
});