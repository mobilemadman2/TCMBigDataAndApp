<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "/common/common-head.ftl" />
    	<link rel="stylesheet" href="/acupoint/acupoint_main.css" > 
    	<link href="/book.css" rel="stylesheet">
    	
	</head>

  	<body>
  		<#include "/common/nav.ftl" />
    	<div class="container">
    	
    		<#assign nav_name = ["人体穴位"]>
    		<#assign nav_href = ["/acupoint.html"]>
    		<#include "/common/nav-pos.ftl"/>
          	<!-- Main component for a primary marketing message or call to action -->
      		<div class="jumbotron">
        	<h1>人体穴位图像</h1>
      		</div>
      		
      		<!-- 查找模块 -->
      		<div class="row search-box">
      		　　<form action="/acupoint_search.html" method="post">
				  <div class="col-lg-10">
				    <div class="input-group">
				      <input type="text" class="form-control" name="keywords" placeholder="请输入穴位名称或概要" id="input-keyword" value="">
				      <span class="input-group-btn">
				        <button class="btn btn-primary" type="submit" id="acupoint-search">查找</button>
				      </span>
				    </div><!-- /input-group -->
				  </div><!-- /.col-lg-6 -->
			  </form>
			</div><!-- /.row -->
			
			
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">天池&nbsp;&nbsp;少冲&nbsp;&nbsp;水突</p>
		</div>
		<br>
	
	
	  		<div class="row" id="dieases" ng-app="myApp" ng-controller="myCtrl">		
				<div class="col-xs-3">
					<div class="panel-group" role="tablist">
			    		<div class="panel panel-default">
				      		<div class="panel-heading" role="tab" id="imageHeading1">
				        		<h4 class="panel-title">
				          			<a ng-click=# class="collapsed" role="button" data-toggle="collapse" href="#diseasesListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
				           			 穴位种类
				          			</a>
				        		</h4>
				      		</div>
				      		<!--穴位分类-->
			      			<div id="diseasesListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="diseasesGroupHeading1">
			        			<ul class="list-group">
			          				<li class="list-group-item" ng-repeat="obj in acupoint_names_sort">
				          				<a class="collapsed" data-toggle="collapse" href="#small_detail_{{obj}} ">{{obj}}({{acup_numbers(obj)}})<b class="caret"></b></a>
				          				<ul class="list-group panel-collapse collapse in"  id="small_detail_{{obj}}">
				          					<li class="list-group-item" ng-repeat="obj in acup_name_lists(obj)"><a href="/acupoint/detail_picture?acupoint_name={{ obj }}" id="target_{{ obj }}" ng-click="scrollToDiv($event)" >{{obj}}({{get_acponit_numbers(obj)}})</a></li>
				          				</ul>
			          				</li>
			        			</ul>
			      			</div>	
			    		</div>
		  			</div>
				</div>
				
				<img src="/acupoint/acupoint_picture/timg.jpeg" alt="..." width="76%" height="76%" border="0" usemap="#Map" >
				<div>
					<p>鼠标点击穴位,显示详细信息</p>
				</div>
				<!-- 
				<map name="Map">
  					<area shape="rect" coords="0,2,90,90" href="#" onMouseOver="showpic(1)">
  					<area shape="rect" coords="710,1,800,88" href="#" onMouseOver="showpic(2)">
  					<area shape="rect" coords="2,600,100,700" href="#" onMouseOver="showpic(3)">
  					<area shape="rect" coords="700,600,800,700" href="#" onMouseOver="showpic(4)">
				</map>
				<div id="acupoint_text">
					<textarea id="text_1" rows="3" cols="20">太阳穴</textarea>
					<textarea id="text_2" rows="3" cols="20">天柱穴</textarea>
					<textarea id="text_3" rows="3" cols="20">中都穴</textarea>
					<textarea id="text_4" rows="3" cols="20">太白穴</textarea>
				</div>
				 -->
    		</div> 
    	</div>

	    <script src="/js/angular.min.js"></script>
	    <script src="/js/packages/jquery-2.14-min.js"></script> 
	 	<script src="/bootstrap/js/bootstrap.min.js"></script>
	 	
		<script>
		 	var oldpic;
		    function showpic(id){
		        if (oldpic) {
		            oldpic.style.display='none';
		        }
		        console.log(id)
		        oldpic = document.getElementById("text_"+id);
		        oldpic.style.display="block";
		        console.log('display and show is finished!')
		    }
		    
		  
	    
			var app = angular.module('myApp', []);
			app.controller('myCtrl', function($scope, $http) {
				//获取左边栏的分类信息
				$http({
			        method: 'GET',
			        url: '/acupoint/show_classes'
			    }).then(function successCallback(response) { 
			    		$scope.acupoints_big_classicify = new Array();
			    		$scope.acupoints_small_classicify = new Array();
			    		for (var key in response.data){
			    			$scope.acupoints_big_classicify.push(key);
			    			$scope.acupoints_small_classicify.push(response.data[key])
			    		}
			    		$scope.acupoint_names_sort = new Array();
			    		$scope.acupoint_names_sort.push($scope.acupoints_big_classicify[1]);
			    		$scope.acupoint_names_sort.push($scope.acupoints_big_classicify[2]);
			    		$scope.acupoint_names_sort.push($scope.acupoints_big_classicify[0]);
			    		/*
			    		//$scope.acupoints_small_classicify = response.data;
			    		//$scope.acupoints_small_classicify = response.data;
			            //$scope.acupoints_fourteen= response.data["十四经经穴图"];
			            console.log($scope.acupoints_small_classicify)
			            console.log($scope.acupoints_big_classicify) */
			            $scope.temp = response.data
			            console.log(response.data)
			        }, function errorCallback(response) {
			        	console.log('failer')
			            // 请求失败执行代码
			    });
				
				
				//获取具体每个穴位的数量
				$http({
			        method: 'GET',
			        url: '/acupoint/show_classes_numbers'
			    }).then(function successCallback(response) { 
			    		$scope.acupoint_numbers = response.data;
			            console.log(response.data)
			        }, function errorCallback(response) {
			        	console.log('get count failer')
			            // 请求失败执行代码
			    });
				
				//添加十二经脉等大穴位数量
			   $scope.acup_numbers = function(element) {
				  //console.log("acupoint numbers");
				  //console.log(element);
				  return $scope.temp[element].length;
			    };
			    
			    $scope.acup_name_lists = function(element) {
					  //console.log("acup_name_lists");
					  //console.log(element);
					  return $scope.temp[element];
				  };
				  
				//获取手太阴肺经中的小穴位数量
				$scope.get_acponit_numbers = function(element){
					console.log("getting counts now");
					console.log(element);
					return $scope.acupoint_numbers[element];
				}
				
				
				//左边栏点击防止滑动的函数
				$scope.scrollToDiv = function(event){
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
