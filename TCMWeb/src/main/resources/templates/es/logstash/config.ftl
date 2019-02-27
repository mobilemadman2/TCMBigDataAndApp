<!DOCTYPE html>
<html lang="en">
	<head>
	</head>

  	<body>
<div ng-app="myApp" ng-controller="logstashCtrl">
<div id="input-view">
input {<br>
<div ng-repeat="view in views">
&nbsp;&nbsp; jdbc {<br>
&nbsp;&nbsp;&nbsp;&nbsp; type => "{{ view.type }}"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_driver_library => "{{ view.input.jdbc_driver_library }}"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_driver_class => "com.mysql.jdbc.Driver"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_connection_string => "jdbc:mysql://192.168.31.170:3306/tcmdata"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_user => "root"<br>
&nbsp;&nbsp;&nbsp;&nbsp; jdbc_password => "123456"<br>
&nbsp;&nbsp;&nbsp;&nbsp; schedule => "* * * * *"<br>
&nbsp;&nbsp;&nbsp;&nbsp; statement => "{{ view.input.statement }}"<br>
&nbsp;&nbsp;&nbsp;&nbsp; use_column_value => true<br>
&nbsp;&nbsp;&nbsp;&nbsp; tracking_column_type => "timestamp"<br>
&nbsp;&nbsp;&nbsp;&nbsp; tracking_column => "update_at"<br>
&nbsp;&nbsp;&nbsp;&nbsp; last_run_metadata_path => "{{ view.input.last_run_metadata_path }}"<br>
&nbsp;&nbsp; }<br>
<br>
</div>
}
</div>
<br>
<br>

<div id="output-view">
output {<br>
<div ng-repeat="view in views">
&nbsp;&nbsp;if [type] == "{{ view.type }}"{<br>
&nbsp;&nbsp;&nbsp;&nbsp; elasticsearch {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; hosts => ["localhost:9200"]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; index => "{{ view.output.index }}"<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; user => elastic<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; password => changeme<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; document_id => "%{id}"<br>
&nbsp;&nbsp;&nbsp;&nbsp; }<br>
&nbsp;&nbsp;}<br>
<br>
</div>
}<br>
</div>

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
//     		console.log(response.data)
    		$scope.views = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
});
</script>
</html>
