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
		<#assign nav_name = ["中医标准", "${standard.secondIndex}", "${standard.standardNumber}"]>
   		<#assign nav_href = ["/standard_home.html", "/getStantardList?first_index=${standard.firstIndex}&second_index=${standard.secondIndex}","#"]>
   		<#include "/common/nav-pos.ftl"/>
		<div class="blog-header">
			<h2>${standard.standardName}</h2> 
		</div>
		
		<div class="row">
			<div class="col-sm-8 blog-main">
				<table class="v" >
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">英文名称：</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="col-xs-16">
								<#if (standard.englishName!"") !="">      ${standard.englishName}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">内容简介：</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="col-xs-16">
								<#if (standard.briefIntroduction!"") !="">      ${standard.briefIntroduction}</#if>
							</div>
						</td>
					</tr>													     	
				</table>
				<table class="v" >
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">标准编号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.standardNumber!"") !="">${standard.standardNumber}</#if>
							</div>
						</td>
					</tr>					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">标准ICS号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.InternationalTypeIcs!"") !="">${standard.InternationalTypeIcs}</#if>
							</div>
						</td>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">中标分类号：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.chinaTypeCcs!"") !="">${standard.chinaTypeCcs}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td> 
							<div class="col-xs-16" style="color:#708090">标准状态：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.standardStatus!"") !="">${standard.standardStatus}</#if>
							</div>
						</td>
						<td> 
							<div class="col-xs-16" style="color:#708090">起草日期：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.draftingDate??)>${standard.draftingDate}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td> 
							<div class="col-xs-16" style="color:#708090">发布日期：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.releaseDate??)>${standard.releaseDate}</#if>
							</div>
						</td>
						<td> 
							<div class="col-xs-16" style="color:#708090">实施日期：</div>
						</td>
						<td>
							<div class="col-xs-16">
								<#if (standard.implementationDate??)>${standard.implementationDate}</#if>
							</div>
						</td>
					</tr>
											     	
				</table>
				
				
				<table class="v" >
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">起草单位：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.draftingUnit!"") !="">${standard.draftingUnit}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">起草人：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.draftingPeople!"") !="">${standard.draftingPeople}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">归口单位：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.technicalCommittees!"") !="">${standard.technicalCommittees}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">主管单位：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.competentUnit!"") !="">${standard.competentUnit}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">发布部门：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.competentUnit!"") !="">${standard.competentUnit}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">替代状态：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.replaceStatus!"") !="">${standard.replaceStatus}</#if>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>			
							<div id="targetname" class="col-xs-16" style="color:#708090">页数：</div>
						</td>
						
						<td>
							<div class="col-xs-16">
								<#if (standard.pageCount!"") !="">${standard.pageCount}</#if>
							</div>
						</td>
					</tr>												     	
				</table>
		    </div>
    	</div>
		
		<p></p>
		<div class="row">
			<div class="col-sm-8 blog-main">
				 <form action="/standard_pdf.html" method="get">
					  
					  		<span class="right">
						      	<#if (standard.filePath!"") !="">
									<button name="file_path" value="${standard.filePath }" class="btn btn-primary" type="submit" >查看文件</button>
								<#else>
									<button name="file_path" value="${standard.filePath }" class="btn btn-primary" type="submit"  disabled="disabled">暂无文件</button>
								</#if>	
							</span>			        		
				</form>
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