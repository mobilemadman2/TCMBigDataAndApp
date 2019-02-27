<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/book.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
  	
    <div class="container">
    
    <!-- 页面当前位置导航 -->
    <#assign nav_name = ["中医古籍"]>
    <#assign nav_href = ["/books.html"]>
    <#include "/common/nav-pos.ftl"/>
    <!-- 页面当前位置导航结束 -->
    
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医古籍</h1>
      </div>
      
          <div class="row search-box">
		 <form action="/book/search.html" method="post">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入中医古籍名称">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="book-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		  </form>
		</div><!-- /.row -->
		
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">伤寒论&nbsp;&nbsp;医方歌括&nbsp;&nbsp;万氏秘传片玉心书</p>
		</div>
		
		<br>
		
		
		<div class="row" id="books" ng-app="myApp" ng-controller="myCtrl">
		
			<div class="col-xs-3">
			<div class="panel-group" role="tablist">
    <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="bookHeading1">
        <h4 class="panel-title">
          <a ng-click="dynastyOrder()" class="collapsed" role="button" data-toggle="collapse" href="#bookListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
            朝代顺序
          </a>
        </h4>
      </div>
      <div id="bookListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="bookListGroupHeading1">
        <ul class="list-group">
<!--           -->
          <li class="list-group-item" ng-repeat="obj in dynasties"><a href="javascript:void(0);" id="target_{{ obj.name }}" ng-click="scrollToDiv($event)">{{ obj.name }}({{ obj.books.length}})</a></li>
        </ul>
      </div>
    </div>
    
        <div class="panel panel-default">
      <div class="panel-heading" role="tab" id="bookListGroupHeading2">
        <h4 class="panel-title">
          <a ng-click="alphabetOrder()" class="collapsed" role="button" data-toggle="collapse" href="#bookListGroup2" aria-expanded="true" aria-controls="bookListGroup2">
            字母顺序
          </a>
        </h4>
      </div>
      <div id="bookListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="bookListGroupHeading2">
        <ul class="list-group">
          <li class="list-group-item" ng-repeat="obj in alphabets"><a href="javascript:void(0);" id="target_{{ obj.name }}" ng-click="scrollToDiv($event)">{{ obj.name }}({{ obj.books.length }})</a></li>
        </ul>
      </div>
    </div>
  </div>
			</div>
			<div class="col-xs-9">		
 		<div class="col-xs-11" ng-repeat="obj in books">
			<div class="panel panel-default">
			  <div class="panel-heading"><h3 id="_{{ obj.name }}">{{ obj.name }}</h3></div>
			  <div class="panel-body">
			    <span ng-repeat="book in obj.books" class="book-span"><a href="/getbook?name={{ book }}">{{ book }}</a></span>
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
    		$scope.books = $scope.dynasties
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
	$http({
        method: 'GET',
        url: '/book/alphabet-order'
    }).then(function successCallback(response) {
    	console.log(response.data)
            $scope.alphabets = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
	
	$scope.dynastyOrder = function(){
		console.log('dynastiesOrder')
		$scope.books = $scope.dynasties
	}
	
	$scope.alphabetOrder = function(){
		console.log('alphabetOrder')
		$scope.books = $scope.alphabets
	}
	
	$scope.scrollToDiv = function(event){
		console.log(event.target.id)
		target_div = event.target.id.replace('target_','')
		console.log(event.target.parentNode.parentNode.parentNode.id)
		
		if(event.target.parentNode.parentNode.parentNode.id=='bookListGroup1'){
			$scope.books = $scope.dynasties
		}else{
			$scope.books = $scope.alphabets			
		}
		window.location.hash="#_"+target_div
		window.scrollBy(0,-90)
		return false
	}
});
</script>
		
<!--     <script type="text/javascript" src="/js/table_utils.js"></script>
 -->    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
