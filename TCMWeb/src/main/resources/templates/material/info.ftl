<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/info-page.css" rel="stylesheet">
	<link href="/entity-annotation.css" rel="stylesheet">
</head>
<body>
<style> 
.v {border-collapse: seperate;} 
.v td{ border: none; border-bottom: dashed 1px #ddd; padding:5px;} 
</style> 
	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
	
	<div class="container">
	
	<#assign nav_name = ["中草药","${material.nameCn}"]>
    <#assign nav_href = ["/material.html", "/material/info.html?materialId=${material.id?c}"]>
    <#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">${material.nameCn}</h1>
<!-- 			<p class="lead blog-description">The official example template of -->
<!-- 				creating a blog with Bootstrap.</p> --> 
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">
				<!-- angular.js bootstrap -->
				      
      
<!--       <h3>Non-responsive grid system</h3>
<div class="row">
        <div class="col-xs-4">One third</div>
        <div class="col-xs-4">One third</div>
        <div class="col-xs-4">One third</div>
      </div>-->
		<table class="v" >
		<tr>
		<td>

		<div id="targetname" class="col-xs-16" style="color:#708090">中文学名：</div></td><td><div class="col-xs-16"><#if (material.nameCn!"") !="">${material.nameCn}

		 </#if></div>
				
				<!-- /.blog-post --></td>
				<td> 
				
					<div class="col-xs-16" style="color:#708090">英文名：</div></td><td><div class="col-xs-16"><#if (material.nameEn!"") !="">${material.nameEn} </#if></div>
			
				<!-- /.blog-post -->
				</td>
		</tr>
		
		<tr>
		<td> 
					<div class="col-xs-16" style="color:#708090"><#if (material.pinyin!"") !="">中文拼音：</div></td><td><div class="col-xs-16">${material.pinyin}</#if></div>
				
				<!-- /.blog-post --> </td>
		<td> 
					<div class="col-xs-16" style="color:#708090">别名：</div></td><td><div class="col-xs-16"><#if (material.alias!"") !="">${material.alias}</#if></div>
				
				<!-- /.blog-post --> </td>
        </tr>
        
        <tr>
		<td> 
				<div class="col-xs-16" style="color:#708090">拉丁名：</div></td><td><div class="col-xs-16"><#if (material.nameLatin!"") !="">${material.nameLatin}</#if></div>
				<!-- /.blog-post --> </td>
		<td> 
				<div class="col-xs-16" style="color:#708090">类别：</div></td><td><div class="col-xs-16"><#if (material.classification!"") !="">${material.classification}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>
        
        <tr>
        
		<td>
				<div class="col-xs-16" style="color:#708090">源形态：</div></td><td><div class="col-xs-16"><#if (material.sourceCn!"") !="">${material.sourceCn}</#if></div>
				<!-- /.blog-post --> </td>
		<td> 
				<div class="col-xs-16" style="color:#708090">源形态英文：</div></td><td><div class="col-xs-16"><#if (material.sourceEn!"") !="">${material.sourceEn}</#if></div>
<!-- /.blog-post --> </td>
        </tr>
       
        <tr>
		<td> 
				<div class="col-xs-16" style="color:#708090">源形态拉丁：</div></td><td><div class="col-xs-16"> <#if (material.sourceLatin!"") !="">${material.sourceLatin}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>
        
        
        <tr>
		<td>
				<div class="col-xs-16" style="color:#708090">源形态亚科：</div></td><td><div class="col-xs-16"><#if (material.sourceSubfamily!"") !="">${material.sourceSubfamily}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>

     </table>


<div class="row">
<!-- <div class="page-header"> -->
<!-- <h4>相关知识链接：<small></small></h4> -->
<!-- <pre><div>中医病名：<span class="badge">病名1</span><span class="badge">病名2</span><span class="badge">病名3</span></div><div>中医方剂：<span class="badge">方剂1</span><span class="badge">方剂2</span><span class="badge">方剂3</span><span class="badge">方剂4</span><span class="badge">方剂5</span></div><div>中医古籍：<span class="badge">古籍1</span><span class="badge">古籍2</span><span class="badge">古籍3</span></div><div>中医名家：<span class="badge">名家1</span><span class="badge">名家2</span></div><div>其它</div></pre>	 -->
<!-- </div> -->


<h4>相关知识链接：<small id="no-relation"></small></h4>
<div class="row" ng-app="material" ng-controller="matCtrl" id="entityRelations">
<div class="relation-block">
<div ng-repeat="(entitykey, name) in entities.views" class="label-collection">{{ name }}:
	<div ng-repeat="entity in entities.relations[entitykey]" >
	    <div class="label label-info label-entity" style="margin:3px;" 
	    id="{{ entitykey + '_' + entity.relatedEntity }}">
	    <a href="{{ entity.uri }}" target="_blank" ng-if="entity.uri!=null">{{ entity.relatedEntity }}</a>
	    <span ng-if="entity.uri==null">{{ entity.relatedEntity }}</span>
	    </div>
     </div>
</div> 
</div>
</div>

<!-- <div class="row">
<div class="page-header">
  <h4>相关阅读：<small></small></h4>
  
  <div>中医治疗治痛风，中医对抗痛风
  </div>
  
  <div>中医刚柔相济治疗抑郁
  </div>
</div>    
      -->
				
<table id="showDetail">

 </table>
		
<!-- 	<script>
function scrollToDiv1(s){
	//window.location.hash="#"+s;
	alert(s)
		//window.scrollBy(0,-90)
}
</script>
<button onclick="scrollToDiv1('描述')">Copy Text</button>
<table id="showDetail1">
<TR>
<TD><b>目录</b></TD>
<TD id="test" onClick="scrollToDiv1('描述')"><blockquote>1 描述</blockquote></TD>
</TR>
<TR>
<TD></TD>
<TD><blockquote>2 性状</blockquote></TD>
</TR>
<TR>
<TD></TD>
<TD><blockquote>3 性味</blockquote></TD>
</TR>
<TR>
<TD></TD>
<TD><blockquote>4 功效</blockquote></TD>
</TR>
<TR>
<TD></TD>
<TD><blockquote>5 地道沿革</blockquote></TD>
</TR>
<TR>
<TD></TD>
<TD><blockquote>6 采收</blockquote></TD>
</TR>


 </table>  -->
 


 


<#if (material.picture!"") !="">
				<div class="blog-post" id="图片">

					<h2 class="blog-post-title" id="picture">图片</h2>

					<blockquote>
						<p>${material.picture}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (material.description!"") !="">
				<div class="blog-post" id="描述">

					<h2 class="blog-post-title" id="description">描述</h2>

					<blockquote>
						<p>${material.description}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.attribution!"") !="">
				<div class="blog-post" id="性状">

					<h2 class="blog-post-title" id="attribution">性状</h2>


					<blockquote>
						<p>${material.attribution}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.composition!"") !="">
				<div class="blog-post" id="主要成分">

					<h2 class="blog-post-title" id="composition">主要成分</h2>


					<blockquote>
						<p>${material.composition}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.pharmacologic!"") !="">
				<div class="blog-post" id="药理作用">

					<h2 class="blog-post-title" id="pharmacologic">药理作用</h2>

					<blockquote>
						<p>${material.pharmacologic}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.taste!"") !="">
				<div class="blog-post" id="性味">

					<h2 class="blog-post-title" id="taste">性味</h2>

					<blockquote>
						<p>${material.taste}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.channel!"") !="">
				<div class="blog-post" id="归经">

					<h2 class="blog-post-title" id="channel">归经</h2>

					<blockquote>
						<p>${material.channel}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.effect!"") !="">
				<div class="blog-post" id="功效">

					<h2 class="blog-post-title" id="effect">功效</h2>

					<blockquote>
						<p>${material.effect}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.action!"") !="">
				<div class="blog-post" id="主治">

					<h2 class="blog-post-title" id="action">主治</h2>

					<blockquote>
						<p>${material.action}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.method!"") !="">
				<div class="blog-post" id="用法用量">

					<h2 class="blog-post-title" id="method">用法用量</h2>

					<blockquote>
						<p>${material.method}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.taboo!"") !="">
				<div class="blog-post" id="禁忌">

					<h2 class="blog-post-title" id="taboo">禁忌</h2>

					<blockquote>
						<p>${material.taboo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.virulence!"") !="">
				<div class="blog-post" id="毒性">

					<h2 class="blog-post-title" id="virulence">毒性</h2>

					<blockquote>
						<p>${material.virulence}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.cultivation!"") !="">
				<div class="blog-post" id="栽培要点">

					<h2 class="blog-post-title" id='cultivation'>栽培要点</h2>

					<blockquote>
						<p>${material.cultivation}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.origin!"") !="">
				<div class="blog-post" id="地道沿革">

					<h2 class="blog-post-title" id="origin">地道沿革</h2>

					<blockquote>
						<p>${material.origin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.recovery!"") !="">
				<div class="blog-post" id="采收">

					<h2 class="blog-post-title" id="recovery">采收</h2>

					<blockquote>
						<p>${material.recovery}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.process!"") !="">
				<div class="blog-post" id="炮制">

					<h2 class="blog-post-title" id="processh2">炮制</h2>

					<blockquote>
						<p id="process">${material.process}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.research!"") !="">
				<div class="blog-post" id="古籍考证">

					<h2 class="blog-post-title" id="research">古籍考证</h2>

					<blockquote>
						<p>${material.research}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.discuss!"") !="">
				<div class="blog-post" id="名家论述">

					<h2 class="blog-post-title" id="discuss">名家论述</h2>

					<blockquote>
						<p>${material.discuss}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.excerpt!"") !="">
				<div class="blog-post" id="摘录">

					<h2 class="blog-post-title" id="excerpth2">摘录</h2>

					<blockquote>
						<p id="excerpt">${material.excerpt}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
							<!-- <#if (material.link!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">链接</h2>
					<blockquote>
						<p>${material.link}</p>
					</blockquote>
				</div>
				 </#if> -->

			</div>
			<!-- /.blog-main -->

<!-- 			<div class="col-sm-3 col-sm-offset-1 blog-sidebar"> -->
<!-- 				<div class="sidebar-module sidebar-module-inset"> -->
<!-- 					<h4>About</h4> -->
<!-- 					<p> -->
<!-- 						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras -->
<!-- 						mattis consectetur purus sit amet fermentum. Aenean lacinia -->
<!-- 						bibendum nulla sed consectetur. -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<div class="sidebar-module"> -->
<!-- 					<h4>Archives</h4> -->
<!-- 					<ol class="list-unstyled"> -->
<!-- 						<li><a href="#">March 2014</a></li> -->
<!-- 						<li><a href="#">February 2014</a></li> -->
<!-- 						<li><a href="#">January 2014</a></li> -->
<!-- 						<li><a href="#">December 2013</a></li> -->
<!-- 						<li><a href="#">November 2013</a></li> -->
<!-- 						<li><a href="#">October 2013</a></li> -->
<!-- 						<li><a href="#">September 2013</a></li> -->
<!-- 						<li><a href="#">August 2013</a></li> -->
<!-- 						<li><a href="#">July 2013</a></li> -->
<!-- 						<li><a href="#">June 2013</a></li> -->
<!-- 						<li><a href="#">May 2013</a></li> -->
<!-- 						<li><a href="#">April 2013</a></li> -->
<!-- 					</ol> -->
<!-- 				</div> -->
<!-- 				<div class="sidebar-module"> -->
<!-- 					<h4>Elsewhere</h4> -->
<!-- 					<ol class="list-unstyled"> -->
<!-- 						<li><a href="#">GitHub</a></li> -->
<!-- 						<li><a href="#">Twitter</a></li> -->
<!-- 						<li><a href="#">Facebook</a></li> -->
<!-- 					</ol> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>



    <script>
var app = angular.module('material', []);
app.controller('matCtrl', function($scope, $http) {
	console.log('wlkejalsdfa')
	$http({
	        method: 'GET',
	        url: '/material-related',
	        params: {
	        	'name': '${material.nameCn}',
	        }
	        
	    }).then(function successCallback(response) {
	            $scope.entities = response.data;
// 	      		console.log($scope.entities)
	      		if(Object.keys($scope.entities.views).length<=0){
	      			$('#entityRelations').remove()
	      			$('#no-relation').text('暂无')
	      		}
	        }, function errorCallback(response) {
	        	console.log('failer')
	    });
// 	$http({
//         method: 'GET',
//         url: '/book/dynasty-order'
//     }).then(function successCallback(response) {
//     	console.log(response.data)
//             $scope.dynasties = response.data;
//     		$scope.books = $scope.dynasties
//         }, function errorCallback(response) {
//         	console.log('failer')
//             // 请求失败执行代码
//     });
	
// 	$http({
//         method: 'GET',
//         url: '/book/alphabet-order'
//     }).then(function successCallback(response) {
//     	console.log(response.data)
//             $scope.alphabets = response.data;
//         }, function errorCallback(response) {
//         	console.log('failer')
//             // 请求失败执行代码
//     });
	

	

});
</script>
	<script>
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}
</script>
	<script type="text/javascript">

 var a='${material.description}';
 var material_id='${material.id}';
 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();
 
 if('${(material.description)}'!=""){ showItemList.push("描述"); showItemListEn.push("description");}

if('${material.attribution}'!=""){ showItemList.push("性状"); showItemListEn.push("attribution");}

if(('${(material.composition)!}') !=""){ showItemList.push("主要成分"); showItemListEn.push("composition");}
 if('${(material.pharmacologic)!}'!=""){ showItemList.push("药理作用"); showItemListEn.push("pharmacologic");}
if('${(material.taste)!}'!=""){ showItemList.push("性味"); showItemListEn.push("taste");}
if('${(material.channel)!}'!=""){ showItemList.push("归经"); showItemListEn.push("channel");}
 if('${(material.effect)!}'!=""){ showItemList.push("功效"); showItemListEn.push("effect");}
if('${(material.action)!}'!=""){ showItemList.push("主治"); showItemListEn.push("action");}
if('${(material.method)!}'!=""){ showItemList.push("用法用量"); showItemListEn.push("method");}
 if('${(material.taboo)!}'!=""){ showItemList.push("禁忌"); showItemListEn.push("taboo");}
if('${(material.virulence)!}'!=""){ showItemList.push("毒性"); showItemListEn.push("virulence");}
if('${(material.cultivation)!}'!=""){ showItemList.push("栽培要点"); showItemListEn.push("cultivation");}
 if('${(material.origin)!}'!=""){ showItemList.push("地道沿革"); showItemListEn.push("origin");}
if('${(material.recovery)!}'!=""){ showItemList.push("采收"); showItemListEn.push("recovery");}
if('${(material.process)!}'!=""){ showItemList.push("炮制"); showItemListEn.push("process");}
if('${(material.research)!}'!=""){ showItemList.push("古籍考证"); showItemListEn.push("research");}
if('${(material.discuss)!}'!=""){ showItemList.push("名家论述"); showItemListEn.push("discuss");}
if('${(material.excerpt)!}'!=""){ showItemList.push("摘录"); showItemListEn.push("excerpt");}
//alert("长度："+showItemList.length)
var tmp=0;
var div1 = document.getElementById('showDetail');
 var code = '';
 var max = 3;
 var SDROW1 = '<TR><TD><h1><b>目录</b></h1></TD>';
 var SDROW2 = '<TR><TD></TD>';
 var SDROW3 = '<TR><TD></TD>';
 var SDROW4 = '<TR><TD></TD>';
 var SDROW5 = '<TR><TD></TD>';
 var SDROW6 = '<TR><TD></TD>';
 var indexList = new Array();
/* for(var k=1;k<=max;k++){
     eval("indexList.push(SDROW"+k+")");
     alert(indexList[k-1])
 }*/
 
for(var i = 0,len=showItemList.length;i<len;i++){

    //tmp++;
    index=i%max+1;
    num=i+1;

   itemtmp="<TD id=\""+showItemList[i]+"\" onclick=\"scrollToDiv(\'"+showItemListEn[i]+"\')\"><blockquote>"+num+" "+showItemList[i]+"</blockquote></TD>";

   //alert(itemtmp);
   //alert(SDROW1+=itemtmp)
   //alert(index);
    eval("SDROW"+index+"+=itemtmp");
   // console.log(eval("SDROW"+index+"+=itemtmp"))
   //alert(eval("SDROW"+index+"+=itemtmp"))
    /*if(tmp%6==0)
        code+="<TD>"+showItemList[i]+"</TD></TR><TR>";
    else
        code+="<TD>"+showItemList[i]+"</TD>";
    if(i==len-1)
        code+="</TR>";*/
}
var end="</TR>"
for(var j=1;j<=max;j++){
    eval("SDROW"+j+"+=end")
    //alert("结果："+eval("SDROW"+index))
    eval("code+=SDROW"+j)
}

  div1.innerHTML =code;
  console.log(code)
  //alert(code);


 //$("#showDetail").append(code)


 /*data = {
					"materialId":material_id,
					"pageNumber":'1',
					"pageSize":'20'
				};
 $.get("/material/info.html" ,function(data){alert(data)});
 
 alert(a.description)
 // 用来保存所有的属性名称和值
var props = "" ;
// 开始遍历
for ( var p in obj ){
// 方法
if ( typeof( obj[p]) == " function " ){
obj [ p ]() ;
} else {
// p 为属性名称，obj[p]为对应属性的值
props += p + " = " + obj[p] + " \t " ;
}
}
// 最后显示所有的属性
alert ( props ) ;
*/

//var div2 = document.getElementById('aaa');
//div2.innerHTML = '<table> asas </table>';


</script>
<!-- 



 -->
</body>

</html>
