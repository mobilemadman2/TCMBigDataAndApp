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
			<h1 class="blog-title">${mainrecord.id}（编号）</h1>
			<p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p>
			<nav>
				<ul class="pager">
					<li><a
						href="/mainrecord.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">

			<#if (mainrecord.residenceNo!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">房号</h2>
					<blockquote>
						<p>${mainrecord.residenceNo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.visitNumber!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">住院次数</h2>
					<blockquote>
						<p>${mainrecord.visitNumber}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.sickId!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">病人ID</h2>
					<blockquote>
						<p>${mainrecord.sickId}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.sickName!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">病人名字</h2>
					<blockquote>
						<p>${mainrecord.sickName}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.age!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">年龄</h2>
					<blockquote>
						<p>${mainrecord.age}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.sex!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">性别</h2>
					<blockquote>
						<p>${mainrecord.sex}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.status!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">状态（临床路径）</h2>
					<blockquote>
						<p>${mainrecord.status}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.confirm!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">确认（临床路径）</h2>
					<blockquote>
						<p>${mainrecord.confirm}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.exitReason!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">存在原因（临床路径）</h2>
					<blockquote>
						<p>${mainrecord.exitReason}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.toDate_A_AdmissionTime_!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">入院时间</h2>
					<blockquote>
						<p>${mainrecord.toDate_A_AdmissionTime_}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.admiYear!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">入院年份</h2>
					<blockquote>
						<p>${mainrecord.admiYear}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.toDate_A_DischargeTime_!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">出院时间</h2>
					<blockquote>
						<p>${mainrecord.toDate_A_DischargeTime_}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.inday!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">住院天数</h2>
					<blockquote>
						<p>${mainrecord.inday}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.indays!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">住院天数（医保规定）</h2>
					<blockquote>
						<p>${mainrecord.indays}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.diseaseStatus!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">疾病状态</h2>
					<blockquote>
						<p>${mainrecord.diseaseStatus}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.nowDiagnosis!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">诊断现状</h2>
					<blockquote>
						<p>${mainrecord.nowDiagnosis}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (mainrecord.sumCost!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">总花费</h2>
					<blockquote>
						<p>${mainrecord.sumCost}</p>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script> <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
