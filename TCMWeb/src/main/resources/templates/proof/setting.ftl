<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/proof/book-proof-main.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["中医古籍管理"]>
    <#assign nav_href = ["/proof-home"]>
    <#include "/common/nav-pos.ftl"/>
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医古籍管理</h1>  
        <!-- 标题栏注释掉 -->
        <!--  
         <nav class="menu">
            <a href="/tcm/">首页</a> | <a href="/tcm/book_list">古籍列表</a> | <a href="/tcm/book_proof">古籍校对</a> | <a href="/tcm/book_entity">古籍实体抽取</a> | <a href="/tcm/book_entity_panel">实体统计</a> | <a href="/tcm/proof_setting">设置</a> | <a href="/tcm/about_us">关于我们</a>  
         </nav>
         -->
 	</div>
 	<div class="row" id="books" ng-app="myApp" ng-controller="myCtrl">
		
	<div class="col-xs-3">
	 	<div class="panel panel-default">
	      <div class="panel-heading" role="tab" id="bookListGroupHeading2">
	        <h4 class="panel-title">
	          <a ng-click="alphabetOrder()" class="collapsed" role="button" data-toggle="collapse" href="#bookListGroup2" aria-expanded="true" aria-controls="bookListGroup2">
	            古籍管理
	          </a>
	        </h4>
	      </div>
	      <div id="bookListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="bookListGroupHeading2">
	      	<div style="width:40px; height:40px;margin: 0 auto;">
	        	<a href="#"><font size="3px">设置</font></a>
        	</div>
	      </div>
	    </div>
	    <!-- panel panel-default -->
 	 </div>
 	 <!-- col-xs-3 -->
 	
 	
 	
 
    <div class="col-xs-9">
     	<div class="panel2" id="replace2">
			<div><strong>古籍辅助校对功能设置：</strong></div>
			<div>设置全局替换规则：</div>
			<form id="reg_replace_rule" action="/proof/save-rule" method="get">
            <table>
                <tr>
                    <td width="240" valign="top">输入要替换的字符（支持正则表达式）: </td>
                    <td><textarea rows="5" cols="50" id="reg_rules_str" name="reg_rules_str">{{ rules.rules }}</textarea></td>
                </tr>
                <tr>
                    <td>不区分大小写</var></td>
                    <td>
                        <input name="chk_box" id="matchCase2" type="checkbox" />
                        
                    </td>
                </tr>
                <tr>
                    <td width="240">
                        <input id="reSaveRefreshBtn"  type="submit" class="btn" value="保存并刷新页面"/>
	                </td>
	                <td >
	                    <p id="sure_text" style="color:red"> 保存成功</p>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;               
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <span id="replace-msg" style="color:red"></span>
                    </td>
                </tr>
				<tr>
					<td colspan="2">
						<span id="example" style="color:red">
							<p>注意：1. 请勿删除输入框中内容；2.请添加新替换的字符或字符串，并请用“;”隔开；3.正则表达式请写在“//”之内；4.默认去掉替换字符，如需指定替换后的字符，请使用=>分割；</p>
							<p>例如：KT; HT; □; ○; ■; \r; /p05-c16a1.bmp/=>" "</p>
						</span>
					</td>
				</tr>
            </table>
			</form>
        </div>  
   	</div>
    <!-- col-xs-9 -->
    
    
    </div>
    <!-- /container -->
    
    </div>
   
    <!-- Bootstrap core JavaScript
    ================================================== -->
   
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/packages/require.js" data-main="/js/book-proof"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/tm.pagination.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
     <script>  
     
    $('textarea').on('propertychange input', function(event) {
		//console.log($(this).val())
		if(!$("#sure_text").is(":hidden")){
			$("#sure_text").hide()
		}
    });
    console.log(${update})
    console.log("adc")
    if(${update} == 1){
    	$("#sure_text").show()
    }else{
    	$("#sure_text").hide()
    }
    var app = angular.module('myApp', []);
    
	app.controller('myCtrl', function($scope, $http) {
	$http({
        method: 'GET',
        url: '/proof/get_rules'
    }).then(function successCallback(response) {
    		console.log("sdfsdfsdfs")
    		console.log(response.data)
            $scope.rules = response.data;
    		console.log($scope.rules)
   		}, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
	
	
	$scope.dynastyOrder = function(){
		console.log('dynastiesOrder')
		$scope.books = $scope.dynasties
	}
	
	$scope.alphabetOrder = function(){
		console.log('alphabetOrder')
		$scope.books = $scope.alphabets
	}
	
	$scope.scrollToDiv = function(event){
		console.log(event.target.id)
		target_div = event.target.id.replace('target_','')
		console.log(event.target.parentNode.parentNode.parentNode.id)
		
		if(event.target.parentNode.parentNode.parentNode.id=='bookListGroup1'){
			$scope.books = $scope.dynasties
		}else{
			$scope.books = $scope.alphabets			
		}
		window.location.hash="#_"+target_div
		window.scrollBy(0,-90)
		return false
	}
});
    </script>
    
   
  </body>
</html>
