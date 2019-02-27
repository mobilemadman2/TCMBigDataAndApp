<div class="container">
	<div class="blog-header">
		<h1 class="blog-title">${disease.name}</h1>
		<p class="lead blog-description">The official example template of
			creating a blog with Bootstrap.</p>
		<nav>
			<ul class="pager">
				<li><a 
					href="/${Session["from"]}.html?pageNumber=${pageNumber}&pageSize=${pageSize}">返回</a></li>
				<li><a href="#">Next</a></li>
			</ul>
		</nav>
	</div>
	<div class="row">
		<div class="col-sm-8 blog-main">
			<#if (disease.overview!"") !="None">
			<div class="blog-post" id="id-overview">
				<h2 class="blog-post-title">概述</h2>
				<blockquote>
					<p>${disease.overview}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			
			
			<#if bingzheng??>
			<div class="blog-post" id="id-etpa">
				<h2 class="blog-post-title">辨证论治</h2>
				<blockquote>
				<#list bingzheng as bz>
					<p class="bingzheng-name">&bull; &nbsp;${bz.name}</p>
					<#if (bz.zhenghou!"") !="None">
						<p>证候：<span>${bz.zhenghou}</span></p>
					</#if>
					<#if (bz.zhifa!"") !="None">
						<p>治法：<span>${bz.zhifa}</span></p>
					</#if>
					<#if (bz.zhufang!"") !="None">
						<p>主方：<span>${bz.zhufang}</span></p>
					</#if>
					<#if (bz.jiajian!"") !="None">
						<p>加减：<span>${bz.jiajian}</span></p>
					</#if>
				</#list>
				</blockquote>
				
			</div>
			<!-- /.blog-post --> </#if>
			
			
			<#if (disease.etPa!"") !="None">
			<div class="blog-post" id="id-etpa">
				<h2 class="blog-post-title">病因病机</h2>
				<blockquote>
					<p>${disease.etPa}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.clma!"") !="None">
			<div class="blog-post" id="id-clma">
				<h2 class="blog-post-title">临床表现</h2>
					<blockquote>
					<p>${disease.clma}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.examination!"") !="None">
			<div class="blog-post" id="id-examination">
				<h2 class="blog-post-title">实验室辅助检查</h2>
				<blockquote>
					<p>${disease.examination}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
				<#if (disease.esdi!"") !="None">
			<div class="blog-post" id="id-esdi">
				<h2 class="blog-post-title">诊断要点</h2>
				<blockquote>
					<p>${disease.esdi}</p>
				</blockquote>
			</div>
			<!-- /.blog-post --> </#if>
			<#if (disease.didi!"") !="None">
			<div class="blog-post" id="id-didi">
				<h2 class="blog-post-title">鉴别诊断</h2>
				<blockquote>
					<p>${disease.didi}</p>
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