<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/entity-annotation.css" rel="stylesheet">
	<link href="/info-page.css" rel="stylesheet">
</head>

<body>
<style> 
.v {border-collapse: seperate;} 
.v td{ border: none; border-bottom: dashed 1px #ddd; padding:5px;} 
</style> 
	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">

	<div class="container">
	
	<#assign nav_name = ["中医方剂", "${prescription.name}"]>
    <#assign nav_href = ["/prescription.html", "/prescription/info.html?prescriptionId=${prescription.id?c}"]>
    <#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">${prescription.name}</h1>
<!-- 			<p class="lead blog-description">The official example template of -->
<!-- 				creating a blog with Bootstrap.</p> -->
			<nav> 
				<ul class="pager">
					<!-- <li><a href="/prescription.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li> -->
				<!-- 	<li><a href="#">Next</a></li> -->
				</ul>
			</nav>  
		</div>

		<div class="row">
		
		
			<div class="col-sm-8 blog-main">
<table class="v" >
		<tr>
		<td>

		<div id="targetname" class="col-xs-16" style="color:#708090">别名：</div></td><td><div class="col-xs-16">
		<#if (prescription.alias!"") !="">${prescription.alias}
		 <#else> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</#if>
		 </div>
				
				<!-- /.blog-post --></td>
				<td> 
				
					<div class="col-xs-16" style="color:#708090">摘录：</div></td><td><div class="col-xs-16"><#if (prescription.source!"") !="">${prescription.source}<#else> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</#if></div>
			
				<!-- /.blog-post -->
				</td>
		</tr>

     </table>
<br />

<h4>相关知识链接：<small id='no-relation'></small></h4>
<div class="row" ng-app="pres" ng-controller="presCtrl" id="entityRelations">
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

<table id="showDetail">

 </table>
<br />

				<!-- <#if (prescription.alias!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">别名</h2>
					<blockquote>
						<p>${prescription.alias}</p>
					</blockquote>
				</div>
			</#if> -->

				<#if (prescription.composition!"") !="">
				<div class="blog-post" id="composition">
					<h2 class="blog-post-title">处方</h2>
					<blockquote>
						<p>${prescription.composition}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.processed!"") !="">
				<div class="blog-post" id="processed">
					<h2 class="blog-post-title">炮制</h2>
					<blockquote>
						<p>${prescription.processed}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.process!"") !="">
				<div class="blog-post" id="process">
					<h2 class="blog-post-title">制法</h2>
					<blockquote>
						<p>${prescription.process}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.pharmacologicaleffects!"") !="">
				<div class="blog-post" id="pharmacologicaleffects">
					<h2 class="blog-post-title">药理作用</h2>
					<blockquote>
						<p>${prescription.pharmacologicaleffects}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>


				<#if (prescription.function!"") !="">
				<div class="blog-post" id="function">
					<h2 class="blog-post-title">功能主治</h2>
					<blockquote>
						<p>${prescription.function}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.dosage!"") !="">
				<div class="blog-post" id="dosage">
					<h2 class="blog-post-title">用法用量</h2>
					<blockquote>
						<p>${prescription.dosage}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.remarks!"") !="">
				<div class="blog-post" id="remarks">
					<h2 class="blog-post-title">备注</h2>
					<blockquote>
						<p>${prescription.remarks}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (prescription.variousDescription!"") !="">
				<div class="blog-post" id="variousDescription">
					<h2 class="blog-post-title">各家论述</h2>
					<blockquote>
						<p>${prescription.variousDescription}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.application!"") !="">
				<div class="blog-post" id="application">
					<h2 class="blog-post-title">临床应用</h2>
					<blockquote>
						<p>${prescription.application}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.attention!"") !="">
				<div class="blog-post" id="attention">
					<h2 class="blog-post-title">注意</h2>
					<blockquote>
						<p>${prescription.attention}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<!-- <#if (prescription.source!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">摘录</h2>
					<blockquote>
						<p>${prescription.source}</p>
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

<script src="/js/angular.min.js"></script>
<script src="/js/packages/jquery-2.14-min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>


<script>
var app = angular.module('pres', []);
app.controller('presCtrl', function($scope, $http) {
	$http({
	        method: 'GET',
	        url: '/prescription-related',
	        params: {
	        	'name': '${prescription.name}',
	        }
	        
	    }).then(function successCallback(response) {
	            $scope.entities = response.data;
	      		console.log($scope.entities)
	      		if(Object.keys($scope.entities.views).length<=0){
	      			$('#entityRelations').remove()
	      			$('#no-relation').text('暂无')
	      		}
	        }, function errorCallback(response) {
	        	console.log('failer')
	    });
});
</script>

<script type="text/javascript">
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}

 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();
 
 if('${(prescription.composition)}'!=""){ showItemList.push("处方"); showItemListEn.push("composition");}

if('${prescription.processed}'!=""){ showItemList.push("炮制"); showItemListEn.push("processed");}

if(('${(prescription.process)!}') !=""){ showItemList.push("制法"); showItemListEn.push("process");}
 if('${(prescription.pharmacologicaleffects)!}'!=""){ showItemList.push("药理作用"); showItemListEn.push("pharmacologicaleffects");}
if('${(prescription.function)!}'!=""){ showItemList.push("功能主治"); showItemListEn.push("function");}
if('${(prescription.dosage)!}'!=""){ showItemList.push("用法用量"); showItemListEn.push("dosage");}
 if('${(prescription.remarks)!}'!=""){ showItemList.push("备注"); showItemListEn.push("remarks");}
if('${(prescription.variousDescription)!}'!=""){ showItemList.push("各家论述"); showItemListEn.push("variousDescription");}
if('${(prescription.application)!}'!=""){ showItemList.push("临床应用"); showItemListEn.push("application");}
 if('${(prescription.attention)!}'!=""){ showItemList.push("注意"); showItemListEn.push("attention");}

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

</script>
</body>
</html>
