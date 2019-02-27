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
        <h1>中医名家论文信息</h1>
      </div>
      <input style="display:none" type="text" id="input-keyword" value="${keyword}">
      <div class="title">
			<table>
				<tr>
					<th style="width:10%;font-size:120%;">作者:</th>
					<th style="width:30%;font-size:120%;">${keyword}</th>
					<th style="width:10%;font-size:120%;">单位:</th>
					<th style="font-size:120%;">${institution}<br></th>
				</tr>
			</table>
			
			<div>
			<br>
			<p style="font-size:120%;font-weight:bold;">查询结果：</p>
			</div>
		</div>
		
		<div class="row">

        <div class="col-lg-9 col-lg-offset-1">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='paper-data-table show_column-1'>名称</th>
						      <th class='paper-data-table show_column-2'>摘要</th>
						      <th class='paper-data-table show_column-3'>更新时间</th>
						      <th class='paper-data-table show_column-4'>操作</th>
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
    <script src="/js/packages/require.js" data-main="/js/search_info_doctor"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
