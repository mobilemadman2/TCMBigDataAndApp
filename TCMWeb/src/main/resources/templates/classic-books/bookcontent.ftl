<!DOCTYPE html>
<html lang="en">
  <head>
		<#include "/common/common-head.ftl"/>
    <link href="/disease-homepage.css" rel="stylesheet">
    <link href="/angular-ui-tree.css" rel="stylesheet">
    <link href="/app.css" rel="stylesheet">
    <link href="/book.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />

  	
    <div class="container"  ng-app="myApp" ng-controller="myCtrl">
    
    <!-- 页面当前位置导航 -->
    <#assign nav_name = ["中医古籍","${bookname}"]>
    <#assign nav_href = ["/books.html", "/getbook?name=${bookname}"]>
    <#include "/common/nav-pos.ftl"/>
    <!-- 页面当前位置导航结束 -->
    
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
	  </div>
        <!-- /.col-lg-3 -->

<div class="col-lg-7 book-border">
	<div class="row">
	<div class="panel-group" role="tablist">
	<!-- 设置了相同的data parent会关闭其它的 -->
	<div class="panel panel-default">
	    <div class="panel-heading" id="originTextHeading">
	      <h4 class="panel-title">
	        <a role="button" ng-click="panelTab('collapseOriginTextHeading')">
	          原文
	        </a>	       
	      </h4>
	    </div>
	    <div id="collapseOriginTextHeading" class="panel-collapse collapse in">
	      <div class="panel-body book-scroll" style="font-size:18px;">
	        <div id="OriginText">
	          
	        </div>

	      </div>
	    </div>
	  </div>
	  
	  <div class="panel panel-default">
	    <div class="panel-heading" id="originHeading">
	      <h4 class="panel-title">
	        <a role="button" ng-click="panelTab('collapseOriginHeading')">
	          原始文献
	        </a>	       
	      </h4>
	    </div>
	    <div id="collapseOriginHeading" class="panel-collapse collapse in">
	      <div class="panel-body book-scroll" style="font-size:18px;">
	        <div ng-repeat="para in paras" >
	           	 <h4>{{ para.detail }}</h4>
	         </div>
	      </div>
	    </div>
	  </div>
	  
	  
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingAnnotation">
	      <h4 class="panel-title">
	        <a role="button" ng-click="panelTab('collapseAnnotation')">
	          注释
	        </a>
	      </h4>
	    </div>
	    <div id="collapseAnnotation" class="panel-collapse collapse">
	      <div class="panel-body">
	        <div ng-repeat="annotation in annotations"  ng-if='annotations!=null'>
	          <h4>{{ annotation.detail }}</h4>
	        </div>
	        <div ng-if='annotations==null'>暂无内容</div>
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingTranslation">
	      <h4 class="panel-title">
	        <a role="button" ng-click="panelTab('collapseTranslation')">
	          译文
	        </a>
	      </h4>
	    </div>
	    <div id="collapseTranslation" class="panel-collapse collapse">
	      <div class="panel-body">
	        <div ng-repeat="translation in translations" ng-if='translations!=null'>
	           <h4>{{ translation.detail }}</h4>
	         </div>
	         <div ng-if='translations==null'>暂无内容</div>
	      </div>
	    </div>
	  </div>
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingSummary">
	      <h4 class="panel-title">
	        <a role="button" ng-click="panelTab('collapseSummary')">
	          解说
	        </a>
	      </h4>
	    </div>
	    <div id="collapseSummary" class="panel-collapse collapse">
	      <div class="panel-body">
	        <div ng-repeat="summary in summaries" ng-if='summaries!=null'>
	          <h4>{{ summary.detail }}</h4>
	        </div>
	        <div ng-if='summaries==null'>暂无内容</div>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	
	<div class="row">
<div class="page-header">
  <h4>该章节包含的关键词：<small></small></h4>
  <div ng-repeat="(entitykey, name) in bookentities.views"${bookname}>
  <div class="panel panel-default">
	<div class="panel-heading">
	  <div class="panel-title">{{ name }}<a class="btn btn-default btn-sm" style="float:right;" href="/relation/interactive?entitykey={{ entitykey }}&book={{ bookname }}&path={{ path }}" role="button">编辑</a>
	  </div>
	</div>
    <div class="panel-body">
<div ng-repeat="entity in bookentities.relations[entitykey]" >
        <div class="label label-info label-entity" style="margin:3px;" 
        id="{{ entitykey + '_' + entity.relatedEntity }}" ng-if="(entitykey+'_'+entity.relatedEntity)!=editingEntity">
        <a href="{{ entity.uri }}" target="_blank" ng-if="entity.uri!=null">{{ entity.relatedEntity }}</a>
        <span ng-if="entity.uri==null">{{ entity.relatedEntity }}</span>
        <span class="glyphicon glyphicon-edit" aria-hidden="true" ng-click="editEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span>
        <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="removeEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span>
        </div>
        
        <div class="label label-danger label-entity" style="margin:3px;" 
        id="{{ entitykey }}_{{entity.relatedEntity}}" ng-if="(entitykey+'_'+entity.relatedEntity)==editingEntity">
        <input type="text" style="color:black" id="{{ entitykey }}_{{entity.relatedEntity}}_input" value="{{ entity.relatedEntity }}" />
        <span class="glyphicon glyphicon-ok" aria-hidden="true" ng-click="finishEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span>
        <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="cancelEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span>
        </div>
        </div>
        
        <!-- 新添加实体标签 -->
        <div>
            <div class="label label-primary label-entity" sty${bookname}le="margin:3px;" id="{{ entitykey+'_newTag' }}" ng-if="(entitykey+'_new')!=editingEntity">
            <span>新增</span>
        <span class="glyphicon glyphicon-edit" aria-hidden="true" ng-click="editEntity(entitykey, 'new')" style="cursor:pointer;"></span>
        </div>
        <div class="label label-danger label-entity" style="margin:3px;" id="{{ entitykey+'_newTag' }}" ng-if="(entitykey+'_new')==editingEntity">
        <input type="text" style="color:black" value="新增" id="{{ entitykey+'_input' }}"/>
        <span class="glyphicon glyphicon-ok" aria-hidden="true" ng-click="addNewEntity(entitykey, 'new')" style="cursor:pointer;"></span>
        <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="cancelEntity(entitykey, 'new')" style="cursor:pointer;"></span>
        </div>
      </div>

    </div>
</div>
</div>	
</div>

<!-- <div class="page-header"> -->
<!--   <h4>相关阅读：<small></small></h4> -->
  
<!--   <div>中医治疗治痛风，中医对抗痛风 -->
<!--   </div> -->
  
<!--   <div>中医刚柔相济治疗抑郁 -->
<!--   </div> -->
<!-- </div> -->
</div>



        </div>

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
	$scope.directory = [];
	
	$scope.editingEntity = "";
	$scope.editingValue = ""
	$scope.path = ""
	$scope.bookname = "${bookname}"
	$scope.bookcontent = "${bookcontent}"
	document.getElementById('OriginText').innerHTML = $scope.bookcontent;
	
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
//				console.log(m)
				$scope.mm(section.content[i],arr[i].nodes,m.id)
// 				$scope.mm(section.content[i].content)
			}else{
				break
			}
// 				$scope.mm(section.content[i])
		}
	}
	$scope.data = $scope.directory	

	bookAddress = encodeURI('/book-holder/' + "${bookname}" + '.json')

	$http({
        method: 'GET',
        url: bookAddress
    }).then(function successCallback(response) {
            $scope.book = response.data;
            //console.log(response.data)
            contentArr = $scope.book
            $scope.path = 'p'
            while(contentArr.content&& contentArr.content.length>0 && contentArr.content[0].type!='paragraph'){
            	$scope.path = $scope.path + '-0'
            	contentArr = contentArr.content[0]
            }

            $scope.path = $scope.path.replace('p-','')
    		$scope.paras = contentArr.content
    		$scope.annotations = contentArr.annotation
    		$scope.translations = contentArr.translation
            $scope.summaries = contentArr.summary
    		
    		$scope.mm($scope.book,$scope.directory,'id')
			
			//retrieve entites
    		$scope.getRelations($scope.bookname, $scope.path)
    	
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
    
	$scope.expandContent = function(contentId){

//		console.log($scope.book)
		$scope.path=contentId.replace('id-','')
// 		console.log($scope.path + "$scope.path")

		arr = contentId.split('-')
		
		var curr = $scope.book.content
		var curr_name = curr
		var curr_name_title = ''
		var curr_name_num = 1
		var flag = 1
		
		
		for(i=1; i<arr.length; i++){
			if(arr[1] != 0 && i <= arr.length-2){
				curr_name_title = ''
			}
			
			if(i == arr.length-2){
 				curr_name = curr[parseInt(arr[i])].content
 				curr_name_title += curr[parseInt(arr[i])].title
 				curr_name_title += '-'
 			}

 			curr = curr[parseInt(arr[i])].content
 			
 			if(i == arr.length-1){
 				curr_name_num = arr[i]
 			}
		}
		
		if(arr.length == 2 && curr[0].type == "paragraph"){
			curr_name_title += $scope.book.content[arr[1]].title
		}
		if(arr.length >= 3 && curr[0].type == "paragraph"){
 			curr_name_title += curr_name[curr_name_num].title
		}
		
 		
 		
		if(curr[0].type!='section'){
			$scope.paras = curr
			$scope.annotations = curr.annotation
			$scope.translations = curr.translation;
        	$scope.summaries = curr.summary
            
		}
		//retrieve entites
		$scope.getRelations($scope.bookname, $scope.path)
		
		//将获取到的标题传入controller
		if(curr_name_title != ''){
			$http({
		        method: 'GET',
		        url: '/book/book_proof',
		        params: {
		        	'title': curr_name_title,
		        }
		        
		    }).then(function successCallback(response) {
		    		//console.log(response.data[0])
		    		document.getElementById('OriginText').innerHTML = response.data[0]
					
		        }, function errorCallback(response) {
		        	console.log(response+'failer')
		    });
		    
/*		    $http({
		        method: 'GET',
		        url: '/book/book_entity',
		    }).then(function successCallback(response) {
		    		console.log(response.data[0])
					
		        }, function errorCallback(response) {
		        	console.log(response+'failer')
		    });*/
	    }
	}
	
	
	$scope.getRelations = function(bookname, path){
		$http({
	        method: 'GET',
	        url: '/book-entity',
	        params: {
	        	'bookname': $scope.bookname,
	        	'path': $scope.path,
	        }
	        
	    }).then(function successCallback(response) {
	            $scope.bookentities = response.data;
//	      		console.log($scope.bookentities)
	        }, function errorCallback(response) {
	        	console.log(response)
	        	console.log('failer')
	    });
	}

	
	$scope.panelTab = function(contentId){
// 		console.log(contentId)
		if($('#'+contentId).hasClass('in')){
			$('#'+contentId).removeClass('in')
		}else{
			$('#'+contentId).addClass('in')

		}
	}
	
	
	$scope.removeEntity = function(entitykey, entityvalue){		
		div_id = entitykey+'_'+entityvalue
		$("#"+div_id).remove()
		remove(entitykey, entityvalue)
	}

	$scope.editEntity = function(entitykey, entityvalue){		
		div_id = entitykey+'_'+entityvalue
// 		$scope.editingEntity = 'book-prescription_'
		$scope.editingEntity = div_id
// 		$scope.editingValue = $('#'+div_id+'_input').val()
// 		console.log($scope.editingValue)
// 		console.log($scope.editingEntity)
// 		$('#'+div_id).replaceWith('caonima')
// 				'<input id="input_'+tagid+'_value" type="text" style="color:black" value="'+res+'" /> <div class="glyphicon glyphicon-ok" aria-hidden="true" onclick="toLabel(\''+tagid+'\')"/> <div class="glyphicon glyphicon-remove" aria-hidden="true" onclick="removeTag(\''+tagid+'\')"/> </div>')

	}

	
	$scope.finishEntity = function(entitykey, entityvalue){		
		div_id = entitykey+'_'+entityvalue
		console.log(entityvalue+" 33333333333")
		current_val = $('#'+div_id+'_input').val()
		console.log(current_val+" 444444444444")
		$scope.editingEntity = ""
		
		if(entityvalue==current_val)
			return
		for(m in $scope.bookentities.relations[entitykey]){
			if($scope.bookentities.relations[entitykey][m].relatedEntity==entityvalue){
				$scope.bookentities.relations[entitykey][m].relatedEntity = current_val
				update(entitykey, entityvalue, current_val)
				return
			}
		}
		
	}
	
	$scope.cancelEntity = function(entitykey, entityvalue){		
		div_id = entitykey+'_'+entityvalue
		$scope.editingEntity = ""
	}
	
	$scope.addNewEntity = function(entitykey, entityvalue){
		currValue = $('#'+entitykey+'_input').val()
		div_id = entitykey+'_'+entityvalue
		$scope.editingEntity = ""
		var tmp = {};
		tmp.relatedEntity = currValue
		tmp.uri = null
		for(m in $scope.bookentities.relations[entitykey]){
			if($scope.bookentities.relations[entitykey][m].relatedEntity==currValue){
				alert('"'+currValue+'"已存在！')
				return
			}
			console.log(m)
		}

		update(entitykey, '', currValue)
		$scope.bookentities.relations[entitykey].push(tmp)
	}
	
	remove = function(entitykey, entityvalue){
		$http({
	        method: 'POST',
	        url: '/book-entity-delete',
	        data: {
	        	'bookname': $scope.bookname,
	        	'path': $scope.path,
	        	'entitykey':entitykey,
	        	'entityvalue':entityvalue,
	        },
	        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	        transformRequest: function (data) {
	            return $.param(data);
	        }
	    }).then(function successCallback(response) {
	            console.log(response.data)
//	      		console.log($scope.bookentities)
	        }, function errorCallback(response) {
	        	console.log('failer')
	    });
	}
	
	update = function(entitykey, entityvalue, newvalue){
		$http({
	        method: 'POST',
	        url: '/book-entity-update',
	        data: {
	        	'bookname': $scope.bookname,
	        	'path': $scope.path,
	        	'entitykey':entitykey,
	        	'entityvalue':entityvalue,
	        	'newvalue':newvalue
	        },
	        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	        transformRequest: function (data) {
	            return $.param(data);
	        }
	    }).then(function successCallback(response) {
	            console.log(response.data)
//	      		console.log($scope.bookentities)
	        }, function errorCallback(response) {
	        	console.log('failer')
	    });
		console.log(entitykey+'\t'+entityvalue+'\t'+newvalue)
	}
});
</script>
  </body>
</html>
