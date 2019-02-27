<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/info-page.css" rel="stylesheet">
</head>

<body>
	<#include "/common/nav.ftl">

	<div class="container">
		<#assign nav_name = ["医疗图像", "${disease_class}${image_class}图像", '${image.fileName}']>
    	<#assign nav_href = ["/image.html", "/getImageList?disease_class=${disease_class}&image_class=${image_class}",'#']>
    	<#include "/common/nav-pos.ftl"/>
		<div class="blog-header">
			<h1 class="blog-title">${image.diseaseClass}${image.imageClass}图像</h1> 
		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">
				<div class="blog-post" id="id-image">
					<img src="${image.imagePath}" width="600">
				</div>
				
				<div class="blog-post" id="id-diseaseClass">
					<h2 class="blog-post-title">疾病名称</h2>
					<blockquote>
						<p>${image.diseaseClass}</p>
					</blockquote>
				</div>
				
				<div class="blog-post" id="id-imageClass">
					<h2 class="blog-post-title">图像类型</h2>
					<blockquote>
						<p>${image.imageClass}</p>
					</blockquote>
				</div>
					
				<div class="blog-post" id="id-groundTruth">
					<h2 class="blog-post-title">类别标签</h2>
					<blockquote>
						<p>${image.groundTruth}</p>
					</blockquote>
				</div>
				
				<div class="blog-post" id="id-illustration">
					<h2 class="blog-post-title">简介</h2>
					<blockquote>
						<p>${image.illustration}</p>
					</blockquote>
				</div>
				
				<div class="blog-post" id="id-source">
					<h2 class="blog-post-title">来源</h2>
					<blockquote>
						<p>${image.source}</p>
					</blockquote>
				</div>
						
			</div>
		</div>
	</div>
	
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	<script src="/bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>