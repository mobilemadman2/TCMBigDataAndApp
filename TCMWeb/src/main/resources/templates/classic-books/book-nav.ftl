<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/book.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医古籍</h1>
      </div>
          
		
		<div class="row" id="books">
		
			<div class="col-xs-3">
			<div class="panel-group" role="tablist">
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="diseaseHeading1">
        <h4 class="panel-title">
          <a class="collapsed" role="button" data-toggle="collapse" href="#diseaseListGroup1" aria-expanded="false" aria-controls="diseaseListGroup1">
            朝代顺序
          </a>
        </h4>
      </div>
      <div id="diseaseListGroup1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="diseaseListGroupHeading1">
        <ul class="list-group">
          <li class="list-group-item">肺系病证</li>
          <li class="list-group-item">心系病证</li>
          <li class="list-group-item">脾胃病症</li>
        </ul>
      </div>
    </div>
    
        <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="diseaseListGroupHeading2">
        <h4 class="panel-title">
          <a class="collapsed" role="button" data-toggle="collapse" href="#diseaseListGroup2" aria-expanded="false" aria-controls="diseaseListGroup2">
            字母顺序
          </a>
        </h4>
      </div>
      <div id="diseaseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="diseaseListGroupHeading2">
        <ul class="list-group">
          <li class="list-group-item">疮疡</li>
          <li class="list-group-item">乳房疾病</li>
        </ul>
      </div>
    </div>
  </div>
			</div>
			<div class="col-xs-9">
			<div ng-app="myApp" ng-controller="myCtrl">
 		<div class="col-xs-11" ng-repeat="obj in dynasties">
			<div class="panel panel-default">
			  <div class="panel-heading"><h3>{{ obj.dynasty.name }}</h3></div>
			  <div class="panel-body">
			    <span ng-repeat="book in obj.books" class="book-span"><a href="/getbook?name={{ book }}">{{ book }}</a></span>
			  </div>
			</div>
		</div>
		</div>
      </div>
      <!-- /.row -->
    </div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
<!--     <script src="/js/packages/require.js" data-main="/js/book"></script>
 -->    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$http({
        method: 'GET',
        url: '/book/dynasty-order'
    }).then(function successCallback(response) {
    	console.log(response.data)
            $scope.dynasties = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
    $scope.firstName= "John";
    $scope.lastName= "Doe";
});
</script>
		
<!--     <script type="text/javascript" src="/js/table_utils.js"></script>
 -->    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
