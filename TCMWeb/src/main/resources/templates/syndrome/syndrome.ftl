<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
   
    <link href="/disease-homepage.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["中医证候"]>
    <#assign nav_href = ["/syndrome.html"]>
    <#include "/common/nav-pos.ftl"/>
    
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医证候信息</h1>
      </div>
      
          <div class="row search-box">
		 <form action="/es-search/syndrome.html">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入证候名或概述">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="syndrome-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		  </form>
		</div><!-- /.row -->  
		
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">气虚证&nbsp;&nbsp;脾胃气虚证&nbsp;&nbsp;气滞血瘀证</p>
		</div>
		
		<br>
      
<!-- 		 <div class="row search-box"> -->
<!-- 		  <div class="col-lg-8"> -->
<!-- 		    <div class="input-group"> -->
<!-- 		      <input type="text" class="form-control" placeholder="请输入检索词"> -->
<!-- 		      <span class="input-group-btn"> -->
<!-- 		        <button class="btn btn-primary" type="button">查找</button> -->
<!-- 		      </span> -->
<!-- 		    </div>/input-group -->
<!-- 		  </div>/.col-lg-6 -->
<!-- 		</div>/.row -->
		
		
		<div class="row" id="syndrome" ng-app="myApp" ng-controller="myCtrl">
     <div class="col-xs-3">
	<div class="panel-group" role="tablist">
	
	<div class="panel panel-default">
      <div class="panel-heading" role="tab" id="bookHeading1">
        <h4 class="panel-title">
          <a ng-click="syndromeOrder()" class="collapsed" role="button" data-toggle="collapse" href="#bookListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
            证候分类
          </a>
        </h4>
      </div>
      <div id="bookListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="bookListGroupHeading1">
        <ul class="list-group">
<!--           -->
          <li class="list-group-item" ng-repeat="obj in level"><a href="javascript:void(0);" id="target_{{ obj.level2_name }}" ng-click="scrollToDiv2(obj)">{{ obj.level2_name }}({{ obj.number}})</a></li>
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
      <div id="bookListGroup2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="bookListGroupHeading2">
        <ul class="list-group">
          <li class="list-group-item" ng-repeat="obj in alphabets"><a href="javascript:void(0);" id="target_{{ obj.name }}" ng-click="scrollToDiv(obj)">{{ obj.name }}({{ obj.syndrome.length}})</a></li>
        </ul>
      </div>
    </div>
     </div>
    </div>
        
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="row">
					<div class = "syndrome-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='syndrome-data-table show_column-1'>病证名</th>
						      <th class='syndrome-data-table show_column-2'>概述</th>
						      <th class='syndrome-data-table show_column-3'>出处</th>
						      <th class='syndrome-data-table show_column-4'>操作</th>
						    </tr>
						  </thead>
						  <tbody id="table-all">
						  </tbody>
						</table>
						<div id="page-show" class='paginator'>
				          <div id="page_all" class="pagination"></div>
				        </div>
		            </div>
          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->
    </div> <!-- /container -->

	<div style="display:none"><span id="page-number-id">${pageNumber}</span><span id="page-size-id">${pageSize}</span></div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/packages/require.js" data-main="/js/syndrome"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="/js/angular.min.js"></script>
    <!--     <script src="/js/table_utils.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script> -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
 	$http({
        method: 'GET',
        url: '/syndrome/syndrome-order'
    }).then(function successCallback(response) {
    		console.log(response.data)
            $scope.level = response.data;
    		$scope.syndromes = $scope.level
    		console.log($scope.syndromes+"..........."+$scope.level)
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
 	
	 $http({
        method: 'GET',
        url: '/syndrome/alphabet-order'
    }).then(function successCallback(response) {
    		console.log(response.data)
            $scope.alphabets = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    }); 
	
	$scope.syndromeOrder = function(){
		console.log('level2Order')
		$scope.syndromes = $scope.level
	}

	$scope.alphabetOrder = function(){
		console.log('alphabetOrder')
		$scope.syndromes = $scope.alphabets
	}
	
	$scope.scrollToDiv = function(showItems){
		console.log(showItems.name)
		set_url('/syndrome/get_alpahbet');
		console.log("INIT:"+$('#page-number-id').text()+" "+showItems.syndrome.length)
		
		init_page_table_alphabet($('#page-number-id').text(),  $('#page-size-id').text(), "",showItems.name);
		    
		return false
	}
	
	$scope.scrollToDiv2 = function(showItems){
		console.log("111111111111"+"    "+showItems.number)
		console.log(showItems.level2_name)
		set_url('/syndrome/get_level');
		console.log("INIT:"+$('#page-number-id').text()+" "+showItems.number)
		console.log("2222222222222"+"  "+showItems.level2_name)
		init_page_table_alphabet($('#page-number-id').text(),  $('#page-size-id').text(), "",showItems.level2_name);
		return false
	}
});
</script>
  </body>
</html>
