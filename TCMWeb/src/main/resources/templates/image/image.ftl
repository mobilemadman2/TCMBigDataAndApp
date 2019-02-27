<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "/common/common-head.ftl" />
    	<link href="/book.css" rel="stylesheet">
	</head>

  	<body>
  		<#include "/common/nav.ftl" />
    	<div class="container">
    	
    		<#assign nav_name = ["医疗图像"]>
    		<#assign nav_href = ["/image.html"]>
    		<#include "/common/nav-pos.ftl"/>
          	<!-- Main component for a primary marketing message or call to action -->
      		<div class="jumbotron">
        	<h1>医学图像</h1>
      		</div>
	
	  		<div class="row" id="dieases" ng-app="myApp" ng-controller="myCtrl">		
				<div class="col-xs-3">
					<div class="panel-group" role="tablist">
			    		<div class="panel panel-default">
				      		<div class="panel-heading" role="tab" id="imageHeading1">
				        		<h4 class="panel-title">
				          			<a ng-click=# class="collapsed" role="button" data-toggle="collapse" href="#diseasesListGroup1" aria-expanded="true" aria-controls="bookListGroup1">
				           			 疾病种类
				          			</a>
				        		</h4>
				      		</div>
			      			<div id="diseasesListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="diseasesGroupHeading1">
			        			<ul class="list-group">
			          				<li class="list-group-item" ng-repeat="obj in diseases"><a href="javascript:void(0);" id="target_{{ obj.disease_class }}" ng-click="scrollToDiv($event)">{{ obj.disease_class }}({{obj.imageCount}})</a></li>
			        			</ul>
			      			</div>
			    		</div>
		  			</div>
				</div>
				
				<div class="col-xs-9" >								
					<div class="col-xs-11" ng-repeat="obj in diseases">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 id="_{{ obj.disease_class }}">{{obj.disease_class}}</h3>
							</div>
						  	<div class="panel-body">
						    	<span ng-repeat="countImage in obj.image_classes" class="book-span"><a href="/getImageList?disease_class={{ obj.disease_class }}&image_class={{ countImage.image_class }}"> {{ countImage.image_class }}({{countImage.imageCount}})</a></span>
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
			        url: '/image/show_classes'
			    }).then(function successCallback(response) {
			    	console.log(response.data)
			            $scope.diseases = response.data;
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
