<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "/common/common-head.ftl" />
    	<link href="/standard.css" rel="stylesheet">
	</head>

  	<body>
  		<#include "/common/nav.ftl" />
    	<div class="container">
    	
    		<#assign nav_name = ["中医标准"]>
    		<#assign nav_href = ["/standard_home.html"]>
    		<#include "/common/nav-pos.ftl"/>
          	<!-- Main component for a primary marketing message or call to action -->
      		<div class="jumbotron">
        	<h1>中医标准</h1>
      		</div>
      		
	      	<div class="row search-box">
				 <form action="/standard-search.html" method="post">
					  <div class="col-lg-10">
						    <div class="input-group">
						      <input type="text" class="form-control" name="keywords" placeholder="请输入标准名称">
						      <span class="input-group-btn">
						        <button class="btn btn-primary" type="submit" id="prescription-search">查找</button>
						      </span>
						    </div>
					  </div>
				  </form>
			</div>
			
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">人工心肺机&nbsp;&nbsp;医疗保健</p>
		</div>
		
		<br>
	
	  		<div class="row" id="dieases" ng-app="myApp" ng-controller="myCtrl">		
				<div class="col-xs-3">
					<div class="panel-group" role="tablist">
			    		<div class="panel panel-default">
				      		<div class="panel-heading" role="tab" id="imageHeading1">
				        		<h4 class="panel-title">
				          			<a ng-click=# class="collapsed" role="button" data-toggle="collapse" href="#diseasesListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
				           			 医药、卫生
				          			</a>
				        		</h4>
				      		</div>
			      			<div id="diseasesListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="diseasesGroupHeading1">
			        			<ul class="list-group">
			          				<li class="list-group-item" ng-repeat="obj in indexCollection"><a href="javascript:void(0);" id="target_{{ firstIndex }}" ng-click="scrollToDiv($event)">{{ obj.firstIndex }}({{obj.standardCount}})</a></li>
			        			</ul>
			      			</div>
			    		</div>
		  			</div>
				</div>
				
				<div class="col-xs-9" >								
					<div class="col-xs-11" ng-repeat="obj in indexCollection">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 id="_{{ obj.firstIndex }}">{{obj.firstIndex}}({{obj.standardCount}})</h3>
							</div>
						  	<div class="panel-body">
						    	<span ng-repeat="secondIndex in obj.secondIndexCollection" class="standard-span"><a href="/getStantardList?first_index={{ obj.firstIndex }}&second_index={{ secondIndex.second_index }}">{{secondIndex.ccs}} {{secondIndex.second_index}}({{secondIndex.standardCount}})</a></span>
						  	</div>
						</div>
					</div>
      			</div>

    		</div> 
    	</div>

	    <script src="/js/angular.min.js"></script>
	    <script src="/js/packages/jquery-2.14-min.js"></script> 
	 	<script src="/bootstrap/js/bootstrap.min.js"></script>
	 	
		<script>
			var app = angular.module('myApp', []);
			app.controller('myCtrl', function($scope, $http) {
				$http({
			        method: 'GET',
			        url: '/standard/show_index'
			    }).then(function successCallback(response) {
			    	console.log(response.data)
			            $scope.indexCollection = response.data;
			        }, function errorCallback(response) {
			        	console.log('failer')
			            // 请求失败执行代码
			    });
				
				$scope.dynastyOrder = function(){
					console.log('dynastiesOrder')
					$scope.books = $scope.dynasties
				}
				
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
