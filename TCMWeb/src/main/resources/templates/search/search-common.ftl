<div class="container"  ng-app="SearchResult" ng-controller="searchResCtrl">
	<div class="row search-box">
	<div  class="col-lg-4">
			<h2>${searchName!""}</h2>
		</div>
		  <div class="col-lg-8" style="padding-top:20px;">
		    <div class="input-group">
		      <input type="text" class="form-control" placeholder="请输入检索词" id="keywords">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="button" ng-click='search()'>查找</button>
		      </span>
		    </div>
		  </div>
		</div>
		
<!-- 		<span ng-if="classify=='all'" class="badge-style disease-badge">疾病</span> -->
<!-- 		<span ng-if="classify=='all'" class="badge-style prescription-badge">方剂</span> -->
<!-- 		<span ng-if="classify=='all'" class="badge-style material-badge">中草药</span> -->
<!-- 		<span ng-if="classify=='all'" class="badge-style expert-medicalcase-badge">医案</span> -->
<!-- 		<span ng-if="classify=='all'" class="badge-style syndrome-badge">证候</span> -->
<!-- 		<span ng-if="classify=='all'" class="badge-style expert-badge">名家</span> -->
		
		<div class="row row-space ${multiTag}">
			<a class="res-type active" ng-click="moveto('all', $event)" id="default-search">全部</a>
			<a class="res-type"  ng-click="moveto('disease', $event)">疾病</a>
			<a class="res-type"  ng-click="moveto('bing_zheng_tab1', $event)">证候</a>
			<a class="res-type"  ng-click="moveto('prescription', $event)">方剂</a>
			<a class="res-type"  ng-click="moveto('material', $event)">中草药</a>
			<a class="res-type"  ng-click="moveto('expert_medical_case', $event)">医案</a>
			<a class="res-type"  ng-click="moveto('expert', $event)">名家</a>
		</div>
		<br>
		

		<div class="row row-space" >
		<div ng-if="entities==null||entities.length==0">
			<span class="no-content">未查找找到相关内容</span3>
		</div>
			<div class="row" ng-repeat="entity in entities">
				<div class="panel panel-default" ng-if="entity.source._index=='disease'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style disease-badge">疾病</span>
				  <a href="/disease/info.html?diseaseId={{ entity.source._source.id}}">{{ entity.source._source.name}}</a>
				  </div>
				  <div class="panel-body">
				    【概述】：{{ entity.source._source.overview}}
				  </div>
				</div>
			
				<div class="panel panel-default" ng-if="entity.source._index=='prescription'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style prescription-badge">方剂</span>
				  <a href="/prescription/info.html?prescriptionId={{ entity.source._source.id}}">{{ entity.source._source.name}}</a>
				  </div>
				  <div class="panel-body">
				    【组成】：{{ entity.source._source.composition}}
				  </div>
				</div>
				
				<div class="panel panel-default" ng-if="entity.source._index=='material'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style material-badge">中草药</span>
				  <a href="/material/info.html?materialId={{ entity.source._source.id}}">{{ entity.source._source.name_cn}}</a>
				  </div>
				  <div class="panel-body">
				    【性状】：{{ entity.source._source.attribution}}
				  </div>
				</div>
				
				<div class="panel panel-default" ng-if="entity.source._index=='expert_medical_case'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style expert-medicalcase-badge">医案</span>
				  <a href="/medicalcase/info.html?materialcaseId={{ entity.source._source.id}}">{{ entity.source._source.doctor_name}}</a>
				  </div>
				  <div class="panel-body">
				    【诊断】：{{ entity.source._source.tcm_diagnosis}}
				  </div>
				</div>				
				
				<div class="panel panel-default" ng-if="entity.source._index=='bing_zheng_tab1'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style syndrome-badge">证候</span>
				  <a href="/syndrome/info.html?syndromeId={{ entity.source._source.id}}">{{ entity.source._source.name}}</a>
				  </div>
				  <div class="panel-body">
				    【描述】：{{ entity.source._source.general_description}}
				  </div>
				</div>
				
				<div class="panel panel-default" ng-if="entity.source._index=='expert'">
				  <div class="panel-heading">
				  <span ng-if="classify=='all'" class="badge-style expert-badge">名家</span>
				  <a href="/expert/info.html?expertId={{ entity.source._source.id}}">{{ entity.source._source.name}}</a>
				  </div>
				  <div class="panel-body">
				    【荣誉】：{{ entity.source._source.honor}}
				  </div>
				</div>
					
		</div>
		
<!-- 	<tm-pagination conf="paginationConf"></tm-pagination> -->
		<pager first-text="首页" last-text="尾页" prev-text="上一页" next-text="下一页" page-count="pageCount" current-page="currentPage" on-page-change="onPageChange()"></pager> 
		</div>
		
<script src="/js/packages/jquery-2.14-min.js"></script>
<script src="/js/angular.js"></script>
<script src="/js/ng-pagination.js"></script>

<script>
var app = angular.module('SearchResult', ["ng-pagination"]);
app.controller('searchResCtrl', function($scope, $http) {
	$scope.content='${content!}'
	$scope.default_classify = "${search_classify}"
	$scope.classify = "${search_classify}"
	$scope.pageCount = 1
	$scope.pageSize =  10
	$scope.parseResult = function(response){
		console.log(response.data)
// 		console.log(Math.ceil(parseFloat(response.data.rows.length)/Math.ceil($scope.pageSize)))
        $scope.entities = response.data.rows;
		$scope.pageCount = Math.ceil(parseFloat(response.data.totalHits)/Math.ceil($scope.pageSize));
	}
	$scope.getSearchQuery = function(){
		$http({
	        method: 'GET',
	        url: '/search/index',
 	        params: {
 	        	'content': $scope.content,
 	        	'index': $scope.classify,
 	        	'pageNumber': $scope.pageCount,
 	        	'pageSize': $scope.pageSize
 	        }
	    }).then(function successCallback(response) {
  		    $scope.parseResult(response)
	    }, function errorCallback(response) {
	        	console.log('failer')
	    });
	}
	
	$scope.getSearchQuery()
	$scope.moveto = function(classify, event){
// 		console.log(classify);
		$scope.classify = classify;
		angular.element(".res-type").removeClass('active')
		angular.element(event.target).addClass('active')
		console.log($scope.content+'\t'+$scope.classify)
		$scope.pageCount = 1
		$scope.getSearchQuery()
	}
	
	$scope.search = function(){
		$scope.classify = $scope.default_classify;
		if(angular.element("#keywords").val().trim()==''){
			alert('请输入查找关键词！')
			return
		}
		$scope.pageCount = 1
		angular.element(".res-type").removeClass('active')
		angular.element("#default-search").addClass('active')
		$scope.content = angular.element("#keywords").val()
		$scope.getSearchQuery()
	}
	

	$scope.onPageChange = function() {
	      // ajax request to load data
	      console.log($scope.currentPage);

	  	$scope.pageCount = $scope.currentPage;
	  	console.log($scope.pageCount)
	      $scope.getSearchQuery();

		scrollTo(0,0)
	    };

	    // set pagecount in $scope

	
});
</script>
