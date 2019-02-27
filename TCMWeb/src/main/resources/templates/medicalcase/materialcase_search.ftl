<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/medical-case/medical-case-main.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医医案信息</h1>
<!--         <p>To see the difference between static and fixed top navbars, just scroll.</p> -->      
	</div>
      
		 <div class="row search-box">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入穴位名称或概要" id="input-keyword" value="${keyword}">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="disease-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
		
		
		<div class="row">
        <!-- /.col-lg-3 -->

        <div class="col-lg-9 col-lg-offset-1">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr id="table-header">
						      <!-- <th></th> -->
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
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->
    </div> <!-- /container -->

	<div style="display:none">
		<span id="page-number-id">${pageNumber}</span>
		<span id="page-size-id">${pageSize}</span>
	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/packages/require.js" data-main="/js/materialcase-research"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
