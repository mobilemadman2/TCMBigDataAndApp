<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<!DOCTYPE html>

  <head>
<!--       <meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_header" th:content="${_csrf.headerName}"/> -->
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
    

<form role="form" action="login" method="post">
    <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" class="form-control" id="username" name="username"/>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password"/>
    </div>
    <!-- <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
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

   
