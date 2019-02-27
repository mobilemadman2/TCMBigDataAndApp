<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring />
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
    <div> &nbsp;&nbsp;</div>
    <div class="blog-header">
    <h1 class="blog-title">中医智能诊断服务平台</h1>
    <@security.authorize access="hasRole('USER')">
         ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username!'xxx'}
        ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.password!'xxx'}
</@security.authorize>
    <@security.authorize access="isAuthenticated()">
     
</@security.authorize>

    </div>
    <div> &nbsp;&nbsp;</div>
<form role="form" action="login" method="post">
    <div class="form-group">
        <label for="username">用户名:</label>
        <input type="text" class="form-control" id="username" name="username"/>
    </div>
    <div class="form-group">
        <label for="password">密码:</label>
        <input type="password" class="form-control" id="password" name="password"/>
    </div>
    <button type="submit" class="btn btn-primary">登陆</button>
</form>
      </div>
       <#if logout??>   <p th:if="${logout}" class="bg-warning">已注销</p></#if>
        <#if error??>  <p th:if="${error}" class="bg-danger">有错误，请重试</p></#if>
        
     
      <!-- /.row  <a th:href="@{http://www.baidu.com}">百度</a>-->

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

   
