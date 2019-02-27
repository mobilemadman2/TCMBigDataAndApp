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
			<h1>个人中心</h1>
		</div>


		<div class="row">
			<div class="col-lg-3">
				<#include "/user/user-option.ftl" />



			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<div class="row">
					<div class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="原密码">
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="newpassword"
									name="newpassword" placeholder="新密码">
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="confirmpassword" name="confirmpassword"
									placeholder="确认密码" >
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="btn-pass-update" class="btn btn-primary">修改信息</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/packages/require.js" data-main="/js/login"></script>
	<script src="/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/table_utils.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
