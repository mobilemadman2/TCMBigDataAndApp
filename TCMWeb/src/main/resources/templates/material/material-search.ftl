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
        <h1>中草药</h1>
      </div>
          <div class="row search-box">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入中草药名称或性状" value="${keyword}" id="input-keyword">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="material-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		</div><!-- /.row -->  
		
		
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">甘草&nbsp;&nbsp;五味子&nbsp;&nbsp;人参</p>
		</div>
		
		<br>
       
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

        <div class="col-lg-9 col-lg-offset-1">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='material-data-table show_column-1'>名称</th>
						      <th class='material-data-table show_column-2'>功效</th>
						      <th class='material-data-table show_column-3'>更新时间</th>
						      <th class='material-data-table show_column-4'>操作</th>
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
    <script src="/js/packages/require.js" data-main="/js/material-search"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
