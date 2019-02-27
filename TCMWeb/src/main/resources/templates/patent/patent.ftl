<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    	<#assign nav_name = ["中医专利"]>
    	<#assign nav_href = ["/patent.html"]>
    	<#include "/common/nav-pos.ftl"/>
    	
          <!-- Main component for a primary marketing message or call to action -->
        <div class="jumbotron">
        	<h1>中医专利信息</h1>
        </div>
        
        <div class="row search-box">
				 <form action="/patent_search.html" method="post">
					  <div class="col-lg-10">
						    <div class="input-group">
						      <input type="text" class="form-control" name="keywords" placeholder="请输入名称或专利主题词">
						      <span class="input-group-btn">
						        <button class="btn btn-primary" type="submit" id="patent-search">查找</button>
						      </span>
						    </div>
					  </div>
				  </form>
		</div>
		
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">一种对虾促生长的复方中草药及其制造方法&nbsp;&nbsp;中草药</p>
		</div>
		
		<br> 
      
      
      		
        <div class="row" id="patents" ng-app="myApp" ng-controller="myCtrl">
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
			          <li class="list-group-item" ng-repeat="obj in alphabets"><a href="javascript:void(0);" id="target_{{ obj.name }}" ng-click="scrollToDiv(obj)">{{ obj.name }}({{ obj.patents.length }})</a></li>
			        </ul>
			      </div>
			    </div>
		     </div>
	    </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='patent-data-table show_column-1'>名称</th>
						      <th class='patent-data-table show_column-2'>摘要</th>
						      <th class='patent-data-table show_column-3'>更新时间</th>
						      <th class='patent-data-table show_column-4'>操作</th>
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
    <script src="/js/packages/require.js" data-main="/js/patent"></script>
    <script src="/js/angular.min.js"></script>
    <script>
		var app = angular.module('myApp', []);
		app.controller('myCtrl', function($scope, $http) {			
			 $http({
		        method: 'GET',
		        url: '/patent/alphabet-order'
		    }).then(function successCallback(response) {
		    	console.log(response.data)
		            $scope.alphabets = response.data;
		        }, function errorCallback(response) {
		        	console.log('failer')
		            // 请求失败执行代码
		    }); 		
			$scope.alphabetOrder = function(){
				console.log('alphabetOrder')
				$scope.patents = $scope.alphabets
			}			
			$scope.scrollToDiv = function(showItems){
				console.log(showItems.name)
				set_url('/patent/get_alpahbet');
				console.log("INIT:"+$('#page-number-id').text()+" "+showItems.patents.length)		
				init_page_table_alphabet($('#page-number-id').text(),  $('#page-size-id').text(), "",showItems.name);			    
				return false
			}
		});
	</script>
  </body>
</html>
