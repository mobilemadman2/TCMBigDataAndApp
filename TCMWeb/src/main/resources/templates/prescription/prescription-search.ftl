<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>中医大数据</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/navbar-fixed-top.css" rel="stylesheet">
    
    <link href="/disease-homepage.css" rel="stylesheet">
  </head>

  <body>
  	<#include "/common/nav.ftl" />
    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医方剂信息</h1>
      </div>
      
		 <div class="row search-box">
		 <form action="/prescription-search.html" method="post">
		  <div class="col-lg-10">
		    <div class="input-group">
		      <input type="text" class="form-control" name="keywords" placeholder="请输入方剂名称或出处"  id="input-keyword" value="${keyword}">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" type="submit" id="prescription-search">查找</button>
		      </span>
		    </div><!-- /input-group -->
		  </div><!-- /.col-lg-6 -->
		  </form>
		</div><!-- /.row -->
		
		
		<div style="margin-top:-2.7%;margin-left:3%">
			<p style="display:inline-block"> 推荐:  </p>
			<p style="color:rgb(51,122,183);display:inline-block;margin-left:10px">半夏汤&nbsp;&nbsp;竹叶汤&nbsp;&nbsp;牡蛎散</p>
		</div>
		
		<br>
		
		
		<div class="row">
        <div class="col-lg-9 col-lg-offset-1">
          <div class="row">
					<div class = "search-all">
					
						<table id="table" class="table">
						  <thead>
						    <tr>
						      <!-- <th></th> -->
						      <th class='patent-data-table show_column-1'>名称</th>
						      <th class='patent-data-table show_column-2'>出处</th>
						      <th class='patent-data-table show_column-3'>更新时间</th>
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
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <script src="/js/packages/require.js" data-main="/js/prescription-search"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
