<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "/common/common-head.ftl" />
    	<link rel="stylesheet" href="/acupoint/acupoint_detail.css">
    	<link href="/book.css" rel="stylesheet">
    	

  	<body>
  		<#include "/common/nav.ftl" />
    	<div class="container">
	    	<#assign nav_name = ["人体穴位","${acupointName}"]>
	    	<#assign nav_href = ["/acupoint.html", "/acupoint/detail_picture?acupoint_name=${acupointName}"]>
	   		<#include "/common/nav-pos.ftl"/>
          	<!-- Main component for a primary marketing message or call to action -->
      		<div class="jumbotron">
        	<p>${acupointName}</p>
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
			
			<div style="TEXT-ALIGN: center;">
					<p style="color:red;">提示: 鼠标点击穴位,显示详细信息</p>
			</div>
				
      		<div id="hor_box"  ng-app="myApp" ng-controller="myCtrl">
      			<!-- show simple acupoint -->
      			<div class="col-xs-2">
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
				          					<li class="list-group-item" ng-repeat="obj in acup_name_lists(obj)"><a href="/acupoint/detail_picture?acupoint_name={{ obj }}" id="target_{{ obj }}" ng-click="scrollToDiv($event)" >{{ obj}}({{get_acponit_numbers(obj)}})</a></li>
				          				</ul>
			          				</li>
			        			</ul>
			      			</div>	
			    		</div>
		  			</div>
	  			</div>
      			<!-- show picture -->
	      		<div id="acu_image_pos">
					<img id="acupoint_pic" src="{{pic_path}}" usemap="#Map">
					<map name="Map">
	  					<area style="outline:none" ng-repeat="(id,position_acu) in id_pos track by $index" shape="rect" coords="{{position_acu}}"  href="#" ng-mouseover="showpic(id)" ng-mousedown="showDetail(id)" ng-mouseleave="" ng-mouseup="scrollToDiv()">
					</map>
					<div style="width:490px;">
						<dl id="classification_info">
							<dt>*经脉循行</dt>
							<dd>{{jingmaixunxing}}</dd> <br>
							<dt>*主要病候</dt>
							<dd>{{zhuyaobinghou}}</dd><br>
							<dt>*主治概要</dt>
							<dd>{{zhuzhigaiyao}}</dd><br>
						</dl>
					</div>
				</div>
				<!--show detail acupoint  -->
				<div id="acupoint_text" style="display:none;">
					<!-- 设置一下详细的显示界面的哈 -->
					<dl id="table_info">
					<dt  style="font-size:20px;text-align:center"><u>{{acupointName}}</u></dt> <br>
					<dt>*拼音</dt>
					<dd>{{main_pinyin}}</dd> <br>
					<dt>*所属穴位</dt>
					<dd>{{main_suoshujingluofenleimingcheng}}</dd><br>
					<dt>*人体定位</dt>
					<dd>{{main_info}}</dd><br>
					<dt>*配伍</dt>
					<dd>{{main_peiwu}}</dd><br>
					<dt>*主治</dt>
					<dd>{{main_zhuzhi}}</dd><br>
					<dt>*刺灸法</dt>
					<dd>{{main_cijiufa}}</dd><br>
					<dt>*解剖</dt>
					<dd>{{main_jiepou}}</dd><br>
					<dt>*辅助</dt>
					<dd>{{main_fuzhu}}</dd><br>
					</dl>
				</div>
    		</div> 
    	</div>

	    <script src="/js/angular.min.js"></script>
	    <script src="/js/packages/jquery-2.14-min.js"></script> 
	 	<script src="/bootstrap/js/bootstrap.min.js"></script>
	 	
		<script>
		
		 var app = angular.module('myApp', []);
			app.controller('myCtrl', function($scope,$http,$q) {
				//获取图片路径
				
				
				//获取
					var url_pic = '/acupoint/pic_path?acupoint_name='+'${acupointName}'
					console.log(url_pic)
					//初始化
					var acupoint_detail_inf = $http({
				        method: 'GET',
				        url: url_pic
				    }).then(function successCallback(response) { 
				    		//get detail information about acupoint,eg pingyin
				    		$scope.pic_path = response.data[0].rentishiyitu;
				    		$scope.jingmaixunxing = response.data[0].jingmaixunxing;
				    		$scope.zhuyaobinghou = response.data[0].zhuyaobinghou;
				    		$scope.zhuzhigaiyao = response.data[0].zhuzhigaiyao;
				    		console.log(response.data[0].zhuyaogaiyao)
				    		console.log("zhixing1")
				        }, function errorCallback(response) {
				        	console.log('picture path failer')
				            // 请求失败执行代码
				    });
				
				
					
					
					
				
				//获取图片位置的标注信息
					var url_position = '/acupoint/pic_postion?acupoint_name='+'${acupointName}'
					console.log(url_position)
					//初始化
					var pic_position = $http({
				        method: 'GET',
				        url: url_position
				    }).then(function successCallback(response) { 
				    		//get detail information about acupoint,eg pingyin
				    		var data = response.data;
				    		$scope.id_name = new Array();
				    		$scope.id_pos = new　Array();
				    		var name_numbers = 0;
				    		for (var i=0;i<data.length;i++)
				    		{
				    			$scope.id_name[i] = data[i].acupointName;
				    			var position = data[i].position;
				    			$scope.id_pos[i] = position;
				    			console.log(position)
				    			name_numbers = name_numbers +1;
				    		}
				    		$scope.name_numbers = name_numbers;
				    		$scope.acupointName=$scope.id_name[0]
				    		console.log("dsfsdfsf")
				    		console.log($scope.id_name)
				    		console.log("zhixing2")
				        }, function errorCallback(response) {
				        	console.log('picture position failer')
				            // 请求失败执行代码
				    });
					
					
					
					//获取具体每个穴位的数量
					var numbers_acupoint = $http({
				        method: 'GET',
				        url: '/acupoint/show_classes_numbers'
				    }).then(function successCallback(response) { 
				    		$scope.acupoint_numbers = response.data;
				            console.log(response.data)
				            console.log("zhixing3")
				        }, function errorCallback(response) {
				        	console.log('get count failer')
				            // 请求失败执行代码
				    });
					
					
					 //获取左边栏的列表的详细信息
				    var left_detail = $http({
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
				    		//$scope.acupoints_small_classicify = response.data;
				            //$scope.acupoints_fourteen= response.data["十四经经穴图"];
				            //console.log($scope.acupoints_small_classicify)
				            //console.log($scope.acupoints_big_classicify)
				            $scope.temp = response.data
				            console.log(response.data)
				            console.log("zhixing4")
				        }, function errorCallback(response) {
				        	console.log('failer')
				            // 请求失败执行代码
				    });
					
					
					
					
					
					
					
					
					
				//获取当前坐标
				 function getCursortPosition(element) {
			            var CaretPos = 0;
			            if (document.selection) {//支持IE
			                element.focus();
			                var Sel = document.selection.createRange();
			                Sel.moveStart('character', -element.value.length);
			                CaretPos = Sel.text.length;
			            }
			            else if (element.selectionStart || element.selectionStart == '0')//支持firefox
			                CaretPos = element.selectionStart;
			            return (CaretPos);
			        }
				
				
				console.log("start")
				
				//鼠标悬浮之后的方法,mouse_over
				$scope.showpic = function(id) {
					/* var oldpic = 0
					console.log(id)
			        oldpic = document.getElementById("simple_text");
			        oldpic.style.display="inline";
			        $scope.pic_name = $scope.id_name[id];
			        console.log('display and show is finished!');
			        $scope.main_info = "";
		    		$scope.main_pinyin = "";
		    		$scope.main_jiepou = ""; */
			    };
			    
			    //鼠标离开的效果
			    $scope.removeContent = function(id) {
			    	$scope.pic_name = "";
			    };
			    
			    
			    //鼠标离开的时候,保持鼠标的位置不变,现会出现鼠标飘逸的情况
			    $scope.keepPosition = function(id) {
			    	$scope.pic_name = "";
			    	
			    };
			    
			    
							    
			    
	
		    
			  //添加大穴位数量
			   $scope.acup_numbers = function(element) {
				  //console.log("acupoint numbers");
				 // console.log(element);
				  return $scope.temp[element].length;
			    };
			    
			    $scope.acup_name_lists = function(element) {
					  //console.log("acup_name_lists");
					 // console.log(element);
					  return $scope.temp[element];
				  };
	
				//获取手太阴肺经中的小穴位数量
				$scope.get_acponit_numbers = function(element){
					//console.log("getting counts now");
					if(!element in $scope.acupoint_numbers){
						return 0;
					}
					return $scope.acupoint_numbers[element];
				}
			    
			    $scope.scrollToDiv = function(){
			    	console.log("滑动了哈")
					window.scrollTo(0,900)
			}
			    
			  //判断是否是从查询界面来的
				$scope.is_from_search = function(){
					console.log('${detail_acupoint_name}');
					var acupoint_name = '${detail_acupoint_name}';
					if(acupoint_name.length != 0){
						console.log("ddddddd");
						console.log($scope.name_numbers);
						var id = -1;
						console.log($scope.id_name);
						for(var i = 0;i<$scope.name_numbers;i++){
							
							if(acupoint_name == $scope.id_name[i]){
								id = i;
							}
						}
						
						$scope.showDetail(id);
					}
					else{
						console.log("uuuuuu");
					}
				}
			  
			  
			  //http执行完成之后再执行
				let promises = {
						numbers_acupoint_key: numbers_acupoint,
						left_detail_key: left_detail,
						pic_position_key: pic_position,
						acupoint_detail_inf_key: acupoint_detail_inf
					}
				$q.all(promises).then((values) => {
				    //console.log(values.alpha); // value alpha
				    $scope.is_from_search();
				});
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
				//点击鼠标的效果
			    $scope.showDetail = function(id){
			    	var oldpic = 0
					console.log(id)
					console.log(typeof(id));
					console.log("获取屏幕坐标")
					console.log(document.body.clientHeight)
					console.log(window.screenTop)
					console.log(document.body.scrollWidth)
			        /* oldpic = document.getElementsByTagName("textarea");
			    	for(var i=0;i<oldpic.length;i++){
			    		oldpic[i].style.display="block";
			    	} */
			    	
			    	var oldpic = document.getElementById("acupoint_text");
			        oldpic.style.display="inline-block";
			        
			        var acupointName = $scope.id_name[id];
			        console.log(acupointName);
			    	$scope.acupointName = acupointName;
			      	console.log(acupointName)
					var url_detail = '/acupoint/info_detail?acupoint_name='+acupointName;
					console.log(url_detail);
					
					//获取某个小穴位的详细信息
					var small_information = $http({
				        method: 'GET',
				        url: url_detail
				    }).then(function successCallback(response) { 
				    		//this get the detail information from database;
				    		var data = response.data;
				    		console.log(response.data);
				    		$scope.main_info = "";
				    		$scope.main_pinyin = "";
				    		$scope.main_jiepou = "";
				    		if ("rentidingwei" in data[0]){
				    			$scope.main_info = data[0].rentidingwei;
				    		}
				    		if ("pinyin" in data[0]){
				    			$scope.main_pinyin = data[0].pinyin;
				    		}
				    		if ("jiepou" in data[0]){
				    			$scope.main_jiepou = data[0].jiepou;
				    		}
				    		if("suoshujingluofenleimingcheng" in data[0]){
				    			$scope.main_suoshujingluofenleimingcheng=data[0].suoshujingluofenleimingcheng;
				    		}
				    		if("peiwu" in data[0]){
				    			$scope.main_peiwu=data[0].peiwu;
				    		}
				    		if("zhuzhi" in data[0]){
				    			$scope.main_zhuzhi=data[0].zhuzhi;
				    		}
				    		if("cijiufa" in data[0]){
				    			$scope.main_cijiufa = data[0].cijiufa;
				    		}
				    		if("fuzhu" in data[0]){
				    			$scope.main_fuzhu = data[0].fuzhu;
				    		}
				    		console.log(data);
				    		
				    		console.log("滑动了哈")
							window.scrollTo(0,100)
				        }, function errorCallback(response) {
				        	console.log('failer')
				            // 请求失败执行代码
				    });
			        console.log('display and show is finished!');
			    }
			    
			});
			
			
			
			
			
			
		</script>
	</body>
</html>
