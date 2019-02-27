<!DOCTYPE html>
<html lang="en">
<head>
<#include "/common/common-head.ftl"/>
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
	    <#assign nav_name = ["中医论文","${paper.paper_name}"]>
    	<#assign nav_href = ["/paper.html", "/paper/info.html?paperId=${paper.id}"]>
    	<#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">${paper.paper_name}</h1>
			<!-- <p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p> -->

		</div>


		<div class="row">
			<div class="col-sm-8 blog-main">			
	<!-- 			
	<table id="showDetail">

 	</table>			
	-->		<!-- abstract -->
			
			<div class="blog-post" id="abstracts">
					<h2 class="blog-post-title">摘要</h2>
					<#if (paper.paper_abstract!"") !="">
					<blockquote>
						<p>${paper.paper_abstract}</p>
					</blockquote>
					</#if>
			</div>	
			<!-- author -->
			<div class="blog-post" id="author">
					<h2 class="blog-post-title">作者</h2>
					<blockquote>
						<p>${paper.author}</p>
					</blockquote>
			</div>	
			<div class="blog-post" id="department">
					<h2 class="blog-post-title">作者单位</h2>
					<blockquote>
						<p>${paper.department}</p>
					</blockquote>
			</div>	
			<#if (paper.periodical_name!"") !="">
			<div class="blog-post" id=periodical>
					<h2 class="blog-post-title">期刊</h2>
					<blockquote>
						<p>${paper.periodical_name}&#32;${paper.periodical_time}&#32;${paper.periodical_pages}</p>
						<#if (paper.periodical_employ_list!"") !="">
						<p>&#32;收录信息：${paper.periodical_employ_list}</p>
						</#if>	
					</blockquote>
			</div>
			</#if>
			<#if (paper.key_words_chinese_list!"") !="">
			<div class="blog-post" id=keywords>
					<h2 class="blog-post-title">关键词</h2>
					<blockquote>
						<p>中文：${paper.key_words_chinese_list}</p>
						<#if (paper.key_words_english_list!"") !="">
						<p>英文：${paper.key_words_english_list}</p>
						</#if>
					</blockquote>
			</div>
			</#if>
			<#if (paper.column_name!"") !="">
			<div class="blog-post" id=column_name>
					<h2 class="blog-post-title">栏目名称</h2>
					<blockquote>
						<p>${paper.column_name}</p>
					</blockquote>
			</div>
			</#if>
			<#if (paper.doi!"") !="">
			<div class="blog-post" id=doi>
					<h2 class="blog-post-title">DOI</h2>
					<blockquote>
						<p>${paper.doi}</p>
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

 var paper_id='${paper.id}';
 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();

if('${(paper.paper_abstract)!}'!=""){ showItemList.push("摘要"); showItemListEn.push("paper_abstract");}
if('${(paper.periodical_name)!}'!=""){ showItemList.push("期刊"); showItemListEn.push("periodical_name");}
if('${(paper.key_words_chinese_list)!}'!=""){ showItemList.push("关键词"); showItemListEn.push("key_words_chinese_list");}
if('${(paper.column_name)!}'!=""){ showItemList.push("栏目名称"); showItemListEn.push("column_name");}
if('${(paper.doi)!}'!=""){ showItemList.push("DOI"); showItemListEn.push("doi");}


var tmp=0;
var div1 = document.getElementById('showDetail');
 var code = '';
 var max = 3;
 var SDROW1 = '<TR><TD></TD>';
 var SDROW2 = '<TR><TD></TD>';
 var SDROW3 = '<TR><TD></TD>';
 var SDROW4 = '<TR><TD></TD>';
 var SDROW5 = '<TR><TD></TD>';
 var SDROW6 = '<TR><TD></TD>';
 var SDROW7 = '<TR><TD></TD>';
 var indexList = new Array();

for(var i = 0,len=showItemList.length;i<len;i++){
    index=i%max+1;
    num=i+1;
   itemtmp="<TD id=\""+showItemList[i]+"\" onclick=\"scrollToDiv(\'"+showItemListEn[i]+"\')\"><blockquote>"+num+" "+showItemList[i]+"</blockquote></TD>";
    eval("SDROW"+index+"+=itemtmp");
  
}
var end="</TR>"
for(var j=1;j<=max;j++){
    eval("SDROW"+j+"+=end")
    eval("code+=SDROW"+j)
}

  div1.innerHTML =code;
  console.log(code);
</script>
</body>
</html>
