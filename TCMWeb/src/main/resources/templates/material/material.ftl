<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/disease-homepage.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["中草药"]>
    <#assign nav_href = ["/material.html"]>
    <#include "/common/nav-pos.ftl"/>
    
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中草药</h1>
<!--         <p>To see the difference between static and fixed top navbars, just scroll.</p> -->
      </div>
    <div class="row search-box">
		 <form action="/es-search/material.html">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入中草药名称或性状">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="material-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		  </form>
		</div><!-- /.row -->  

		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">甘草&nbsp;&nbsp;五味子&nbsp;&nbsp;人参</p>
		</div>
		
		<br>
		
<!-- 		<div class="row"> -->
		<div class="row" id="materials" ng-app="myApp" ng-controller="myCtrl">
	<div class="col-xs-3">
	<div class="panel-group" role="tablist">
	
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
          <li class="list-group-item" ng-repeat="obj in alphabets"><a href="javascript:void(0);" id="target_{{ obj.name }}" ng-click="scrollToDiv(obj)">{{ obj.name }}({{ obj.materials.length }})</a></li>
        </ul>
      </div>
    </div>
     </div>
    </div>
   <!--   </div>--> <!-- /container -->
		
<!--         <div class="col-lg-3">


<h1 class="my-3">中草药操作</h1>
          <div class="list-group">
            <a href="/infoAddDataMaterial.html" class="list-group-item">新增中草药</a>
            <a href="#" class="list-group-item">更新方剂</a>
          </div>

        </div> -->
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='material-data-table show_column-1'>名称</th>
						      <th class='material-data-table show_column-2'>性状</th>
						      <!-- <th class='material-data-table show_column-3'>功效</th> -->
						      <th class='material-data-table show_column-3'>更新时间</th>
						      <th class='material-data-table show_column-4'>操作</th>
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
    <script src="/js/packages/require.js" data-main="/js/material"></script>
    <script src="/js/angular.min.js"></script>
    <!--     <script src="/js/table_utils.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script> -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
/* 	$http({
        method: 'GET',
        url: '/book/dynasty-order'
    }).then(function successCallback(response) {
    	console.log(response.data)
            $scope.dynasties = response.data;
    		$scope.books = $scope.dynasties
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    }); */
	
	 $http({
        method: 'GET',
        url: '/material/alphabet-order'
    }).then(function successCallback(response) {
    	console.log(response.data)
            $scope.alphabets = response.data;
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    }); 
	
/* 	
	$scope.dynastyOrder = function(){
		console.log('dynastiesOrder')
		$scope.books = $scope.dynasties
	}
	 */
	$scope.alphabetOrder = function(){
		console.log('alphabetOrder')
		$scope.materials = $scope.alphabets
	}
	
	$scope.scrollToDiv = function(showItems){
		console.log(showItems.name)
		//alert(showItems.materialsId)
		//var action_columns = ['查看1','|','删除1','|','更新1'];
		//set_action_columns(action_columns);
		set_url('/material/get_alpahbet');
		console.log("INIT:"+$('#page-number-id').text()+" "+showItems.materials.length)
		
		init_page_table_alphabet($('#page-number-id').text(),  $('#page-size-id').text(), "",showItems.name);
		
		//alert("end"+showItems.length)
		//init_page_table_alphabet($('#page-number-id').text(), $('#page-size-id').text(), "");
/* 		require(['jquery','bootstrap','jquery_page'], function ($) {
			init_page_table_alphabet($('#page-number-id').text(), $('#page-size-id').text(), "");
			}); */
			
		/* 	$http({
		        method: 'GET',
		        url: '/material/htmlzxzxzx'
		    }).then(function successCallback(response) {
		    	console.log(response.data)
		           alert(response.data);
		        }, function errorCallback(response) {
		        	console.log('failer')
		            // 请求失败执行代码
		    }); */
	/* 	    $http({
		        method: 'GET',
		        url: '/material/htmlzxzxzx'
		    }).then(function successCallback(response) {
		    	console.log(response.data)
		            alert(response.data)
		        }, function errorCallback(response) {
		        	console.log('failer')
		            // 请求失败执行代码
		    }); */
		    
		return false
	}
});
</script>
<!--      <script>
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
		$http({
	        method: 'GET',
	        url: '/materil/alphabettest'
	    }).then(function successCallback(response) {
	    	console.log(response.data)
	            $scope.alphabets = response.data;
	        }, function errorCallback(response) {
	        	console.log('failer')
	            // 请求失败执行代码
	    });
/* 		console.log(event.target.id)
		target_div = event.target.id.replace('target_','')
		console.log('...')
		
		window.location.hash="#_"+target_div
		window.scrollBy(0,-90) */
		return false
	}
});
</script> -->
  </body>
</html>
