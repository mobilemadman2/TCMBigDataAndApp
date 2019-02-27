<!DOCTYPE html>
<html lang="en">
<head>
<#include "/common/common-head.ftl"/>
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
			<h1 class="blog-title">${naturalmedicine.nameCn}</h1>
			<!-- <p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p> -->
			<nav>
				<ul class="pager">
					<li><a
						href="/naturalmedicine.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li>
					<!-- <li><a href="#">Next</a></li> -->
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">

				<#if (naturalmedicine.reg!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">药物主登记号</h2>
					<blockquote>
						<p>${naturalmedicine.reg}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (naturalmedicine.nameCn!"") !="">
				<div class="blog-post" id="id-etpa">
					<h2 class="blog-post-title">中文名称</h2>
					<blockquote>
						<p>${naturalmedicine.nameCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (naturalmedicine.aliasCn!"") !="">
				<div class="blog-post" id="id-clma">
					<h2 class="blog-post-title">中文别名</h2>
					<blockquote>
						<p>${naturalmedicine.aliasCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (naturalmedicine.wrong!"") !="">
				<div class="blog-post" id="id-examination">
					<h2 class="blog-post-title">别字</h2>
					<blockquote>
						<p>${naturalmedicine.wrong}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (naturalmedicine.similar!"") !="">
				<div class="blog-post" id="id-esdi">
					<h2 class="blog-post-title">同类药物名称</h2>
					<blockquote>
						<p>${naturalmedicine.similar}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>


				<#if (naturalmedicine.nameEn!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">英文名称</h2>
					<blockquote>
						<p>${naturalmedicine.nameEn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.aliasEn!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">英文别名</h2>
					<blockquote>
						<p>${naturalmedicine.aliasEn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.nameLatin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">拉丁名</h2>
					<blockquote>
						<p>${naturalmedicine.nameLatin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (naturalmedicine.nameLatinAa!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">拉丁动植物名</h2>
					<blockquote>
						<p>${naturalmedicine.nameLatinAa}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.chinesePinyin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">汉语拼音</h2>
					<blockquote>
						<p>${naturalmedicine.chinesePinyin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.familyCn!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文科名</h2>
					<blockquote>
						<p>${naturalmedicine.familyCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.familyLatin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">科名</h2>
					<blockquote>
						<p>${naturalmedicine.familyLatin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.genusCn!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文属名</h2>
					<blockquote>
						<p>${naturalmedicine.genusCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.genusLatin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">属名</h2>
					<blockquote>
						<p>${naturalmedicine.genusLatin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.note!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">备注</h2>
					<blockquote>
						<p>${naturalmedicine.note}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (naturalmedicine.state!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">状态</h2>
					<blockquote>
						<p>${naturalmedicine.state}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

			</div>
			<!-- /.blog-main -->

			
			<!-- /.blog-sidebar<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>
						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
						mattis consectetur purus sit amet fermentum. Aenean lacinia
						bibendum nulla sed consectetur.
					</p>
				</div>
				<div class="sidebar-module">
					<h4>Archives</h4>
					<ol class="list-unstyled">
						<li><a href="#">March 2014</a></li>
						<li><a href="#">February 2014</a></li>
						<li><a href="#">January 2014</a></li>
						<li><a href="#">December 2013</a></li>
						<li><a href="#">November 2013</a></li>
						<li><a href="#">October 2013</a></li>
						<li><a href="#">September 2013</a></li>
						<li><a href="#">August 2013</a></li>
						<li><a href="#">July 2013</a></li>
						<li><a href="#">June 2013</a></li>
						<li><a href="#">May 2013</a></li>
						<li><a href="#">April 2013</a></li>
					</ol>
				</div>
				<div class="sidebar-module">
					<h4>Elsewhere</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
					</ol>
				</div>
			</div> -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->

	<script src="bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
