<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/proof/book-proof-main.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["中医古籍管理"]>
    <#assign nav_href = ["/proof-home"]>
    <#include "/common/nav-pos.ftl"/>
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医古籍管理</h1>  
        <!-- 标题栏注释掉 -->
        <!--  
         <nav class="menu">
            <a href="/tcm/">首页</a> | <a href="/tcm/book_list">古籍列表</a> | <a href="/tcm/book_proof">古籍校对</a> | <a href="/tcm/book_entity">古籍实体抽取</a> | <a href="/tcm/book_entity_panel">实体统计</a> | <a href="/tcm/proof_setting">设置</a> | <a href="/tcm/about_us">关于我们</a>  
         </nav>
         -->
 	</div>
 	<div class="row" id="books" ng-app="myApp" ng-controller="myCtrl">
		
	<div class="col-xs-3">
	 	<div class="panel panel-default">
	      <div class="panel-heading" role="tab" id="bookListGroupHeading2">
	        <h4 class="panel-title">
	          <a ng-click="alphabetOrder()" class="collapsed" role="button" data-toggle="collapse" href="#bookListGroup2" aria-expanded="true" aria-controls="bookListGroup2">
	            古籍管理
	          </a>
	        </h4>
	      </div>
	      <div id="bookListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="bookListGroupHeading2">
	      	<div style="width:40px; height:40px;margin: 0 auto;">
	        	<a href="/proof/setting"><font size="3px">设置</font></a>
        	</div>
	      </div>
	    </div>
	    <!-- panel panel-default -->
 	 </div>
 	 <!-- col-xs-3 -->
 	
 	
 	
 
    <div class="col-xs-9">
       <div class="row">
			<div class = "search-all">
				<table id="table" class="table">
					  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='diagnosis-data-table show_column-1'>序号</th>
						      <th class='diagnosis-data-table show_column-2'>古籍书名</th>
						      <th class='diagnosis-data-table show_column-2'>作者(朝代)</th>
						      <th class='diagnosis-data-table show_column-3'>原始版本链接</th>
						      <th class='diagnosis-data-table show_column-4'>矫正版本链接</th>
						      <th class='diagnosis-data-table show_column-5'>最后矫正时间</th>
						      <th class='diagnosis-data-table show_column-6'>实体抽取</th> 
						    </tr>
						    
					  </thead>
					  
					  
					  <!-- 
					  <tbody>
						  <#list book_list as item>
						  	<tr>
					  			<td>${item.id}</td>
     							<td><a id='name' href="#">${item.name}</a></td>
     							<td><a id='old' href="#">原始版本</a></td>
     							<td><a id='current' href="#">矫正版本</a></td>
     							<td>dd</td>
     							<td><a id='ex_entity' href="#">实体抽取</a></td>
						 	<tr>
					      </#list>
				      </tbody>
				       -->
				  <tbody id="table-all">
				  </tbody>
				</table>
				<div id="page-show" class='paginator'>
			          <div id="page_all" class="pagination"></div>
			        </div>
	            </div>
	            <!-- /.search-all -->
         </div>
         <!-- /.row -->
      
       <!-- 分页导航 -->
	<div id="page-show" class='paginator'>
    	<div id="page_all" class="pagination"></div>
    </div>
    </div> 
    <!-- col-xs-9 -->
    </div>
    <!-- /container -->
    
    
   
    </div>
   
    <!-- Bootstrap core JavaScript
    ================================================== -->
   
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/packages/require.js" data-main="/js/book-proof"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/tm.pagination.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
     <script>
     console.log("adc")
     //table项中添加超链接
    //设置点击跳转
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
