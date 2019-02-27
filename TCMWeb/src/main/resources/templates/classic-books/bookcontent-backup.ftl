<!-- 
use panel as a 2-level navigator by angularJs

 -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>中医大数据</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/navbar-fixed-top.css" rel="stylesheet">
    <link href="/disease-homepage.css" rel="stylesheet">
    <link href="/angular-ui-tree.css" rel="stylesheet">
    <link href="/app.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container"  ng-app="myApp" ng-controller="myCtrl">
<!-- Nested node template -->
<script type="text/ng-template" id="nodes_renderer.html">
  <div ui-tree-handle class="tree-node tree-node-content" data-nodrag >
    <a class="btn btn-success btn-xs" ng-if="node.nodes && node.nodes.length > 0" data-nodrag data-collapsed="true" ng-click="toggle(this)"><span
        class="glyphicon"
        ng-class="{
          'glyphicon-chevron-right': collapsed,
          'glyphicon-chevron-down': !collapsed
        }"></span></a>
    <span ng-click="expandContent(node.id)">{{node.title}}</span>
  </div>
  <ol ui-tree-nodes="" ng-model="node.nodes" data-collapsed="true" ng-class="{hidden: collapsed}">
    <li ng-repeat="node in node.nodes" data-nodrag ui-tree-node ng-include="'nodes_renderer.html'">
    </li>
  </ol>
</script>




          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>{{ book.book_title }}</h1>
<!--         <p>To see the difference between static and fixed top navbars, just scroll.</p>
 -->      
 	</div>
		<div class="row" >
        <div class="col-lg-3">
          <h1 class="my-4">目录</h1>
          
    <div ui-tree id="tree-root">
      <ol ui-tree-nodes ng-model="data">
        <li ng-repeat="node in data" ui-tree-node data-collapsed="true" ng-include="'nodes_renderer.html'"></li>
      </ol>
    </div>
          <div class="panel-group" role="tablist">
    <div class="panel panel-default" ng-repeat="obj in book.content">
      <div class="panel-heading" role="tab" id="bookHeading{{ $index+1}}">
        <h4 class="panel-title">
          <a  ng-click="mmclick($event, 'a-'+$index)" class="collapsed" role="button" data-toggle="collapse" href="#bookDirectoryGroup{{ $index+1}}" aria-expanded="false" aria-controls="bookDirectoryGroup{{ $index+1}}">
            {{ obj.title }}
          </a>
        </h4>
      </div>
      <div id="bookDirectoryGroup{{ $index+1}}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="bookDirectoryGroupHeading{{ $index+1}}">
        <ul class="list-group" ng-if="obj.content[0].content[0].type!=section">
          <li class="list-group-item" ng-repeat="objSecond in obj.content" ng-click="mmclick($event, 'li-'+$parent.$index+'-'+$index)">{{ objSecond.title }}</li>
        </ul>
      </div>
      
      
    </div>   
  </div>
  </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="row">
<!--           <p>{{ content }}</p> -->
			<div ng-repeat="para in paras">
           	 <p>{{ para.detail }}</p>
           </div>
          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/angular.min.js"></script>
    <script src="/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/angular-ui-tree.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
    
<script>
var app = angular.module('myApp', ['ui.bootstrap','ui.tree']);

app.controller('myCtrl', function($scope, $http) {
	console.log('action')
    $scope.count = 0;
	$scope.content = 'abcde'

	$scope.directory = [];

	$scope.mm = function(section, arr,currId){
//  		console.log('length"'+section.content.length+"\t"+section.title)
		
		for(var i=0;i<section.content.length;i++){
// 			console.log(i+"\t"+section.content[i].type)
			if(section.content[i].type=='section'){
				var m = {};
				m.title = section.content[i].title
				m.nodes = [];
				m.id=currId+'-'+i
				arr.push(m);
				$scope.mm(section.content[i],arr[i].nodes,m.id)
// 				$scope.mm(section.content[i].content)
			}else{
				break
			}
// 				$scope.mm(section.content[i])
		}
	}
	$scope.data = $scope.directory
	
	console.log($scope.directory)

	$http({
        method: 'GET',
        url: '/book1.json'
    }).then(function successCallback(response) {
//     	console.log(response.data)
            $scope.book = response.data;
    		$scope.paras = $scope.book.content[0].content
    		$scope.mm($scope.book,$scope.directory,'id')
//     		console.log($scope.book)
    	
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });

	$scope.mmclick = function(event, source){
		/* console.log(source) */
		$scope.content = source
		tmp = event.target
		arr = source.split('-')
 		console.log(arr)
		paras = null
		if(arr.length==2){
// 			console.log('#bookDirectoryGroup'+(parseInt(arr[1])+1))
 			console.log($('#bookDirectoryGroup'+(parseInt(arr[1])+1)+ ' ul li') )
			if($('#bookDirectoryGroup'+(parseInt(arr[1])+1) + ' ul li').length==0){
				console.log('aaa')
// 				console.log($scope.book.content[arr[1]])
				paras = $scope.book.content[arr[1]].content
				$scope.paras = paras
				console.log(paras)
			}else{
				console.log('else')
				//if the directory is collapsed
				//console.log($('#bookDirectoryGroup'+(parseInt(arr[1])+1)).hasClass('collapse in'))
			}
			
		}else if (arr.length == 3) {
// 			console.log($scope.book.content[arr[1]].content[arr[2]].content)
			paras = $scope.book.content[arr[1]].content[arr[2]].content
			$scope.paras = paras
			console.log(paras)
		}
		
//  		console.log(event.target)
//  		console.log(event.target.parentNode)
 	}
	
	
	$scope.expandContent = function(contentId){
		arr = contentId.split('-')
		var curr = $scope.book.content
		for(i=1; i<arr.length; i++){
// 			console.log(arr[i])
 			curr = curr[parseInt(arr[i])].content
		}
// 		console.log(curr)
		if(curr[0].type!='section'){
			console.log('print')
			$scope.paras = curr
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	$scope.remove = function (scope) {
        scope.remove();
      };

      $scope.toggle = function (scope) {
    	  console.log('aaa')
//         scope.toggle();
      };

      $scope.moveLastToTheBeginning = function () {
        var a = $scope.data.pop();
        $scope.data.splice(0, 0, a);
      };

      $scope.newSubItem = function (scope) {
        var nodeData = scope.$modelValue;
        nodeData.nodes.push({
          id: nodeData.id * 10 + nodeData.nodes.length,
          title: nodeData.title + '.' + (nodeData.nodes.length + 1),
          nodes: []
        });
      };

      $scope.collapseAll = function () {
        $scope.$broadcast('angular-ui-tree:collapse-all');
      };

      $scope.expandAll = function () {
        $scope.$broadcast('angular-ui-tree:expand-all');
      };

      $scope.dataa = [{
        'id': 1,
        'title': 'node1',
        'nodes': [
          {
            'id': 11,
            'title': 'node1.1',
            'nodes': [
              {
                'id': 111,
                'title': 'node1.1.1',
                'nodes': []
              }
            ]
          },
          {
            'id': 12,
            'title': 'node1.2',
            'nodes': []
          }
        ]
      }, {
        'id': 2,
        'title': 'node2',
        'nodrop': true, // An arbitrary property to check in custom template for nodrop-enabled
        'nodes': [
          {
            'id': 21,
            'title': 'node2.1',
            'nodes': []
          },
          {
            'id': 22,
            'title': 'node2.2',
            'nodes': []
          }
        ]
      }, {
        'id': 3,
        'title': 'node3',
        'nodes': [
          {
            'id': 31,
            'title': 'node3.1',
            'nodes': []
          }
        ]
      }];
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});
</script>
  </body>
</html>
