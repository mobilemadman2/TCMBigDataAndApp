<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/angular-ui-tree.css" rel="stylesheet">
    <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
	<script type="text/javascript" src="/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/ui-bootstrap-tpls-2.5.0.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/angular-ui-tree.js"></script>
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
    
    <#assign nav_name = ["古籍校对"]>
    <#assign nav_href = ["/proof-home", "/proof?name=${bookname}"]>
    <#include "/common/nav-pos.ftl"/>

    
    
	<div>
    	<h1 align="center">中医古籍校对</h1>
		<div class="row" id="books" ng-app="myApp" ng-controller="myCtrl">
			<div class="panel-heading"><h3 id="_{{ book.name }}">古籍名称：<a href="/getbook?name={{book.bookName }}">{{ book.bookName }}</a></h3></div>
			<div class="panel-body">
    			<table style="font-size:16px" id="book_basic_info">
    				<tr>
		    			<td style="width:20%"><p>作者：</p></td>
		    			<!--<td id="book_author"><p>孙思邈</p></td>-->
		    			<td name="book_author"><p>{{ book.author_name?book.author_name:'未知' }}</p></td>
		    		</tr>
		    		<tr>
		    			<td><p>朝代：</p></td>
		    			<!--<td id="dynasty"><p>唐代</p></td>-->
		    			<td name="dynasty"><p>{{ book.dynasty?book.dynasty:'未知' }}</p></td>
		    		</tr>
		    		<tr>
		    			<td><p>文件大小：</p></td>
		    			<td id="book_size"><p>{{ book.book_size?book.book_size:'0' }}</p></td>
		    			<!-- <td name="book_size"><p>{{ book.book_size?book.book_size.size:'' }}</p></td> -->
		    		</tr>
		    		<tr>
		    			<td><p>最后校对时间：</p></td>
		    			<td id="proof_time"><p>{{ book.time_string?book.time_string:'未编辑' }}</p></td>
		    			<!-- <td name="proof_time"><p>{{ book.proof_time?book.proof_time.time:'未校对' }}</p></td> -->
		    		</tr>    		
		    	</table>
    		</div> <br />
    	    
    	    <!-- 编辑框的js -->
	    	<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script> 
	    	
	    	<!-- 保存按钮 -->
	    	<button id="save1" class="btn" ng-click="saveToFile()">保存</button>&nbsp;
	    	
	    	<!-- 正则表达式替换-->
	    	<div class="panel" id="replace">
			<div><strong>辅助编辑功能：</strong></div>
			<div>字符串批量替换功能（正则表达式）</div>
            <table>
                <tr>
                    <td width="240">原字符串（正则表达式）: </td>
                    <td><input id="findtxt1" type="text" class="int"/></td>
                </tr>
                <tr>
                    <td>替换新字符串: </td>
                    <td><input id="replacetxt" type="text" class="int" /></td>
                </tr>
                <tr>
                    <td>不区分大小写</var></td>
                    <td>
                        <input id="matchCase1" type="checkbox" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="repalceAllBtn" type="button" class="btn" value="全部替换" ng-click="replace_str()"/>
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
						<span id="example" style="color:red">例如：正则表达式"\\pa\d+.bmp\\r"可匹配所有类似"\pa1.bmp\r"的字符串。</span>
					</td>
				</tr>
            </table>
        </div> 
	    </div> <!-- /books -->
	</div> 
	
  
<!--  
  <div id="btns">
    <div>
        <button onclick="getAllHtml()">获得整个html的内容</button>
        <button onclick="getContent()">获得内容</button>
        <button onclick="setContent()">写入内容</button>
        <button onclick="setContent(true)">追加内容</button>
        <button onclick="getContentTxt()">获得纯文本</button>
        <button onclick="getPlainTxt()">获得带格式的纯文本</button>
        <button onclick="hasContent()">判断是否有内容</button>
        <button onclick="setFocus()">使编辑器获得焦点</button>
        <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
        <button onmousedown="setblur(event)" >编辑器失去焦点</button>

    </div>
    <div>
        <button onclick="getText()">获得当前选中的文本</button>
        <button onclick="insertHtml()">插入给定的内容</button>
        <button id="enable" onclick="setEnabled()">可以编辑</button>
        <button onclick="setDisabled()">不可编辑</button>
        <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
        <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
        <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
    </div>replace_str()

    <div>
        <button onclick="getLocalData()" >获取草稿箱内容</button>
        <button onclick="clearLocalData()" >清空草稿箱</button>
    </div>

</div>
<div>
    <button onclick="createEditor()">
    创建编辑器</button>
    <button onclick="deleteEditor()">
    删除编辑器</button>
</div>

-->

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    //var ue = UE.getEditor('editor');
    var ue = UE.getEditor('editor', {
    	//initialFrameHeight:400,//设置编辑器高度
    	scaleEnabled:true
    })
	
    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
       UE.getEditor('editor').getAllHtml()
    }

    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
    
    //my own functions
    function setEditorContent(content) {
        UE.getEditor('editor').setContent(content, false);
    }
    
    //将文本插入到编辑器中UE.getEditor('editor').getAllHtml()
    function setEditorHtml(value) {
    	ue.ready(function() {
    		UE.getEditor('editor').execCommand('insertHtml', value)
    	})
    }
    
    
 	
	//ue.addListener("ready", function () {
	//	setEditorContent("<h1>test123</h1>");
	//});
	
	
	function getFileSize(filePath) {
  		var fso = new ActiveXObject("Scripting.FileSystemObject");
  		
		//var fso = new XMLHttpRequest()
  		alert("文件大小为："+fso.GetFile(filePath).size);
	}
	
	function getFileSize2(filePath) {
  		var image=new Image();
  		image.dynsrc=filePath;
  		alert(image.fileSize);
	}
	
	//getFileSize('/book-holder/' + "${bookname}" + '.json')

	
	//修改界面设置
	
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http,$q) {
	//显示作者和朝代
	var get_info = $http({
        method: 'GET',
        url: '/proof/bp-findbook',
        params: {
        	'bookname': '${bookname}',
        	'old': ${old},
        }
    }).then(function successCallback(response) {
    		//console.log(response.data)
    		console.log("/proof/bp-findbook")
    		$scope.book = response.data
    		console.log(response.data)
    		if(response.data.length>0)
    			$("#not-found").css('display','none'); 
        }, function errorCallback(response) {
        	console.log('failer')
            // 请求失败执行代码
    });
    
	//显示图书内容及图书文件大小
	$scope.space = function(num){
		var s = ""
		for (var i = 0; i<num; i++){
			s += "&nbsp;"
		}
		return s
	}
	$scope.htmlcontent = ""
	//读取json数据，原始的文件
	$scope.readjson = function(jsonArr){
		if(angular.isArray(jsonArr)) {
			//console.log(jsonArr.length)
			for (var t=0; t<jsonArr.length; t++){
				$scope.readjson(jsonArr[t])
			}
		}
		if(jsonArr.hasOwnProperty("book_title")){
			//console.log("find tile")
			$scope.htmlcontent += '<p style="text-align:center;"><span style="font-size:20px"><strong>' + jsonArr.book_title +'</strong></span></p>'
			
			$scope.readjson(jsonArr.content)
		}
		else if(jsonArr.hasOwnProperty("type") && jsonArr.type=="section"){
			$scope.htmlcontent += '<br /><p><strong>' + jsonArr.title + '</strong></p>'
			$scope.readjson(jsonArr.content)
		}
		else if(jsonArr.hasOwnProperty("type") && jsonArr.type=="paragraph"){
			$scope.htmlcontent += '<p>' + $scope.space(7) + jsonArr.detail + '</p>'
		}
	}
	

	//访问数据
	//if(${old} == 1){
		//修改之后的文件加载
	console.log("dddd")
	//http执行完成之后再执行
	let promises = {
			get_info_key: get_info,
		}
	$q.all(promises).then((values) => {
	    //console.log(values.alpha); // value alpha
	    console.log($scope.book.content)
	    setEditorHtml($scope.book.content)
	});
	//}
	//else{
		/**
		console.log("pppppp")
		//原始文件加载
		bookAddress = encodeURI('/book-holder/' + "${bookname}" + '.json')
		$http({
	        method: 'GET',
	        url: bookAddress
	    }).then(function successCallback(response) {
	            $scope.bookjson = response.data;
	            $scope.readjson($scope.bookjson)
	            setEditorHtml($scope.htmlcontent.substr(0,10000))
	            setEditorHtml($scope.htmlcontent)
	        }, function errorCallback(response) {
	        	console.log('failer')
	            //请求失败执行代码
	    	});
		**/
	//}
	
	//保存文件
	 $scope.saveToFile = function(){
	    	console.log("点击要保存了哈")
	    	console.log(UE.getEditor('editor').getAllHtml());
	    	var data_modify = UE.getEditor('editor').getAllHtml();
	    	var data_submit ={
	    			"bookName" : $scope.book.bookName,
	    			"content" : data_modify,
	    	}
	    	console.log(data_submit);
	    	$http({
		        method: 'POST',
		        url: '/proof/save_file',
	        	data : data_submit
		    }).then(function successCallback(response) {
		            //$scope.temp = response.data;
		            console.log("save sucess")
		            console.log(response)
		            alert("保存成功！！")
		        }, function errorCallback(response) {
		        	console.log('save failer')
		            //请求失败执行代码
		    	});
		}//save file
		
		 $scope.replace_str = function(){
			 console.log($('#matchCase1').is(':checked'))
			 console.log($('#findtxt1').val())
			 console.log($('#replacetxt').val())
			if($('#findtxt1').val()!=""){
				var ddd = '以上虫类十五种dsfsdfsdfsd《水电费水电费》'
				var current_text = UE.getEditor('editor').getAllHtml()
				//cunrren_text = current_text.replace($('#findtxt1').val(),$('#replacetxt').val())
				//console.log(current_text)
				//不区分大小写
				var text = $('#findtxt1').val()
				if($('#matchCase1').is(':checked') == true){
					text = text.toLowerCase()
				}
				console.log(text)
				
				//查找符合正则表达式的个数
				var a = "aaa"
				console.log(a.search("dd"))
				var temp_text = current_text
				var index_start = 0
				var match_number = 0
				while(index_start != -1){
					index_start = temp_text.search(new RegExp(text))
					if(index_start != -1){
						match_number = match_number +1
					}
					temp_text = temp_text.replace(new RegExp(text),"")
				} 
				console.log("数量")
				console.log(match_number)
				
				//正则表达式替换
				if($('#replacetxt').val()!=""){
					current_text = current_text.replace(new RegExp(text, "g"),$('#replacetxt').val())
				}
				else{
					current_text = current_text.replace(new RegExp(text, "g"),"")
				}
				
				
				
				//ddd = ddd.replace(/《[^》]+》/g,$('#replacetxt').val())
				console.log(ddd)
				UE.getEditor('editor').setContent('') 
				setEditorHtml(current_text)
				
				alert("替换了"+match_number+"处")
			}
		}
	
	
});
</script>
   
   
    </div> <!-- /container -->
  </body>
</html>    
