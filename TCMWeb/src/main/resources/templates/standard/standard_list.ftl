<!DOCTYPE html>
<html lang="en">
	<head>
    	<#include "/common/common-head.ftl"/>
    	<link href="/standard.css" rel="stylesheet">
  	</head>

  	<body>
		<#include "/common/nav.ftl" />
    	<div class="container">
    		<#assign nav_name = ["中医标准", "${second_index}"]>
    		<#assign nav_href = ["/standard_home.html", "/getStantardList?first_index=${first_index}&second_index=${second_index}"]>
    		<#include "/common/nav-pos.ftl"/>
    		
	      	<div class="jumbotron">
	        	<h1>${second_index}</h1>
	      	</div>	

	        
			<div class="row">
				<div class="col-lg-1">
		        </div>
        		<div class="col-lg-10">
          			<div class="row">
						<div class = "search-all" >
							<table id="table" class="table" >
								  <thead>
									    <tr>
										      <!-- <th></th> -->
										      <th class='patent-data-table show_column-1'>标准编号</th>
										      <th class='patent-data-table show_column-2'>标准名称</th>
										      <th class='patent-data-table show_column-3'>发布部门</th>
										      <th class='patent-data-table show_column-4'>操作</th>
									    </tr>
								  </thead>
							  	  <tbody id="table-all">
							  	  </tbody>
							</table>
							<div id="page-show" class='paginator'>
				          		<div id="page_all" class="pagination"></div>
				        	</div>
		            	</div>
          			</div>
        		</div>
      		</div>
    	</div> <!-- /container -->

		<div style="display:none">
			<span id="page-number-id">${pageNumber}</span>
			<span id="page-size-id">${pageSize}</span>
			<span id="sort-type">${sortType}</span>
		</div>
	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    
	    <script src="/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/table_utils.js"></script>
	    <script src="/js/packages/require.js" data-main="/js/standard_list"></script>
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  	</body>
</html>
