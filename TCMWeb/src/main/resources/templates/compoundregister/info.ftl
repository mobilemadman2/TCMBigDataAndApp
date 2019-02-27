<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
</head>

<body>

	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
	
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">${compoundregister.elRegistryNumber}（K号）</h1>
			<p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p>
			<nav>
				<ul class="pager">
					<li><a
						href="/compoundregister.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">

				<#if (compoundregister.chineseSystemicName!"") !="">
				<div class="blog-post" id="id-etpa">
					<h2 class="blog-post-title">中文通用名</h2>
					<blockquote>
						<p>${compoundregister.chineseSystemicName}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (compoundregister.accessNo!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">编号</h2>
					<blockquote>
						<p>${compoundregister.accessNo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (compoundregister.regCn1!"") !="">
				<div class="blog-post" id="id-clma">
					<h2 class="blog-post-title">REG_CN1</h2>
					<blockquote>
						<p>${compoundregister.regCn1}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (compoundregister.regCn2!"") !="">
				<div class="blog-post" id="id-examination">
					<h2 class="blog-post-title">REG_CN2</h2>
					<blockquote>
						<p>${compoundregister.regCn2}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

				<#if (compoundregister.casRegistryNumber1!"") !="">
				<div class="blog-post" id="id-esdi">
					<h2 class="blog-post-title">CAS_Registry_Number_1</h2>
					<blockquote>
						<p>${compoundregister.casRegistryNumber1}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>


				<#if (compoundregister.casRegistryNumber2!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">CAS_Registry_Number_2</h2>
					<blockquote>
						<p>${compoundregister.casRegistryNumber2}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.cnn!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文通用名</h2>
					<blockquote>
						<p>${compoundregister.cnn}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.chineseSystemicName!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文系统命名</h2>
					<blockquote>
						<p>${compoundregister.chineseSystemicName}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (compoundregister.chineseSynonyms!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文别名</h2>
					<blockquote>
						<p>${compoundregister.chineseSynonyms}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.englishName!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">英文通用名</h2>
					<blockquote>
						<p>${compoundregister.englishName}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.systemicName!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">英文系统命名</h2>
					<blockquote>
						<p>${compoundregister.systemicName}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.englishSynonyms!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">英文别名</h2>
					<blockquote>
						<p>${compoundregister.englishSynonyms}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.chinesePinyin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">中文拼音</h2>
					<blockquote>
						<p>${compoundregister.chinesePinyin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.tc!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">TC</h2>
					<blockquote>
						<p>${compoundregister.tc}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.classification!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">分类</h2>
					<blockquote>
						<p>${compoundregister.classification}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.molecularFormula!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">化学式</h2>
					<blockquote>
						<p>${compoundregister.molecularFormula}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.patentOrigin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">专利来源</h2>
					<blockquote>
						<p>${compoundregister.patentOrigin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (compoundregister.materialOrigin!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">材料来源</h2>
					<blockquote>
						<p>${compoundregister.materialOrigin}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.picMol!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">PIC_MOL</h2>
					<blockquote>
						<p>${compoundregister.picMol}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.picTif!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">PIC_TIF</h2>
					<blockquote>
						<p>${compoundregister.picTif}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.picTif!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">PIC_GIF</h2>
					<blockquote>
						<p>${compoundregister.picTif}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.picTif!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">PIC_JPG</h2>
					<blockquote>
						<p>${compoundregister.picTif}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.picBmp!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">PIC_BMP</h2>
					<blockquote>
						<p>${compoundregister.picBmp}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.note!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">备注</h2>
					<blockquote>
						<p>${compoundregister.note}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (compoundregister.state!"") !="">
				<div class="blog-post" id="id-didi">
					<h2 class="blog-post-title">状态</h2>
					<blockquote>
						<p>${compoundregister.state}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>

			</div>
			<!-- /.blog-main -->

			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
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
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
