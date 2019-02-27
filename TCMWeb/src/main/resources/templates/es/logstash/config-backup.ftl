<!DOCTYPE html>
<html lang="en">
	<head>
	</head>

  	<body>
<div ng-app="myApp" ng-controller="logstashCtrl">
input {<br>
&nbsp;&nbsp; jdbc {<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_driver_library => "../mysql-connector-java-5.1.46/mysql-connector-java-5.1.46-bin.jar"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_driver_class => "com.mysql.jdbc.Driver"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_connection_string => "jdbc:mysql://localhost:3306/tcmdata"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_user => "root"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_password => "123456"<br>
&nbsp;&nbsp;&nbsp;&nbsp; schedule => "* * * * *"<br>
&nbsp;&nbsp;&nbsp;&nbsp; statement => "SELECT * FROM tcmdata.material WHERE update_at >= :sql_last_value"<br>
&nbsp;&nbsp;&nbsp;&nbsp; use_column_value => true<br>
&nbsp;&nbsp;&nbsp;&nbsp; tracking_column_type => "timestamp"<br>
&nbsp;&nbsp;&nbsp;&nbsp; tracking_column => "update_at"<br>
&nbsp;&nbsp;&nbsp;&nbsp; last_run_metadata_path => "syncpoint_table"<br>
&nbsp;&nbsp; }<br>
}<br>
<br>
<br>
output {<br>
&nbsp;&nbsp; elasticsearch {<br>
&nbsp;&nbsp;&nbsp;&nbsp; hosts => ["localhost:9200"]<br>
&nbsp;&nbsp;&nbsp;&nbsp; index => "material"<br>
&nbsp;&nbsp;&nbsp;&nbsp; user => elastic<br>
&nbsp;&nbsp;&nbsp;&nbsp; password => changeme<br>
&nbsp;&nbsp;&nbsp;&nbsp; document_id => "%{id}"<br>
&nbsp;&nbsp; }<br>
}<br>
</div>
	</body>
	
	
	
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script>
var app = angular.module('myApp', []);
app.controller('logstashCtrl', function($scope, $http) {
	$http({
        method: 'GET',
        url: '/logstash/config'
    }).then(function successCallback(response) {
    	console.log(response.data)
    		console.log(response.data)
//             $scope.dynasties = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
});
</script>
</html>
