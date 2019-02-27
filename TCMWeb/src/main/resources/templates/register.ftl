<!DOCTYPE html>
<html lang="en">
  <head>
   	<#include "/common/common-head.ftl"/>
<link rel="stylesheet" href="/site-template/css/default.min.css?t=227" />
    <!-- <link href="dashboard.css" rel="stylesheet"> -->
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <#include "common/nav.ftl"/>

    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
         <div class="row">
         <div class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="password" name="password" placeholder="密码">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="密码">
    </div>
  </div>
  
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">手机</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="mobile" name="mobile" placeholder="手机">
    </div>
  </div>
  
      <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <span><input type="checkbox"/> 我已阅读并接受<a href="#">版权说明和隐私保护条款</a></span>
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button id="btn-reg" class="btn btn-primary">注册</button>
    </div>
  </div>
   
</div>
         </div>


    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/packages/require.js" data-main="/js/login"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>