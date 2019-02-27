<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>中医大数据</title>

<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/navbar-fixed-top.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/info-page.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
<div class="container">
	<div class="blog-header">
			<h1 class="blog-title">更新疾病</h1>
			<p class="lead blog-description"></p>
			<nav>

			</nav>
		</div>
	
	<!-- <p>新增方剂</p>-->
	<form name="frmLogin" id="frmLogin" action="/disease/infoUpdateData">
	<div class="blog-post" id="id-name">
		<h2 class="blog-post-title">名称</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="name" id="name"><#if (disease.name!"") !="">${disease.name}</#if></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-nameChn">
		<h2 class="blog-post-title">中文名称</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="nameChn" id="nameChn"><#if (disease.nameChn!"") !="">${disease.nameChn}</#if></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-alias">
		<h2 class="blog-post-title">别名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="alias" id="alias"><#if (disease.alias!"") !="">${disease.alias}</#if></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-overview">
		<h2 class="blog-post-title">概述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;resize:none;" name="overview" id="overview"><#if (disease.overview!"") !="">${disease.overview}</#if></textarea><br>
		</blockquote>
	</div>
				
	<div class="blog-post" id="id-EtPa">
		<h2 class="blog-post-title">病因病机</h2>
		<blockquote>
			 <textarea style="width:600px;height:100px;" name="EtPa" id="EtPa"><#if (disease.EtPa!"") !="">${disease.EtPa}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-clma">
		<h2 class="blog-post-title">临床表现</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="clma" id="clma"><#if (disease.clma!"") !="">${disease.clma}</#if></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-examination">
		<h2 class="blog-post-title">实验室辅助检查</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="examination" id="examination"><#if (disease.examination!"") !="">${disease.examination}</#if></textarea><br>  
		</blockquote>
	</div>
	<div class="blog-post" id="id-esdi">
		<h2 class="blog-post-title">诊断要点</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="esdi" id="esdi"><#if (disease.esdi!"") !="">${disease.esdi}</#if></textarea><br>
		</blockquote>
	</div>
		<div class="blog-post" id="id-didi">
		<h2 class="blog-post-title">鉴别诊断</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="didi" id="didi"><#if (disease.didi!"") !="">${disease.didi}</#if></textarea><br> 
		</blockquote>
	</div>	
	<textarea style="width:600px;height:100px;display:none" name="id" id="id">${disease.id}</textarea>	

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
