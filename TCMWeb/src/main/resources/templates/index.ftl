<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring />
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
  <head>
	<#include "/common/common-head.ftl"/>
  </head>

  <body>
  	<#include "common/nav.ftl" />
  
    <div class="container">
          <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>中医药大数据收集和管理平台</h1>


        <p>汇聚中医数据</p>
<!--         <p>
          <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">按钮</a>
        </p> -->
      </div>

     
<!-- 		 <div class="row search-box"> -->
<!-- 		  <div class="col-lg-10"> -->
<!-- 		    <div class="input-group"> -->
<!-- 		      <input type="text" class="form-control" placeholder="请输入检索词"> -->
<!-- 		      <span class="input-group-btn"> -->
<!-- 		        <button class="btn btn-primary" type="button">查找</button> -->
<!-- 		      </span> -->
<!-- 		    </div>/input-group -->
<!-- 		  </div>/.col-lg-6 -->
<!-- 		</div>/.row -->

      
		 <div class="row search-box">
		  <div class="col-lg-10">
		  <form action="/search/result.html" method="get" onsubmit="return check()">
		    <div class="input-group">
		      <input type="text" class="form-control" placeholder="请输入检索词" id="search-content" name="content">
		      <span class="input-group-btn">
		        <button class="btn btn-primary" onclick="">查找</button>
		      </span>
		    </div>
		    </form>
		  </div>
		</div>
		
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/disease.html"><img src="/pic/disease.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医疾病</span> </a>
							<!--  <span style="position: absolute; top: 0; left: 0;">添加文字...添加文字...添加文字...</span>  --> 
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="disease-recommend"></div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/syndrome.html"><img src="/pic/syndrome.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医证候</span> </a>
							<!--  <span style="position: absolute; top: 0; left: 0;">添加文字...添加文字...添加文字...</span>  --> 
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="syndrome-recommend"></div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/prescription.html"><img src="/pic/fangji.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医方剂</span></a> 
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="prescription-recommend"></div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/material.html"><img src="/pic/medicine.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中草药</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="material-recommend"></div>
				</div>

			</div>

			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/books.html"><img src="/pic/guji.jpeg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医古籍</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="book-recommend">
						<span class="list-item"><a href="/getbook?name=五十二病方">五十二病方</a></span>
						<span class="list-item"><a href="/getbook?name=本草经集注">本草经集注</a></span>
						<span class="list-item"><a href="/getbook?name=伤寒论">伤寒论</a></span>
						<span class="list-item"><a href="/getbook?name=肘后备急方">肘后备急方</a></span>
						<span class="list-item"><a href="/getbook?name=医心方">医心方</a></span>
						<span class="list-item"><a href="/getbook?name=饮膳正要">饮膳正要</a></span>
						<span class="list-item"><a href="/getbook?name=滇南本草">滇南本草</a></span>
						<span class="list-item"><a href="/getbook?name=景岳全书">景岳全书</a></span>
						<span class="list-item"><a href="/getbook?name=诊家正眼">诊家正眼</a></span>
						<span class="list-item"><a href="/getbook?name=回春录">回春录</a></span>
					</div>
				</div>

			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/medicalcase.html"><img src="/pic/yian.jpeg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医医案</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="yian-recommend"></div>
				</div>

			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/expert.html"><img src="/pic/mingjia.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">中医名家</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="celebrity-recommend"></div>
				</div>

			</div>
			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/image.html"><img src="/pic/image.jpeg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">医疗影像</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="image-recommend">
						<span class="list-item"><a href="/getImageList?disease_class=乳腺癌&image_class=病理切片">乳腺癌病理切片</a></span>
						<span class="list-item"><a href="#">影像2</a></span>
						<span class="list-item"><a href="#">影像3</a></span>
						<span class="list-item"><a href="#">影像4</a></span>
						<span class="list-item"><a href="#">影像5</a></span>
						<span class="list-item"><a href="#">影像6</a></span>
						<span class="list-item"><a href="#">影像7</a></span>
						<span class="list-item"><a href="#">影像8</a></span>
						<span class="list-item"><a href="#">影像9</a></span>
						<span class="list-item"><a href="#">影像10</a></span>
					</div>
				</div>

			</div>
			

			
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="col-sm-2 col-md-2">
						<a href="/acupoint.html"><img src="/pic/xuewei.jpg" alt="..."
							class="carousel-inner img-responsive img-rounded index-image">
							<span style="top: 0; left: 50px;text-align: center;display:block;">人体穴位</span></a>
					</div>
					<div class="col-sm-9 col-md-9 list-margin" id="xuewei-recommend">
					<span class="list-item"><a href="#">合谷穴</a></span>
					<span class="list-item"><a href="#">少商穴</a></span>
					<span class="list-item"><a href="#">神门穴</a></span>
					<span class="list-item"><a href="#">内关穴</a></span>
					<span class="list-item"><a href="#">后溪穴</a></span>
					<span class="list-item"><a href="#">膻中穴</a></span>
					<span class="list-item"><a href="#">中脘穴</a></span>
					<span class="list-item"><a href="#">足三里穴</a></span>
					<span class="list-item"><a href="#">阳陵泉穴</a></span>
					<span class="list-item"><a href="#">太冲穴</a></span>
					</div>
				</div>
			</div>
			
<!-- 			<div class="panel panel-default"> -->
<!-- 				<div class="panel-body"> -->
<!-- 					<div class="col-sm-2 col-md-2"> -->
<!-- 						<a href="#"><img src="/pic/guanjie.jpeg" alt="..." -->
<!-- 							class="carousel-inner img-responsive img-rounded index-image"> -->
<!-- 							<span style="top: 0; left: 50px;text-align: center;display:block;">人体关节</span></a> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-9 col-md-9 list-margin" id="guanjie-recommend"> -->
<!-- 						<span class="list-item"><a href="#">肩关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">肘关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">桡腕关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">腕掌关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">髋关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">膝关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">踝关节</a></span> -->
<!-- 						<span class="list-item"><a href="#">躯干骨</a></span> -->
<!-- 						<span class="list-item"><a href="#">肋骨</a></span> -->
<!-- 						<span class="list-item"><a href="#">胸骨</a></span> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
		</div><!-- /.row -->
      
    </div> <!-- /container -->

    <footer class="footer">
      <div class="container">
<!--         <p class="text-muted">©2018 软件研究所</p> -->
        <div class="col-sm-3 col-md-3 col-sm-offset-1 col-md-offset-1"><img src="/pic/caslogo.png" class="carousel-inner img-responsive img-rounded"></div>
        <div class="col-sm-7 col-md-7">
        <div class="left">Copyright © Institute of Software, CAS. All rights reserved.info(at)iscas.ac.cn
        <br>版权所有 © 中国科学院软件研究所　京ICP备XXXXXXXX号　文保网安备XXXXXXXXXX
        <br>电话：86-10-62661012　传真：86-10-62562533　电子邮箱：info@iscas.ac.cn</div>
        </div>
      </div>
    </footer>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="/js/packages/require.js" data-main="/js/index"></script>
    <script type="text/javascript" src="/js/table_utils.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
  
  <script>
  function check(){
	   val = $('#search-content').val().trim()
	   console.log(val)
	   if(val ==  null || val == ''){
	        alert("查找内容不能为空");
	        return false;
	   }
	   return true;
	}
  </script>
</html>
