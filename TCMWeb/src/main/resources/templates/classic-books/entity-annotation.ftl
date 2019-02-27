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
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>{{ book.book_title }}</h1>
        <h3>{{ subtitle }}</h3>
 	</div>

<!-- 正文 -->
<div class="row">
<div class="col-lg-12">
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
	<!-- 设置了相同的data parent会关闭其它的 -->
	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="originHeading">
	      <h4 class="panel-title">原文</h4>
	    </div>
	    <div id="collapseOriginHeading" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseOriginHeading">
	      <div class="panel-body book-origin">
	        <div ng-repeat="para in paras">
	          <h4>{{ para.detail }}</h4>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
</div>
</div>


	<div class="row">
<div class="col-lg-6">
<!-- <h4>自动实体识别：<a class="btn btn-default" href="/relation/interactive?entitykey={{ entitykey }}&book={{ bookname }}&path={{ path }}" role="button">开始识别</a></h4> -->
<h4>自动实体识别:</h4>
<div ng-repeat="(entitykey, name) in autobookentities.views">
	<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">{{ name }}:</h4>
	</div>
	<div class="panel-body">
	<div ng-repeat="entity in autobookentities.relations[entitykey]" >
<!--   ng-class={undefined:'label label-primary', true:'label label-danger'}[entity.addFlag] -->
    <div ng-class="entity.addFlag==true?'label label-default label-entity':'label label-info label-entity'" style="margin:3px;" 
    id="{{ 'auto_' + entitykey + '_' + entity.relatedEntity }}" >{{ entity.relatedEntity }}
    <span class="glyphicon glyphicon-plus" aria-hidden="true" ng-click="addToLabeledEntity(entitykey, entity)" style="cursor:pointer;"></span>
<!--    <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="removeEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span> -->
    </div>
    
<!--<div class="label label-danger" style="margin:3px;"  -->
<!--    id="auto_{{ entitykey }}_{{entity.relatedEntity}}" ng-if="(entitykey+'_'+entity.relatedEntity)==editingEntity"> -->
<!--    <input type="text" style="color:black" id="auto_{{ entitykey }}_{{entity.relatedEntity}}_input" value="{{ entity.relatedEntity }}" /> -->
<!--     <span class="glyphicon glyphicon-ok" aria-hidden="true" ng-click="finishEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span> -->
<!--    <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="cancelEntity(entitykey, entity.relatedEntity)" style="cursor:pointer;"></span> -->
<!--    </div> -->
    </div></div>
	</div>

</div>
</div>

<div class="col-lg-6">
<div class="row">
<h4>已标注实体：</h4>
  <div ng-repeat="(entitykey, name) in bookentities.views">
  <div class="panel panel-default">
  <div class="panel-heading">
	<h4 class="panel-title">{{ name }}</h4>
  </div>
  <div class="panel-body">
  <div ng-repeat="entity in bookentities.relations[entitykey]" >
    <div class="label label-info label-entity" style="margin:3px;" 
    id="{{ entitykey + '_' + entity.relatedEntity }}" ng-if="(entitykey+'_'+entity.relatedEntity)!=editingEntity">{{ entity.relatedEntity }}
    <span class="glyphicon glyphicon-edit" aria-hidden="true" ng-click="editEntity(entitykey, entity)" style="cursor:pointer;"></span>
    <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="removeEntity(entitykey, entity)" style="cursor:pointer;"></span>
    </div>
    
      <div class="label label-danger label-entity" style="margin:3px;" 
    id="{{ entitykey }}_{{entity.relatedEntity}}" ng-if="(entitykey+'_'+entity.relatedEntity)==editingEntity">
    <input type="text" style="color:black" id="{{ entitykey }}_{{entity.relatedEntity}}_input" value="{{ entity.relatedEntity }}" />
    <span class="glyphicon glyphicon-ok" aria-hidden="true" ng-click="finishEntity(entitykey, entity)" style="cursor:pointer;"></span>
    <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="cancelEntity(entitykey, entitykey)" style="cursor:pointer;"></span>
    </div>
    </div>
    
    <!-- 新添加实体标签 -->
    <div>
        <div class="label label-primary label-entity" style="margin:3px;" id="{{ entitykey+'_newTag' }}" ng-if="(entitykey+'_new')!=editingEntity">新增
    <span class="glyphicon glyphicon-edit" aria-hidden="true" ng-click="editEntity(entitykey, 'new')" style="cursor:pointer;"></span>
    </div>
    <div class="label label-danger" style="margin:3px;" id="{{ entitykey+'_newTag' }}" ng-if="(entitykey+'_new')==editingEntity">
    <input type="text" style="color:black" value="新增" id="{{ entitykey+'_input' }}"/>
    <span class="glyphicon glyphicon-ok" aria-hidden="true" ng-click="addNewEntity(entitykey, 'new')" style="cursor:pointer;"></span>
    <span class="glyphicon glyphicon-remove" aria-hidden="true" ng-click="cancelEntity(entitykey, 'new')" style="cursor:pointer;"></span>
    </div>
    </div>
  </div>
</div>
  </div>
  </div>

<div class="row" style="float:right;"><a class="btn btn-default" href="javascript:void(0);" ng-click="entitiesSave()" role="button">保存</a></div>
</div>

</div><!-- /.row -->
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

app.controller('myCtrl', function($scope, $http, $q) {
    $scope.count = 0;
	$scope.directory = [];
	
	$scope.editingEntity = "";
	$scope.editingValue = ""
	$scope.path = "${path}"
	$scope.bookname = "${bookname}"
	$scope.typeview = "${viewtype}"
	
	$scope.data = $scope.directory	
// 	console.log($scope.directory)

	bookAddress = encodeURI('/book-holder/' + "${bookname}" + '.json')
// 	console.log(bookAddress)
// 	console.log(decodeURI(bookAddress))
	$http({
        method: 'GET',
        url: bookAddress
    }).then(function successCallback(response) {
//     	console.log(response.data)
            $scope.book = response.data;
            contentArr = $scope.book
//             console.log($scope.path)
            caddress = $scope.path.split('-')
            for(m=0;m<caddress.length;m++){
//             	console.log(m+"\t"+caddress[m])
            	contentArr = contentArr.content[caddress[m]]
            }
//             console.log(contentArr)
           
    		$scope.paras = contentArr.content
    		$scope.subtitle = contentArr.title;
    		$scope.getSingleRelations($scope.bookname, $scope.path)
    	
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	$scope.entitiesSave = function(){
		$http({
	        method: 'POST',
	        url: '/book-entity-save',
	        data: {
	        	'bookname': $scope.bookname,
	        	'path': $scope.path,
	        	'entities':JSON.stringify($scope.bookentities.relations),
	        },
	        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	        transformRequest: function (data) {
	            return $.param(data);
	        }
	    }).then(function successCallback(response) {
	            console.log(response.data)
//	      		console.log($scope.bookentities)
	        }, function errorCallback(response) {
	        	console.log(response)
	        	console.log('failer')
	    });
	}
	$scope.expandContent = function(contentId){
		$scope.path=contentId
		console.log(contentId)
		arr = contentId.split('-')
		var curr = $scope.book.content
		for(i=1; i<arr.length; i++){
// 			console.log(arr[i])
 			curr = curr[parseInt(arr[i])].content
		}
// 		console.log(curr)
		if(curr[0].type!='section'){
			$scope.paras = curr
		}
		//retrieve entites
		$scope.getRelations($scope.bookname, $scope.path)
	}
	
	$scope.getSingleRelations = function(bookname, path){
		//获取已生成实例
		$q.all({
			first:$http({
		        method: 'GET',
		        url: '/book-entity-single',
		        params: {
		        	'bookname': $scope.bookname,
		        	'path': $scope.path,
		        	'viewtype': $scope.typeview,
		        }
		        
		    }).then(function successCallback(response) {
		            $scope.bookentities = response.data;
//		      		console.log($scope.bookentities)
		        }, function errorCallback(response) {
		        	console.log('failer')
		    }),
			second:$http({//获取自动生成实例
		        method: 'GET',
		        url: '/auto-book-entity-single',
		        params: {
		        	'bookname': $scope.bookname,
		        	'path': $scope.path,
		        	'viewtype': $scope.typeview,
		        }
		    }).then(function successCallback(response) {
		            $scope.autobookentities = response.data;
		        }, function errorCallback(response) {
		        	console.log('failer')
		    }),
		}).then(function(arr){
			//显示属性加工
			for(var prop in $scope.bookentities.relations){
				tmp = $scope.bookentities.relations[prop]
				console.log(tmp)
				autotmp = $scope.autobookentities.relations[prop]
				for(var i=0;i<tmp.length;i++){
					for(var j=0;j<autotmp.length;j++){
// 						console.log(tmp[i].relatedEntity+'\t'+autotmp[j].relatedEntity)
						if(tmp[i].relatedEntity==autotmp[j].relatedEntity){
							$scope.autobookentities.relations[prop][j].addFlag = true
							break;
						}
					}
				}
			}
//             console.log($scope.bookentities)
//             console.log($scope.autobookentities)
		})
	}

	
	$scope.removeEntity = function(entitykey, entity){
		entityvalue = entity.relatedEntity;
		div_id = entitykey+'_'+entityvalue
		$("#"+div_id).remove()
		remove(entitykey, entityvalue)
// 		console.log($scope.bookentities.relations[entitykey])
// 		console.log(entity)
// 		console.log($scope.bookentities.relations[entitykey])
		removeFromEntities($scope.bookentities.relations[entitykey],entity)
		removeFromAutoEntities($scope.autobookentities.relations[entitykey],entity)
		
	}
	
	function removeFromEntities(entitySet,entity){
		for(i in entitySet){
			if(entitySet[i].relatedEntity==entity.relatedEntity){
				entitySet.splice(i,1)
				return
			}
		}
	}
	
	function removeFromAutoEntities(entitySet,entity){
		//将addFlag重置为false
		for(i in entitySet){
			if(entitySet[i].relatedEntity==entity.relatedEntity){
				entitySet[i].addFlag = false
				return
			}
		}
	}

	$scope.editEntity = function(entitykey, entity){
		entityvalue = ''
		if(entity=='new') entityvalue = 'new'
		else entityvalue = entity.relatedEntity;
		div_id = entitykey+'_'+entityvalue
// 		$scope.editingEntity = 'book-prescription_'
		$scope.editingEntity = div_id
// 		$scope.editingValue = $('#'+div_id+'_input').val()
// 		console.log($scope.editingValue)
// 		console.log($scope.editingEntity)
// 		$('#'+div_id).replaceWith('caonima')
// 				'<input id="input_'+tagid+'_value" type="text" style="color:black" value="'+res+'" /> <div class="glyphicon glyphicon-ok" aria-hidden="true" onclick="toLabel(\''+tagid+'\')"/> <div class="glyphicon glyphicon-remove" aria-hidden="true" onclick="removeTag(\''+tagid+'\')"/> </div>')

	}

	
	$scope.finishEntity = function(entitykey, entity){
		entityvalue = entity.relatedEntity;
		div_id = entitykey+'_'+entityvalue
		console.log(entityvalue)
		current_val = $('#'+div_id+'_input').val()
		console.log(current_val)
		$scope.editingEntity = ""
		
		if(entityvalue==current_val)
			return
		for(m in $scope.bookentities.relations[entitykey]){
			if($scope.bookentities.relations[entitykey][m].relatedEntity==entityvalue){
				removeFromAutoEntities($scope.autobookentities.relations[entitykey],entity)
				$scope.bookentities.relations[entitykey][m].relatedEntity = current_val
 				ModifyAutoEntitiesFlag($scope.autobookentities.relations[entitykey],entity)
				
				update(entitykey, entityvalue, current_val)
				return
			}
		}
		
	}
	
	function ModifyAutoEntitiesFlag(entitySet,entity){
		//将addFlag重置为false
		for(i in entitySet){
			if(entitySet[i].relatedEntity==entity.relatedEntity){
				entitySet[i].addFlag = true
			}
		}
	}
	$scope.cancelEntity = function(entitykey, entity){
		entityvalue = entity.relatedEntity;
		if(entitykey==entityvalue) return
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
// 			console.log(m)
		}

		update(entitykey, '', currValue)
		$scope.bookentities.relations[entitykey].push(tmp)
 		ModifyAutoEntitiesFlag($scope.autobookentities.relations[entitykey],tmp)
	}
	
	$scope.addToLabeledEntity = function(entitykey,entity){
		currValue = entity.relatedEntity
		div_id = entitykey+'_'+currValue
		$scope.editingEntity = ""
		var tmp = {};
		tmp.relatedEntity = currValue
		tmp.uri = null
		//auto表示该结果为自动识别
		tmp.auto = true
		
		for(m in $scope.bookentities.relations[entitykey]){
			if($scope.bookentities.relations[entitykey][m].relatedEntity==currValue){
				alert('"'+currValue+'"已存在！')
				return
			}
			console.log(m)
		}

// 		update(entitykey, '', currValue)
		$scope.bookentities.relations[entitykey].push(tmp)
		
		//addFlag表示是否已添加到标注实体中
		entity.addFlag = true;
// 		$scope.autobookentities.relations[entitykey]
// 		console.log($scope.autobookentities.relations[entitykey])
	}
	remove = function(entitykey, entityvalue){
		return
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
		return
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
