<!DOCTYPE html>
<html lang="en">
  <head>
    <#include "/common/common-head.ftl"/>
    <link href="/disease-homepage.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>诊断</h1>
        <p>To see the difference between static and fixed top navbars, just scroll.</p>
      </div>
      
<!-- 		 <div class="row search-box"> -->
<!-- 		  <div class="col-lg-8"> -->
<!-- 		    <div class="input-group"> -->
<!-- 		      <input type="text" class="form-control" placeholder="请输入检索词"> -->
<!-- 		      <span class="input-group-btn"> -->
<!-- 		        <button class="btn btn-primary" type="button">查找</button> -->
<!-- 		      </span> -->
<!-- 		    </div>/input-group -->
<!-- 		  </div>/.col-lg-6 -->
<!-- 		</div>/.row -->
		
		
		<div class="row">
        <div class="col-lg-3">

          <h1 class="my-4">分类</h1>
          <div class="list-group">
            <a href="#" class="list-group-item">分类 1</a>
            <a href="#" class="list-group-item">分类 2</a>
            <a href="#" class="list-group-item">分类 3</a>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='diagnosis-data-table show_column-1'>病人ID</th>
						      <th class='diagnosis-data-table show_column-2'>诊断名称</th>
						      <th class='diagnosis-data-table show_column-3'>更新时间</th>
						      <th class='diagnosis-data-table show_column-4'>操作</th>
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

	<div style="display:none"><span id="page-number-id">${pageNumber}</span><span id="page-size-id">${pageSize}</span></div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/packages/require.js" data-main="/js/diagnosis"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
