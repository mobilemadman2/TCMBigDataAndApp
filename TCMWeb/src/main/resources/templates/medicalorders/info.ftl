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
			<h1 class="blog-title">${medicalorders.id}（编号）</h1>
			<p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p>
			<nav>
				<ul class="pager">
					<li><a
						href="/medicalorders.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</nav>
		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">

			<#if (medicalorders.residenceNo!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">房号</h2>
					<blockquote>
						<p>${medicalorders.residenceNo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.sickId!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">病人ID</h2>
					<blockquote>
						<p>${medicalorders.sickId}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.visitNumber!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">住院次数</h2>
					<blockquote>
						<p>${medicalorders.visitNumber}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.sex!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">性别</h2>
					<blockquote>
						<p>${medicalorders.sex}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.admissionTime??)>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">入院时间</h2>
					<blockquote>
						<p>${medicalorders.admissionTime}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.dischargeTime??)>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">出院时间</h2>
					<blockquote>
						<p>${medicalorders.dischargeTime}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.inDept!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">所处科室</h2>
					<blockquote>
						<p>${medicalorders.inDept}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.age!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">年龄</h2>
					<blockquote>
						<p>${medicalorders.age}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.prescribeTxt!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">项目名称</h2>
					<blockquote>
						<p>${medicalorders.prescribeTxt}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.physicSpec!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">物理规格</h2>
					<blockquote>
						<p>${medicalorders.physicSpec}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.startTime??)>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">开始日期</h2>
					<blockquote>
						<p>${medicalorders.startTime}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.stopTime??)>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">结束日期</h2>
					<blockquote>
						<p>${medicalorders.stopTime}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.physicDoseage!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">剂量</h2>
					<blockquote>
						<p>${medicalorders.physicDoseage}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.doseUnit!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">剂量单位</h2>
					<blockquote>
						<p>${medicalorders.doseUnit}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.freqDescribe!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">用药频率</h2>
					<blockquote>
						<p>${medicalorders.freqDescribe}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.freqDuration!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">每次持续时间</h2>
					<blockquote>
						<p>${medicalorders.freqDuration}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.days!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">天数</h2>
					<blockquote>
						<p>${medicalorders.days}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalorders.nowDiagnosis!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">诊断现状</h2>
					<blockquote>
						<p>${medicalorders.nowDiagnosis}</p>
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
