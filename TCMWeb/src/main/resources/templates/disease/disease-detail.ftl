<div class="container">
    <!-- 页面当前位置导航 -->
    <#assign nav_name = ["中医疾病","${disease.name}"]>
    <#assign nav_href = ["/disease.html", "/disease/info.html?diseaseId=${disease.id?c}"]>
    <#include "/common/nav-pos.ftl"/>
    <!-- 页面当前位置导航结束 -->
    
	<div class="blog-header">
		<h1 class="blog-title">${disease.name}</h1>
	</div>
	<div class="row">
		<div class="col-sm-8 blog-main">
		<br />
		<br />
		<br />
		<table class="v" >
		<tr>
		<td>

		<div id="targetname" class="fourcharacters" style="color:#708090">中文学名：</div></td>
		<td><div class="col-xs-16"><#if (disease.nameChn!"") !="None">${disease.nameChn}
        <#else> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		 </#if></div>
				
				<!-- /.blog-post --></td>
				<td> 
					<div class="twocharacters" style="color:#708090">别名：</div></td>
					<td><div class="col-xs-16"><#if (disease.alias!"") !="None" >${disease.alias}
					<#else> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</#if></div>
				</td>
		</tr>
<!-- 		<tr>
		<td>
				<div class="col-xs-16" style="color:#708090">概述：</div></td><td><div class="col-xs-16"><#if (disease.overview!"") !="">${disease.overview}</#if></div>
				 </td>
        </tr> -->

     </table>
<br />

<h4>相关知识链接：<small id="no-relation"></small></h4>
<div class="row" ng-app="disease" ng-controller="disCtrl" id="entityRelations">
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
		
			<#if (disease.overview!"") !="None">
			<div class="blog-post" id="overview">
				<h2 class="blog-post-title">概述</h2>
				<blockquote>
					<p>${disease.overview}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			
			
			<#if bingzheng??>
			<div class="blog-post" id="id-etpa">
				<h2 class="blog-post-title">辨证论治</h2>
				<blockquote>
				<#list bingzheng as bz>
					<p class="bingzheng-name">&bull; &nbsp;${bz.name}</p>
					<#if (bz.zhenghou!"") !="None">
						<p>证候表现：<span>${bz.zhenghou}</span></p>
					</#if>
					<#if (bz.zhifa!"") !="None">
						<p>治法：<span>${bz.zhifa}</span></p>
					</#if>
					<#if (bz.zhufang!"") !="None">
						<p>主方：<span>${bz.zhufang}</span></p>
					</#if>
					<#if (bz.jiajian!"") !="None">
						<p>加减：<span>${bz.jiajian}</span></p>
					</#if>
				</#list>
				</blockquote>
				
			</div>
			<!-- /.blog-post --> </#if>
			
			
			<#if (disease.etPa!"") !="None">
			<div class="blog-post" id="etpa">
				<h2 class="blog-post-title">病因病机</h2>
				<blockquote>
					<p>${disease.etPa}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.clma!"") !="None">
			<div class="blog-post" id="clma">
				<h2 class="blog-post-title">临床表现</h2>
					<blockquote>
					<p>${disease.clma}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.examination!"") !="None">
			<div class="blog-post" id="examination">
				<h2 class="blog-post-title">实验室辅助检查</h2>
				<blockquote>
					<p>${disease.examination}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
				<#if (disease.esdi!"") !="None">
			<div class="blog-post" id="esdi">
				<h2 class="blog-post-title">诊断要点</h2>
				<blockquote>
					<p>${disease.esdi}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.didi!"") !="None">
			<div class="blog-post" id="didi">
				<h2 class="blog-post-title">鉴别诊断</h2>
				<blockquote>
					<p>${disease.didi}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
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
var app = angular.module('disease', []);
app.controller('disCtrl', function($scope, $http) {
	$http({
	        method: 'GET',
	        url: '/disease-related',
	        params: {
	        	'name': '${disease.name}',
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

	<script>
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}
</script>
	<script type="text/javascript">

 var disease_id='${disease.overview}';
 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();
 //alert(disease_id);
 if('${disease.overview}'!=""){ showItemList.push("概述"); showItemListEn.push("overview");}

if('${bingzheng?size}'){ showItemList.push("辨证论治"); showItemListEn.push("id-etpa");}

if(('${(disease.etpa)!}') !="None"){ showItemList.push("病因病机"); showItemListEn.push("etpa");}
 if('${(disease.clma)!}'!="None"){ showItemList.push("临床表现"); showItemListEn.push("clma");}
if('${(disease.examination)!}'!="None"){ showItemList.push("实验室辅助检查"); showItemListEn.push("examination");}
if('${(disease.esdi)!}'!=""){ showItemList.push("诊断要点"); showItemListEn.push("esdi");}
 if('${(disease.didi)!}'!=""){ showItemList.push("鉴别诊断"); showItemListEn.push("didi");}

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
 console.log(showItemList)
 console.log(showItemListEn)
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