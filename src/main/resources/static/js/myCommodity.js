angular.module('myApp', []).controller('MyCommodityCtrl', function($scope, $http) {

	$scope.queryParam ="";	
	$scope.start =1;
	$scope.limit =3;
	
	$scope.message ="";
	$scope.commodity = {
			id : 0,
			name : "",
			content : ""
		};
	$scope.commoditys = [];
	
	$scope.count = 0;

	$scope.edit = function(commodity) {
		$scope.commodity = angular.copy(commodity);
	};

	$scope.newCommodity = function() {
		$scope.commodity = {
		};
	};

	
	$scope.save = function() {
		
		var requstData = $scope.commodity;
		$http({
			method : 'POST',
			url : '/commodity',
			data : requstData			
		}).then(function successCallback(response) {
			var json = response.data;
			console.log(json);
			if(json.success){
				$scope.message = "保存成功";
				$scope.load();
				$scope.newCommodity();
			}else{
				$scope.message = json.message;
			}
			
		}, function errorCallback(response) {
			console.log(response);
			$scope.message = "保存出错";
		});
	};

	
	$scope.load = function() {
		var postQueryData={
				"queryParam":$scope.queryParam,
				"start":$scope.start,
				"limit":$scope.limit
		}
		$scope.message = "查询中....";
		$http({
			method : 'GET',
			url : '/commodity',
			params:postQueryData
		}).then(function successCallback(response) {
			console.log("response",response);
			if(response.status == 200){
				var json = response.data;
				console.log("json",json)
				if(json  && json.success){
					if(json.result){
						console.log("json.result",json.result)
						$scope.commoditys = json.result.lists;
						$scope.count = json.result.count;
						console.log("$scope.commoditys",$scope.commoditys)
					}else{
						console.log("$scope.commoditysasdfasdfasdf")
					}
					$scope.message = "";
				}else{
					$scope.message ="查询失败";
				}
			}
		}, function errorCallback(response) {
			$scope.message ="查询失败";
		});
	};
	
	$scope.del = function(commodity) {
		
		$scope.message = "查询中....";
		$http({
			method : 'DELETE',
			url : '/commodity/'+commodity.id
		}).then(function successCallback(response) {
			console.log("response",response);
			var json = response.data;
			console.log(json);
			if(json.success){
				$scope.message = "删除成功";
				$scope.load();
				$scope.newCommodity();
			}else{
				$scope.message = json.message;
			}
		}, function errorCallback(response) {
			$scope.message ="查询失败";
		});
	};
	
	$scope.load();
	
	
	//上一页
	$scope.previous = function () {
		$scope.start = $scope.start -1;
		$scope.load();
	}
	//下一页
	$scope.next = function () {
		$scope.start = $scope.start +1;
		$scope.load();
	};

});