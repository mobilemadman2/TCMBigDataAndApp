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
		
			<div class="col-xs-9">		
 		<div class="col-xs-11" ng-repeat="obj in books">
			<div class="panel panel-default">
			  <div class="panel-heading"><h3 id="_{{ obj.name }}"><a href="/getbook?name={{ obj.name }}">{{ obj.name }}</a></h3></div>
			  <div class="panel-body">
			    <p>作者：{{ obj.author?obj.author:'未知' }}</p>
			    <p>朝代：{{ obj.dynasty?obj.dynasty.name:'未知' }}</p>
			  </div>
			</div>
		</div>
		
		<div id="not-found"><h3>未找到相关书籍!</h3></div>
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
        url: '/book/findbook',
        params: {
        	'bookname': '${keyword}',
        }
    }).then(function successCallback(response) {
    	console.log(response.data)
    		$scope.books = response.data
//     		console.log(response.data.length)
    		if(response.data.length>0)
    			$("#not-found").css('display','none'); 
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
	
});
</script>
  </body>
</html>
