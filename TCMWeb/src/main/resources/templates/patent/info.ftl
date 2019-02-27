<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/info-page.css" rel="stylesheet">
	<link href="/entity-annotation.css" rel="stylesheet">
</head>

<body>
	<#include "/common/nav.ftl">
	<style> 
		.v {border-collapse: seperate;} 
		.v td{ border: none; border-bottom: dashed 1px #ddd; padding:5px;} 
	</style> 
	<div class="container">
		<#assign nav_name = ["中医专利", "${patent.pn}"]>
   		<#assign nav_href = ["/patent.html", "#"]>
   		<#include "/common/nav-pos.ftl"/>
		<div class="blog-header">
			<h2>${patent.ti}</h2> 
		</div>
		
		<div class="row">
			<div class="col-sm-8 blog-main">
				<h3>基本信息</h3>
				<table class="v" >

					<tr>				
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">专利类型：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.kc!"") !="">${patent.kc}</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">公开号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.pn!"") !="">${patent.pn}</#if>
							</div>
						</td>					
					</tr>									
					<tr>
						<td >			
							<div id="targetname" class="col-xs-16" style="color:#708090">发明人：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.cinr!"") !="">${patent.cinr}</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">申请号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.an!"") !="">${patent.an}</#if>
							</div>
						</td>
					
											
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">申请日：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.ad!"") !="">${patent.ad}</#if>
							</div>
						</td>					
					</tr>

					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">申请人：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.cpa!"") !="">${patent.cpa}</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">地址：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.caddr!"") !="">${patent.caddr}</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">国际分类号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.ic!"") !="">${patent.ic}</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td nowrap="nowrap">			
							<div id="targetname" class="col-xs-16" style="color:#708090">药物登记号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.rn!"") !="">${patent.rn}</#if>
							</div>
						</td>					
					</tr>
					
					<tr>
						<td nowrap="nowrap">			
							<div id="targetname" class="col-xs-16" style="color:#708090">治疗作用：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.ceff!"") !="">${patent.ceff}
								 <#else>无
								</#if>
							</div>
						</td>					
					</tr>
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">主题词：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.it!"") !="">${patent.it}</#if>
							</div>
						</td>					
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">方剂：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.formula!"") !="">${patent.formula}
								<#else>无
								</#if>
							</div>
						</td>					
					</tr>
					
											
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">摘要：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (patent.ab!"") !="">${patent.ab}</#if>
							</div>
						</td>					
					</tr>
					   	
				</table>
				<p></p>

				
		    </div>
    	</div>
	</div>
	
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>