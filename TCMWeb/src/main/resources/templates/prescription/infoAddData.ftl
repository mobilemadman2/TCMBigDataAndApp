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
			<h1 class="blog-title">新增方剂</h1>
			<p class="lead blog-description"></p>
			<nav>

			</nav>
		</div>
	
	<!-- <p>新增方剂</p>-->
	<form name="frmLogin" id="frmLogin" action="/prescription/infoAddData">
	<div class="blog-post" id="id-name">
		<h2 class="blog-post-title">方名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="name" id="name"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-alias">
		<h2 class="blog-post-title">别名</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;resize:none;" name="alias" id="alias"></textarea><br>
		</blockquote>
	</div>			
	<div class="blog-post" id="id-composition">
		<h2 class="blog-post-title">处方</h2>
		<blockquote>
			 <textarea style="width:600px;height:100px;" name="composition" id="composition"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-processed">
		<h2 class="blog-post-title">炮制</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="processed" id="processed"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-process">
		<h2 class="blog-post-title">制法</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="process" id="process"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-pharmacologicaleffects">
		<h2 class="blog-post-title">药理作用</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="pharmacologicaleffects" id="pharmacologicaleffects"></textarea><br>  
		</blockquote>
	</div>
	<div class="blog-post" id="id-function">
		<h2 class="blog-post-title">功能主治</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="function" id="function"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-dosage">
		<h2 class="blog-post-title">用法用量</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="dosage" id="dosage"></textarea><br> 
		</blockquote>
	</div>
	<div class="blog-post" id="id-remarks">
		<h2 class="blog-post-title">备注</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="remarks" id="remarks"></textarea><br>
		</blockquote>
	</div>
	<div class="blog-post" id="id-variousDescription">
		<h2 class="blog-post-title">各家论述</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="variousDescription" id="variousDescription"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-application">
		<h2 class="blog-post-title">临床应用</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="application" id="application"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-attention">
		<h2 class="blog-post-title">注意</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="attention" id="attention"></textarea><br> 
		</blockquote>
	</div>	
	<div class="blog-post" id="id-source">
		<h2 class="blog-post-title">摘录</h2>
		<blockquote>
			<textarea style="width:600px;height:100px;" name="source" id="source"></textarea><br>   
		</blockquote>
	</div>			
				
             <!--  方名: <textarea style="width:600px;height:100px;" name="name" id="name"></textarea><br>  
              别名: <textarea style="width:600px;height:100px;" name="alias" id="alias"></textarea><br>  
    处方: <textarea style="width:600px;height:100px;" name="composition" id="composition"></textarea><br>  
    炮制: <textarea style="width:600px;height:100px;" name="processed" id="processed"></textarea><br>  
    制法: <textarea style="width:600px;height:100px;" name="process" id="process"></textarea><br>  
    药理作用: <textarea style="width:600px;height:100px;" name="pharmacologicaleffects" id="pharmacologicaleffects"></textarea><br>  
    功能主治: <textarea style="width:600px;height:100px;" name="function" id="function"></textarea><br>  
    用法用量: <textarea style="width:600px;height:100px;" name="dosage" id="dosage"></textarea><br>  
    备注: <textarea style="width:600px;height:100px;" name="remarks" id="remarks"></textarea><br>  
    各家论述: <textarea style="width:600px;height:100px;" name="variousDescription" id="variousDescription"></textarea><br>  
    临床应用: <textarea style="width:600px;height:100px;" name="application" id="application"></textarea><br>  
    注意: <textarea style="width:600px;height:100px;" name="attention" id="attention"></textarea><br>  
    摘录: <textarea style="width:600px;height:100px;" name="source" id="source"></textarea><br>   -->

 <ul  class="pager">
					<!--<li><a href="/infoAddData.html" onclick ="add(1,2);">提交</a></li>-->
					<li><a onclick ="add(1,2);">提交</a></li>
					<li><a href="/index.html">返回</a></li>
				</ul>
				
			
     <!-- <input type="button" value="返回" href="/index.html"></a>-->
</form> 
<script type="text/javascript">
function add(key,value)
{
    //document.getElementById(key).value = value;
    //alert(value);
  
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
