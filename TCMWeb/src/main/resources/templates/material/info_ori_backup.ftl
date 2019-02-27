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
			<h1 class="blog-title">${material.nameCn}（编号:${material.id}）</h1>
<!-- 			<p class="lead blog-description">The official example template of -->
<!-- 				creating a blog with Bootstrap.</p> -->
<!-- 			<nav> -->
<!-- 				<ul class="pager"> -->
<!-- 					<li><a -->
<!-- 						href="/material.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li> -->
<!-- 					<li><a href="#">Next</a></li> -->
<!-- 				</ul> -->
<!-- 			</nav> -->
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
		<table class="table table-striped">
		<tr>
		<td><#if (material.nameCn!"") !="">
					<div class="col-xs-16">中文学名：${material.nameCn}</div>
				
				<!-- /.blog-post --> </#if></td>
				<td> 
				<#if (material.nameEn!"") !="">
					<div class="col-xs-16">英文名：${material.nameEn}</div>
			
				<!-- /.blog-post --> </#if>
				</td>
		</tr>
		
		<tr>
		<td> <#if (material.pinyin!"") !="">
					<div class="col-xs-16">中文拼音：${material.pinyin}</div>
				
				<!-- /.blog-post --> </#if></td>
		<td> <#if (material.alias!"") !="">
					<div class="col-xs-16">别名：${material.alias}</div>
				
				<!-- /.blog-post --> </#if></td>
        </tr>
        
        <tr>
		<td> <#if (material.nameLatin!"") !="">
				<div class="col-xs-16">拉丁名：${material.nameLatin}</div>
				<!-- /.blog-post --> </#if></td>
		<td> <#if (material.classification!"") !="">
				<div class="col-xs-16">类别：${material.classification}
				</div>
				<!-- /.blog-post --> </#if></td>
        </tr>
        
        <tr>
		<td><#if (material.sourceCn!"") !="">
				<div class="col-xs-16">源形态：${material.sourceCn}</div>
				<!-- /.blog-post --> </#if>
				 </td>
		<td> <#if (material.sourceEn!"") !="">
				<div class="col-xs-16">源形态英文：${material.sourceEn}</div>
				<!-- /.blog-post --> </#if></td>
        </tr>
        
        <tr>
		<td> <#if (material.sourceLatin!"") !="">
				<div class="col-xs-16">源形态拉丁：${material.sourceLatin}
				</div>
				<!-- /.blog-post --> </#if></td>
        </tr>
        
        <tr>
		<td> <#if (material.sourceSubfamily!"") !="">
				<div class="col-xs-16">源形态亚科：${material.sourceSubfamily}</div>
				<!-- /.blog-post --> </#if></td>
        </tr>
  
      
     </table>
				
				
				<#if (material.nameCn!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">中文名</h2>
					<blockquote>
						<p>${material.nameCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (material.pinyin!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">拼音</h2>
					<blockquote>
						<p>${material.pinyin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.nameLatin!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">拉丁名</h2>
					<blockquote>
						<p>${material.nameLatin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.nameEn!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">英文名</h2>
					<blockquote>
						<p>${material.nameEn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.alias!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">别名</h2>
					<blockquote>
						<p>${material.alias}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.classification!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">类别</h2>
					<blockquote>
						<p>${material.classification}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (material.sourceCn!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">源形态</h2>
					<blockquote>
						<p>${material.sourceCn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (material.sourceEn!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">源形态英文</h2>
					<blockquote>
						<p>${material.sourceEn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.sourceLatin!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">源形态拉丁</h2>
					<blockquote>
						<p>${material.sourceLatin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.sourceSubfamily!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">源形态亚科</h2>
					<blockquote>
						<p>${material.sourceSubfamily}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
<#if (material.picture!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">图片</h2>
					<blockquote>
						<p>${material.picture}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if> 






<#if (material.picture!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">图片</h2>
					<blockquote>
						<p>${material.picture}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (material.description!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">描述</h2>
					<blockquote>
						<p>${material.description}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.attribution!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">性状</h2>
					<blockquote>
						<p>${material.attribution}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.composition!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">主要成分</h2>
					<blockquote>
						<p>${material.composition}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.pharmacologic!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">药理作用</h2>
					<blockquote>
						<p>${material.pharmacologic}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.taste!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">性味</h2>
					<blockquote>
						<p>${material.taste}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.channel!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">归经</h2>
					<blockquote>
						<p>${material.channel}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.effect!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">功效</h2>
					<blockquote>
						<p>${material.effect}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.action!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">主治</h2>
					<blockquote>
						<p>${material.action}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.method!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">用法用量</h2>
					<blockquote>
						<p>${material.method}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.taboo!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">禁忌</h2>
					<blockquote>
						<p>${material.taboo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.virulence!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">毒性</h2>
					<blockquote>
						<p>${material.virulence}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.cultivation!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">栽培要点</h2>
					<blockquote>
						<p>${material.cultivation}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.origin!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">地道沿革</h2>
					<blockquote>
						<p>${material.origin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.recovery!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">采收</h2>
					<blockquote>
						<p>${material.recovery}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.process!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">炮制</h2>
					<blockquote>
						<p>${material.process}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.research!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">古籍考证</h2>
					<blockquote>
						<p>${material.research}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.discuss!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">名家论述</h2>
					<blockquote>
						<p>${material.discuss}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (material.excerpt!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">摘录</h2>
					<blockquote>
						<p>${material.excerpt}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
							<#if (material.link!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">链接</h2>
					<blockquote>
						<p>${material.link}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

			</div>
			<!-- /.blog-main -->

<!-- 			<div class="col-sm-3 col-sm-offset-1 blog-sidebar"> -->
<!-- 				<div class="sidebar-module sidebar-module-inset"> -->
<!-- 					<h4>About</h4> -->
<!-- 					<p> -->
<!-- 						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras -->
<!-- 						mattis consectetur purus sit amet fermentum. Aenean lacinia -->
<!-- 						bibendum nulla sed consectetur. -->
<!-- 					</p> -->
<!-- 				</div> -->
<!-- 				<div class="sidebar-module"> -->
<!-- 					<h4>Archives</h4> -->
<!-- 					<ol class="list-unstyled"> -->
<!-- 						<li><a href="#">March 2014</a></li> -->
<!-- 						<li><a href="#">February 2014</a></li> -->
<!-- 						<li><a href="#">January 2014</a></li> -->
<!-- 						<li><a href="#">December 2013</a></li> -->
<!-- 						<li><a href="#">November 2013</a></li> -->
<!-- 						<li><a href="#">October 2013</a></li> -->
<!-- 						<li><a href="#">September 2013</a></li> -->
<!-- 						<li><a href="#">August 2013</a></li> -->
<!-- 						<li><a href="#">July 2013</a></li> -->
<!-- 						<li><a href="#">June 2013</a></li> -->
<!-- 						<li><a href="#">May 2013</a></li> -->
<!-- 						<li><a href="#">April 2013</a></li> -->
<!-- 					</ol> -->
<!-- 				</div> -->
<!-- 				<div class="sidebar-module"> -->
<!-- 					<h4>Elsewhere</h4> -->
<!-- 					<ol class="list-unstyled"> -->
<!-- 						<li><a href="#">GitHub</a></li> -->
<!-- 						<li><a href="#">Twitter</a></li> -->
<!-- 						<li><a href="#">Facebook</a></li> -->
<!-- 					</ol> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
