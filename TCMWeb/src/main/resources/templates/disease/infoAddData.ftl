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
			<h1 class="blog-title">新增疾病</h1>
			<p class="lead blog-description"></p>
			<nav>

			</nav>
		</div>
	
	<!-- <p>新增方剂</p>-->
	<form name="frmLogin1" id="frmLogin1" action="/disease/infoAddData">
	<div class="blog-post" id="id-name">
		<h2 class="blog-post-title">名称</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="name" id="name"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameChn">
		<h2 class="blog-post-title">中文名称</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameChn" id="nameChn"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-alias">
		<h2 class="blog-post-title">别名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="alias" id="alias"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-overview">
		<h2 class="blog-post-title">概述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;resize:none;" name="overview" id="overview"></textarea><br>
		</blockquote>
	</div>
				
	<div class="blog-post" id="id-EtPa">
		<h2 class="blog-post-title">病因病机</h2>
		<blockquote>
			 <textarea style="width:600px;height:100px;" name="EtPa" id="EtPa"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-clma">
		<h2 class="blog-post-title">临床表现</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="clma" id="clma"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-examination">
		<h2 class="blog-post-title">实验室辅助检查</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="examination" id="examination"></textarea><br>  
		</blockquote>
	</div>
	<div class="blog-post" id="id-esdi">
		<h2 class="blog-post-title">诊断要点</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="esdi" id="esdi"></textarea><br>
		</blockquote>
	</div>
		<div class="blog-post" id="id-didi">
		<h2 class="blog-post-title">鉴别诊断</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="didi" id="didi"></textarea><br> 
		</blockquote>
	</div>
	<!--<div class="blog-post" id="id-attributionCn">
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
	</div>-->	
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
