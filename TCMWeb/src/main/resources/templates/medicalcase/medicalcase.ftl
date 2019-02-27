<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/medical-case/medical-case-main.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["中医医案"]>
    <#assign nav_href = ["/medicalcase.html"]>
    <#include "/common/nav-pos.ftl"/>
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医医案</h1>  
 	</div>
 	
 	<!-- 查找模块 -->
		<div class="row search-box">
	    	<form action="/materialcase_search.html" method="post">
			  <div class="col-lg-10">
			    <div class="input-group">
			      <input type="text" class="form-control" name="keywords" placeholder="请输入名家或者症状" id="input-keyword" value="">
			      <span class="input-group-btn">
			        <button class="btn btn-primary" type="submit" id="acupoint-search">查找</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
		  </form>
		</div><!-- /.row -->
       <div class="row" id="dieases" ng-app="myApp" ng-controller="myCtrl">		
				<div class="col-xs-3">
					<div class="panel-group" role="tablist">
			    		<div class="panel panel-default">
				      		<div class="panel-heading" role="tab" id="imageHeading1">
				        		<h4 class="panel-title">
				          			<a ng-click=# class="collapsed" role="button" data-toggle="collapse" href="#diseasesListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
				           			 名家分类
				          			</a>
				        		</h4>
				      		</div>
				      		<!--穴位分类-->
			      			<div id="diseasesListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="diseasesGroupHeading1">
			        			<ul class="list-group">
			          				<li class="list-group-item" ng-repeat="obj in acupoint_names_sort">
				          				<a class="collapsed" data-toggle="collapse" href="#small_detail_{{obj}} ">{{obj}}({{acup_numbers(obj)}})<b class="caret"></b></a>
				          				<ul class="list-group panel-collapse collapse in"  id="small_detail_{{obj}}">
				          					<li class="list-group-item" ng-repeat="obj in acup_name_lists(obj)"><a href="#" id="target_{{ obj }}" ng-click="scrollToDiv($event,obj)" >{{obj}}({{get_acponit_numbers(obj)}})</a></li>
				          				</ul>
			          				</li>
			        			</ul>
			      			</div>	
			    		</div>
		  			</div>
		  			<!-- panel-group -->
				</div>
				<!-- col-xs-3 -->
				
           <div class="col-xs-9">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='diagnosis-data-table show_column-1'>中医诊断</th>
						      <th class='diagnosis-data-table show_column-2'>西医诊断</th>
						      <th class='diagnosis-data-table show_column-3'>名老中医</th>
						      <th class='diagnosis-data-table show_column-4'>主诉症状</th>
						      <th class='diagnosis-data-table show_column-5'>治则治法</th>
						      <th class='diagnosis-data-table show_column-6'>操作</th>
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
    </div> <!-- /container -->

	<div style="display:none">
		<span id="page-number-id">${pageNumber}</span>
		<span id="page-size-id">${pageSize}</span>
		<span id="sort-type">${sortType}</span>
	</div>
	
	
	
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/packages/require.js" data-main="/js/medicalcase"></script>
    <script src="/js/packages/require.js" data-main="/js/medicalcase-research"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/angular.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
     <script>
	 var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $http) {
		//获取左边栏的分类信息
		$http({
	        method: 'GET',
	        url: '/materialcase/alphabet-order'
	    }).then(function successCallback(response) { 
	    	var data = angular.toJson(response.data);
	    	$scope.data = JSON.parse(data)
	    	//console.log(data)
	    	$scope.acupoint_names_sort = new Array();
	    	for (var key in $scope.data){
	    		console.log(key);
    			$scope.acupoint_names_sort.push(key);
    			//$scope.acupoints_small_classicify.push(response.data[key])
    		}
	    	
	    	//$scope.acupoint_names_sort = data
	        }, function errorCallback(response) {
	        	console.log('failer')
	            // 请求失败执行代码
	    });
		
		$http({
	        method: 'GET',
	        url: '/materialcase/doctor_numbers'
	    }).then(function successCallback(response) { 
	    	$scope.doctor_numbers = angular.toJson(response.data);
	    	$scope.doctor_numbers = JSON.parse($scope.doctor_numbers)
	    	//$scope.acupoint_names_sort = data
	        }, function errorCallback(response) {
	        	console.log('failer')
	            // 请求失败执行代码
	    });
		//名医的列表
		$scope.acup_name_lists = function(obj){
			console.log("detail")
			console.log($scope.data[obj])
			return $scope.data[obj]
		}
		//每个字母下名医的数量
		$scope.acup_numbers = function(obj){
			return $scope.data[obj].length
		}
		
		//每个医生有多少病历
		$scope.get_acponit_numbers = function(obj){
			return $scope.doctor_numbers[obj];
		}
		
		console.log("dddddd")
		//左边栏点击防止滑动的函数
		$scope.scrollToDiv = function(event,obj){
			console.log("dddsdfsdf")
			console.log(obj);
			var data = {keywords: obj};
			var params = Object.keys(data).map(function(key){
				return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
			}).join("&");
			window.open("/medical-case/search_info_doctor?"+params,"_self"); 
			console.log(event.target.id)
			target_div = event.target.id.replace('target_','')
			console.log('...')
			window.location.hash="#_"+target_div
			window.scrollBy(0,-90)
			return false
		}
	});
    </script>
    
   
  </body>
</html>
