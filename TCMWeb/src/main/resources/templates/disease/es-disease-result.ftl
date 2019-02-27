<!DOCTYPE html>
<html lang="en">
  <head>
	<#include "/common/common-head.ftl"/>
	<link href="/glb-search.css" rel="stylesheet">
	<link href="/ng-pagination.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />    

	<#assign search_classify = "disease"/>
    <#assign multiTag = "row-disable"/>
    <#assign searchName = "疾病查询"/>
	<#include "/search/search-common.ftl"/>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    
    <script src="/bootstrap/js/bootstrap.min.js"></script>

  </body>
</html>
