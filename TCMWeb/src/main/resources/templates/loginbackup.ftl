<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<!DOCTYPE html>
  <head>
    <#include "/common/common-head.ftl"/>
    
<link rel="stylesheet" href="site-template/css/default.min.css?t=227" />
    <!-- <link href="dashboard.css" rel="stylesheet"> -->
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

  </head>

  <body>

   <#include "common/nav.ftl"/>

    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
		
		<div class="row">
     <div class="user">
         <div class="cgs">
             <div class="am-u-sm-12 am-u-md-12 am-u-lg-7">
                 <div class="user-div">
                     <h1>用户登录</h1>
                     <ul>
                         <li><i>&#xe681;</i><input type="text" id="account" name="account" value="" placeholder="请输入用户名/邮箱" /></li>
                         <li><i>&#xe680;</i><input type="password" id="password" name="password" value="" placeholder="请输入密码" /></li>
                     </ul>
                     <span><a href="#">忘记密码?</a></span>  
                     <button id="btn-login"> 登录</button>
                 </div>
             </div>
             <div class="am-hide-sm am-hide-md am-u-lg-5">
                 <div class="user-right">
                     <a href="#">还没有帐号</a>
                     <button>立即注册</button>
                 </div>
             </div>
         </div>
     </div>


      </div>
      <a th:href="@{http://www.baidu.com}">百度</a>
      <!-- /.row -->

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js" ></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/js/packages/require.js" data-main="/js/login" type="text/javascript"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>

   
