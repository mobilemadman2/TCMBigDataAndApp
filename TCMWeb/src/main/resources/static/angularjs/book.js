/**
 * 
 */

var app = angular.module('myApp', ['ui.bootstrap','ui.tree']);

app.controller('myCtrl', function($scope, $http) {
    $scope.count = 0;
	$scope.directory = [];
	
	$scope.editingEntity = "";
	$scope.editingValue = ""
	$scope.path = ""
	$scope.bookname = "${bookname}"
	$scope.typeview = "${viewtype}"
	
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
            contentArr = $scope.book.content
            console.log(contentArr[0])
            $scope.path = '0'
            while(contentArr[0].content&& contentArr[0].content.length>0){
            	$scope.path = $scope.path + '-0'
            	contentArr = contentArr[0].content
            }
    		$scope.paras = contentArr
//     		console.log($scope.paras)
    		$scope.mm($scope.book,$scope.directory,'id')
//     		console.log($scope.book)
			
			//retrieve entites
    		$scope.getRelations($scope.bookname, $scope.path)
    	
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
	
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
		$http({
	        method: 'GET',
	        url: '/book-entity-single',
	        params: {
	        	'bookname': $scope.bookname,
	        	'path': $scope.path,
	        	'viewtype': $scope.typeview,
	        }
	        
	    }).then(function successCallback(response) {
	            $scope.bookentities = response.data;
//	      		console.log($scope.bookentities)
	        }, function errorCallback(response) {
	        	console.log('failer')
	    });
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
	        	console.log('failer')
	    });
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
		console.log(entityvalue)
		current_val = $('#'+div_id+'_input').val()
		console.log(current_val)
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