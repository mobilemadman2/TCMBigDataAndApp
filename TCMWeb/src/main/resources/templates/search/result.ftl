<!DOCTYPE html>
<html lang="en">
  <head>
	<#include "/common/common-head.ftl"/>
	<link href="/glb-search.css" rel="stylesheet">
	<link href="/ng-pagination.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />    

	<!-- Search module -->
	<#assign search_classify = "all"/>
    <#assign multiTag = ""/>
    <#assign searchName = "中医智能诊断服务平台"/>
	<#include "/search/search-common.ftl"/>
	<!-- Search module end-->
	
	
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
    <script src="/bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
