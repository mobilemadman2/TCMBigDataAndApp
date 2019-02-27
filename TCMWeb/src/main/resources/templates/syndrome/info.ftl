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
	
	<#assign nav_name = ["中医证候","${syndrome.name}"]>
    <#assign nav_href = ["/syndrome.html", "/syndrome/info.html?syndromeId=${syndrome.id?c}"]>
    <#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">${syndrome.name}</h1>
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

		<div id="targetname" class="col-xs-16" style="color:#708090">病证名称：</div></td><td><div class="col-xs-16"><#if (syndrome.name!"") !="">${syndrome.name}

		 </#if></div>
				
				<!-- /.blog-post --></td>
				<td> 
				
					<div class="col-xs-16" style="color:#708090">证名编号：</div></td><td><div class="col-xs-16"><#if (syndrome.standard_num!"") !="">${syndrome.standard_num} </#if></div>
			
				<!-- /.blog-post -->
				</td>
		</tr>
		
		<tr>
		<td> 
					<div class="col-xs-16" style="color:#708090">英文名称：</div></td><td><div class="col-xs-16"><#if (syndrome.name_en!"") !="">${syndrome.name_en} </#if></div>
				
				<!-- /.blog-post --> </td>
		<td> 
					<div class="col-xs-16" style="color:#708090">一级分类：</div></td><td><div class="col-xs-16"><#if (syndrome.level1_name!"") !="">${syndrome.level1_name}</#if></div>
				
				<!-- /.blog-post --> </td>
        </tr>
        
        <tr>
		<td> 
				<div class="col-xs-16" style="color:#708090">二级分类：</div></td><td><div class="col-xs-16"><#if (syndrome.level2_name!"") !="">${syndrome.level2_name}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>

     </table>
 

<table id="showDetail">

 </table>			
				
			<#if (syndrome.general_description!"") !="">
				<div class="blog-post" id="general_description">
					<h2 class="blog-post-title">概述</h2>
					<blockquote>
						<p>${syndrome.general_description}</p>
					</blockquote>
				</div></#if>
				<!-- /.blog-post --> 
				<!--  <#if (syndrome.general_description!"") !="">
				<div class="blog-post" id="general_description">
					<h2 class="blog-post-title">临床表现</h2>
					<blockquote>
						<p>${syndrome.general_description}</p>
					</blockquote>
				</div></#if>-->
				<!-- /.blog-post --> 
				<#if syndromeTreatment ??>
				<div class="blog-post" id="disease_name">
				<h2 class="blog-post-title">常见疾病</h2>
				<div class="blog-post" id="disease_name" style="height:400px;overflow:scroll;">
				<blockquote>
				<#list syndromeTreatment as s>
					<p class="bingzheng-name">&bull; &nbsp;${s.disease_name}</p>
					<#if (s.zhenghou!"") !="None">
						<p>证候表现：<span>${s.zhenghou}</span></p>
					</#if>
					<#if (s.zhifa!"") !="None">
						<p>治法：<span>${s.zhifa}</span></p>
					</#if>
					<#if (s.zhufang!"") !="None">
						<p>主方：<span>${s.zhufang}</span></p>
					</#if>
					<#if (s.jiajian!"") !="None">
						<p>加减：<span>${s.jiajian}</span></p>
					</#if>
				</#list>
				</blockquote>
				</div>
			</div>
				<!-- /.blog-post --> </#if>
				<!--  <#if (syndrome.general_description!"") !="">
				<div class="blog-post" id="general_description">
					<h2 class="blog-post-title">本证辨析</h2>
					<blockquote>
						<p>${syndrome.general_description}</p>
					</blockquote>
				</div></#if>-->
				<!-- /.blog-post --> 
				<!--  <#if (syndrome.general_description!"") !="">
				<div class="blog-post" id="general_description">
					<h2 class="blog-post-title">类证鉴别</h2>
					<blockquote>
						<p>${syndrome.general_description}</p>
					</blockquote>
				</div></#if>-->
				<!-- /.blog-post --> 
			
				<!--  <#if (syndrome.general_description!"") !="">
				<div class="blog-post" id="general_description">
					<h2 class="blog-post-title">文献选录</h2>
					<blockquote>
						<p>${syndrome.general_description}</p>
					</blockquote>
				</div></#if>-->
				<!-- /.blog-post --> 
		
				<#if (syndrome.data_source!"") !="">
				<div class="blog-post" id="data_source">
					<h2 class="blog-post-title">数据来源</h2>
					<blockquote>
						<p>${syndrome.data_source}</p>
					</blockquote>
				</div>
				</#if>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>



   
	<script>
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}
</script>
	<script type="text/javascript">

 var syndrome_id='${syndrome.id}';
 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();
 
 if('${(syndrome.general_description)!}'!=""){ showItemList.push("概述"); showItemListEn.push("general_description");}

//if('${(syndrome.general_description)!}'!=""){ showItemList.push("临床表现"); showItemListEn.push("general_description");}
if('${(syndromeTreatment?size)!}'!=""){ showItemList.push("常见疾病"); showItemListEn.push("disease_name");}

//if(('${(syndrome.general_description)!}') !=""){ showItemList.push("本证辨析"); showItemListEn.push("general_description");}
//if(('${(syndrome.general_description)!}') !=""){ showItemList.push("类证鉴别"); showItemListEn.push("general_description");}
//if('${(syndrome.general_description)!}'!=""){ showItemList.push("文献选录"); showItemListEn.push("general_description");}
if('${(syndrome.data_source)!}'!=""){ showItemList.push("数据来源"); showItemListEn.push("data_source");}
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
  console.log(code);
</script>
</body>
</html>
