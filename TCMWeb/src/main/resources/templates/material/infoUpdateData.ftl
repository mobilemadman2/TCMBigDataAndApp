<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/info-page.css" rel="stylesheet">
</head>

<body>

	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
<div class="container">
	<div class="blog-header">
			<h1 class="blog-title">更新中药材</h1>
			<p class="lead blog-description"></p>
			<nav>

			</nav>
		</div>
	
	<!-- <p>新增方剂</p>-->
	<form name="frmLogin" id="frmLogin" action="/material/infoUpdateData">
	<div class="blog-post" id="id-link">
		<h2 class="blog-post-title">链接</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="link" id="link"><#if (material.link!"") !="">${material.link}</#if></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameCn">
		<h2 class="blog-post-title">中文名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;resize:none;" name="nameCn" id="nameCn"><#if (material.nameCn!"") !="">${material.nameCn}</#if></textarea><br>
		</blockquote>
	</div>			
	<div class="blog-post" id="id-pinyin">
		<h2 class="blog-post-title">拼音</h2>
		<blockquote>
			 <textarea style="width:600px;height:100px;" name="pinyin" id="pinyin"><#if (material.pinyin!"") !="">${material.pinyin}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameLatin">
		<h2 class="blog-post-title">拉丁名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameLatin" id="nameLatin"><#if (material.nameLatin!"") !="">${material.nameLatin}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameEn">
		<h2 class="blog-post-title">英文名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameEn" id="nameEn"><#if (material.nameEn!"") !="">${material.nameEn}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-alias">
		<h2 class="blog-post-title">别名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="alias" id="alias"><#if (material.alias!"") !="">${material.alias}</#if></textarea><br>  
		</blockquote>
	</div>
	<div class="blog-post" id="id-picture">
		<h2 class="blog-post-title">图片</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="picture" id="picture"><#if (material.picture!"") !="">${material.picture}</#if></textarea><br>
		</blockquote>
	</div>
		<div class="blog-post" id="id-classification">
		<h2 class="blog-post-title">类别</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="classification" id="classification"><#if (material.classification!"") !="">${material.classification}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionCn">
		<h2 class="blog-post-title">源形态</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionCn" id="attributionCn"><#if (material.sourceCn!"") !="">${material.sourceCn}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionEn">
		<h2 class="blog-post-title">源形态英文</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionEn" id="attributionEn"><#if (material.sourceEn!"") !="">${material.sourceEn}</textarea></#if><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionLatin">
		<h2 class="blog-post-title">源形态拉丁</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionLatin" id="attributionLatin"><#if (material.sourceLatin!"") !="">${material.sourceLatin}</#if></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-attributionSubfamily">
		<h2 class="blog-post-title">源形态亚科</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionSubfamily" id="attributionSubfamily"><#if (material.sourceSubfamily!"") !="">${material.sourceSubfamily}</#if></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-description">
		<h2 class="blog-post-title">描述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="description" id="description"><#if (material.description!"") !="">${material.description}</#if></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-attribution">
		<h2 class="blog-post-title">性状</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attribution" id="attribution"><#if (material.attribution!"") !="">${material.attribution}</#if></textarea><br>   
		</blockquote>
	</div>			
		<div class="blog-post" id="id-composition">
		<h2 class="blog-post-title">主要成分</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="composition" id="composition"><#if (material.composition!"") !="">${material.composition}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-pharmacologic">
		<h2 class="blog-post-title">药理作用</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="pharmacologic" id="pharmacologic"><#if (material.pharmacologic!"") !="">${material.pharmacologic}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-taste">
		<h2 class="blog-post-title">性味</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="taste" id="taste"><#if (material.taste!"") !="">${material.taste}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-channel">
		<h2 class="blog-post-title">归经</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="channel" id="channel"><#if (material.channel!"") !="">${material.channel}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-effect">
		<h2 class="blog-post-title">功效</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="effect" id="effect"><#if (material.effect!"") !="">${material.effect}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-action">
		<h2 class="blog-post-title">主治</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="action" id="action"><#if (material.action!"") !="">${material.action}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-method">
		<h2 class="blog-post-title">用法用量</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="method" id="method"><#if (material.method!"") !="">${material.method}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-taboo">
		<h2 class="blog-post-title">禁忌</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="taboo" id="taboo"><#if (material.taboo!"") !="">${material.taboo}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-virulence">
		<h2 class="blog-post-title">毒性</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="virulence" id="virulence"><#if (material.virulence!"") !="">${material.virulence}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-cultivation">
		<h2 class="blog-post-title">栽培要点</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="cultivation" id="cultivation"><#if (material.cultivation!"") !="">${material.cultivation}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-origin">
		<h2 class="blog-post-title">地道沿革</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="origin" id="origin"><#if (material.origin!"") !="">${material.origin}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-recovery">
		<h2 class="blog-post-title">采收</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="recovery" id="recovery"><#if (material.recovery!"") !="">${material.recovery}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-process">
		<h2 class="blog-post-title">炮制</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="process" id="process"><#if (material.process!"") !="">${material.process}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-research">
		<h2 class="blog-post-title">古籍考证</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="research" id="research"><#if (material.research!"") !="">${material.research}</#if></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-discuss">
		<h2 class="blog-post-title">名家论述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="discuss" id="discuss"><#if (material.discuss!"") !="">${material.discuss}</#if></textarea><br>   
		</blockquote>
	</div>				
	</div>				
		<div class="blog-post" id="id-excerpt">
		<h2 class="blog-post-title">摘录</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="excerpt" id="excerpt"><#if (material.excerpt!"") !="">${material.excerpt}</#if></textarea><br>   
		</blockquote>
	</div>			
	<textarea style="width:600px;height:100px;display:none" name="id" id="id">${material.id}</textarea>	

 <ul  class="pager">
					<!--<li><input type="submit"></li>-->
					<li><a onclick ="add(1,2);">提交</a></li>
					<li><a href="/index.html">返回</a></li>
				</ul>
				
			
     <!-- <input type="button" value="返回" href="/index.html"></a>-->
</form> 

<script type="text/javascript">
function add(key,value)
{
    //document.getElementById(key).value = value;
    var tmp=document.getElementById("id").value;
    tmp=tmp.replace(",","");
    var tmp=parseInt(tmp);
    //alert(tmp-2);
    
    document.getElementById("id").innerHTML=tmp;
    document.getElementById("frmLogin").submit();
}
</script>


</div>
	 <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
