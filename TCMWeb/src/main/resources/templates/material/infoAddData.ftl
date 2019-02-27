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
			<h1 class="blog-title">新增中草药</h1>
			<p class="lead blog-description"></p>
			<nav>

			</nav>
		</div>
	
	<!-- <p>新增方剂</p>-->
	<form name="frmLogin1" id="frmLogin1" action="/material/infoAddData">
	<div class="blog-post" id="id-link">
		<h2 class="blog-post-title">链接</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="link" id="link"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameCn">
		<h2 class="blog-post-title">中文名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;resize:none;" name="nameCn" id="nameCn"></textarea><br>
		</blockquote>
	</div>			
	<div class="blog-post" id="id-pinyin">
		<h2 class="blog-post-title">拼音</h2>
		<blockquote>
			 <textarea style="width:600px;height:100px;" name="pinyin" id="pinyin"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameLatin">
		<h2 class="blog-post-title">拉丁名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameLatin" id="nameLatin"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameEn">
		<h2 class="blog-post-title">英文名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameEn" id="nameEn"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-alias">
		<h2 class="blog-post-title">别名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="alias" id="alias"></textarea><br>  
		</blockquote>
	</div>
	<div class="blog-post" id="id-picture">
		<h2 class="blog-post-title">图片</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="picture" id="picture"></textarea><br>
		</blockquote>
	</div>
		<div class="blog-post" id="id-classification">
		<h2 class="blog-post-title">类别</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="classification" id="classification"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionCn">
		<h2 class="blog-post-title">源形态</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionCn" id="attributionCn"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionEn">
		<h2 class="blog-post-title">源形态英文</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionEn" id="attributionEn"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-attributionLatin">
		<h2 class="blog-post-title">源形态拉丁</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionLatin" id="attributionLatin"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-attributionSubfamily">
		<h2 class="blog-post-title">源形态亚科</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attributionSubfamily" id="attributionSubfamily"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-description">
		<h2 class="blog-post-title">描述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="description" id="description"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-attribution">
		<h2 class="blog-post-title">性状</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attribution" id="attribution"></textarea><br>   
		</blockquote>
	</div>			
		<div class="blog-post" id="id-composition">
		<h2 class="blog-post-title">主要成分</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="composition" id="composition"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-pharmacologic">
		<h2 class="blog-post-title">药理作用</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="pharmacologic" id="pharmacologic"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-taste">
		<h2 class="blog-post-title">性味</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="taste" id="taste"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-channel">
		<h2 class="blog-post-title">归经</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="channel" id="channel"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-effect">
		<h2 class="blog-post-title">功效</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="effect" id="effect"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-action">
		<h2 class="blog-post-title">主治</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="action" id="action"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-method">
		<h2 class="blog-post-title">用法用量</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="method" id="method"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-taboo">
		<h2 class="blog-post-title">禁忌</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="taboo" id="taboo"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-virulence">
		<h2 class="blog-post-title">毒性</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="virulence" id="virulence"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-cultivation">
		<h2 class="blog-post-title">栽培要点</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="cultivation" id="cultivation"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-origin">
		<h2 class="blog-post-title">地道沿革</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="origin" id="origin"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-recovery">
		<h2 class="blog-post-title">采收</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="recovery" id="recovery"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-process">
		<h2 class="blog-post-title">炮制</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="process" id="process"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-research">
		<h2 class="blog-post-title">古籍考证</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="research" id="research"></textarea><br>   
		</blockquote>
	</div>				
		<div class="blog-post" id="id-discuss">
		<h2 class="blog-post-title">名家论述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="discuss" id="discuss"></textarea><br>   
		</blockquote>
	</div>				
	</div>				
		<div class="blog-post" id="id-excerpt">
		<h2 class="blog-post-title">摘录</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="excerpt" id="excerpt"></textarea><br>   
		</blockquote>
	</div>	
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

    document.getElementById("frmLogin1").submit();
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
