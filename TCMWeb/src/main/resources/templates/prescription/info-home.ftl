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
			<h1 class="blog-title">${prescription.name}</h1>
<!-- 			<p class="lead blog-description">The official example template of -->
<!-- 				creating a blog with Bootstrap.</p> -->
			<nav>
				<ul class="pager">
					<li><a
						href="/index.html">返回</a></li>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">

				<#if (prescription.alias!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">别名</h2>
					<blockquote>
						<p>${prescription.alias}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.composition!"") !="">
				<div class="blog-post" id="id-etpa">
					<h2 class="blog-post-title">处方</h2>
					<blockquote>
						<p>${prescription.composition}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.processed!"") !="">
				<div class="blog-post" id="id-clma">
					<h2 class="blog-post-title">炮制</h2>
					<blockquote>
						<p>${prescription.processed}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.process!"") !="">
				<div class="blog-post" id="id-examination">
					<h2 class="blog-post-title">制法</h2>
					<blockquote>
						<p>${prescription.process}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (prescription.pharmacologicaleffects!"") !="">
				<div class="blog-post" id="id-esdi">
					<h2 class="blog-post-title">药理作用</h2>
					<blockquote>
						<p>${prescription.pharmacologicaleffects}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>


				<#if (prescription.function!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">功能主治</h2>
					<blockquote>
						<p>${prescription.function}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.dosage!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">用法用量</h2>
					<blockquote>
						<p>${prescription.dosage}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.remarks!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">备注</h2>
					<blockquote>
						<p>${prescription.remarks}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (prescription.variousDescription!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">各家论述</h2>
					<blockquote>
						<p>${prescription.variousDescription}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.application!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">临床应用</h2>
					<blockquote>
						<p>${prescription.application}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.attention!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">注意</h2>
					<blockquote>
						<p>${prescription.attention}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (prescription.source!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">摘录</h2>
					<blockquote>
						<p>${prescription.source}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

			</div>
			<!-- /.blog-main -->

			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">

			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	<script src="/bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
