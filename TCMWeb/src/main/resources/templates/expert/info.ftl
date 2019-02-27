<!DOCTYPE html>
<html lang="en">
<head>
  <#include "/common/common-head.ftl"/>
</head>

<body>
<style> 
.v {border-collapse: seperate;} 
.v td{ border: none; border-bottom: dashed 1px #ddd; padding:5px;} 
</style>
	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
	
	<div class="container">
	    <#assign nav_name = ["中医名家","${expert.name}"]>
    	<#assign nav_href = ["/expert.html", "/expert/info.html?expertId=${expert.id?c}"]>
    	<#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">${expert.name}</h1>
			<!-- <p class="lead blog-description">The official example template of
				creating a blog with Bootstrap.</p> -->

		</div>

		<div class="row">
			<div class="col-sm-8 blog-main">
			<!--<#if (expert.id!"") !=0>
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">编号</h2>
					<blockquote>
						<p>${expert.id}</p>
					</blockquote>
				</div></#if><#if (expert.name!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">姓名</h2>
					<blockquote>
						<p>${expert.name}</p>
					</blockquote>
				</div></#if> -->
			<table class="v" >
		<tr>
		<td>

		<div id="targetname" class="col-xs-16" style="color:#708090">性别：</div></td><td><div class="col-xs-16"><#if (expert.sex!"") !="">${expert.sex}

		 </#if></div>
				
				<!-- /.blog-post --></td>
				<td> 
				
					<div class="col-xs-16" style="color:#708090">民族：</div></td><td><div class="col-xs-16"><#if (expert.ethnic!"") !="">${expert.ethnic} </#if></div>
			
				<!-- /.blog-post -->
				</td>
		</tr>
		
		<tr>
		<td> 
					<div class="col-xs-16" style="color:#708090">出生年月：</div></td><td><div class="col-xs-16"><#if (expert.birthday!"") !="">${expert.birthday}</#if></div>
				
				<!-- /.blog-post --> </td>
		<td> 
					<div class="col-xs-16" style="color:#708090">政治面貌：</div></td><td><div class="col-xs-16"><#if (expert.party!"") !="">${expert.party}</#if></div>
				
				<!-- /.blog-post --> </td>
        </tr>
        
        
       
        <tr>
		<td> 
				<div class="col-xs-16" style="color:#708090">职称：</div></td><td><div class="col-xs-16"> <#if (expert.position!"") !="">${expert.position}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>
        

     </table>	
				
	<table id="showDetail">

 </table>			
				
			<#if (expert.courtesyname!"") !="">
				<div class="blog-post" id="courtesyname">
					<h2 class="blog-post-title">字</h2>
					<blockquote>
						<p>${expert.courtesyname}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.pseudonym!"") !="">
				<div class="blog-post" id="pseudonym">
					<h2 class="blog-post-title">号</h2>
					<blockquote>
						<p>${expert.pseudonym}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.alias!"") !="">
				<div class="blog-post" id="alias">
					<h2 class="blog-post-title">别名</h2>
					<blockquote>
						<p>${expert.alias}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<!--<#if (expert.sex!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">性别</h2>
					<blockquote>
						<p>${expert.sex}</p>
					</blockquote>
				</div>
				  </#if>-->
				<#if (expert.dynasty!"") !="">
				<div class="blog-post" id="dynasty">
					<h2 class="blog-post-title">朝代</h2>
					<blockquote>
						<p>${expert.dynasty}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<!--<#if (expert.ethnic!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">民族</h2>
					<blockquote>
						<p>${expert.ethnic}</p>
					</blockquote>
				</div>
				 </#if>-->
				<!--<#if (expert.birthday!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">出生年月</h2>
					<blockquote>
						<p>${expert.birthday}</p>
					</blockquote>
				</div>
				  </#if>-->
				<#if (expert.endtime!"") !="">
				<div class="blog-post" id="endtime">
					<h2 class="blog-post-title">结束年月</h2>
					<blockquote>
						<p>${expert.endtime}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
			<!--	<#if (expert.party!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">政治面貌</h2>
					<blockquote>
						<p>${expert.party}</p>
					</blockquote>
				</div>
				 </#if>-->
				<#if (expert.work!"") !="">
				<div class="blog-post" id="work">
					<h2 class="blog-post-title">单位</h2>
					<blockquote>
						<p>${expert.work}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<!--<#if (expert.position!"") !="">
				<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">职称</h2>
					<blockquote>
						<p>${expert.position}</p>
					</blockquote>
				</div>
				   </#if>-->
				<#if (expert.department!"") !="">
				<div class="blog-post" id="department">
					<h2 class="blog-post-title">科室</h2>
					<blockquote>
						<p>${expert.department}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.status!"") !="">
				<div class="blog-post" id="status">
					<h2 class="blog-post-title">从业情况</h2>
					<blockquote>
						<p>${expert.status}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.book!"") !="">
				<div class="blog-post" id="book">
					<h2 class="blog-post-title">著作</h2>
					<blockquote>
						<p>${expert.book}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
					<!--<#if (expert.paper!"") !="">
				<div class="blog-post" id="paper">
					<h2 class="blog-post-title">论文</h2>
					<blockquote>
						<p>${expert.paper}</p>
					</blockquote>
				</div>
			 /.blog-post </#if> -->
			 
			 <#if expertPaper?? && (expertPaper?size>0) >
				<div class="blog-post" id="paper">
					<h2 class="blog-post-title">论文</h2>
					<blockquote>
					<#list expertPaper as ep>
					<#if ep_index<=5>
						<p >
						   &bull; &nbsp;<a href="/paper/info.html?paperId=${ep.id?string('0')}"> ${ep.paper_name}. </a>  	
							</#if>			
						</p>
					</#list>
					<#if (expert.work!"") !=""> 
					  &bull; &nbsp;<a href="/paper/search_info_doctor?keywords=${expert.name}&institution=${expert.work}">更多... </a>
					  <#else> 
					  &bull; &nbsp; <a href="/paper/search_info_doctor?keywords=${expert.name}&institution=">更多... </a>
					  </#if>
					</blockquote>
					
				</div>
				<!-- /.blog-post --> </#if>
				
				<#if (expert.patent!"") !="">
				<div class="blog-post" id="patent">
					<h2 class="blog-post-title">专利</h2>
					<blockquote>
						<p>${expert.patent}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				

				
				
				<!-- <#if (expert.medicalcase!"") !="">
				<div class="blog-post" id="medicalcase">
					<h2 class="blog-post-title">医案</h2>
					<blockquote>
						<p>${expert.medicalcase}</p>
					</blockquote>
				</div>
				 </#if>-->
				                  <#--  &bull; &nbsp;<a href="#" onclick="getPaperId(${ep.id})" id="Go"> ${ep.paperName}. </a>  -->
				<#if expertMedicalCase?? && (expertMedicalCase?size>0) >
				<div class="blog-post" id="medicalcase">
					<h2 class="blog-post-title">医案</h2>
					<blockquote>
					<#list expertMedicalCase as em>
					<#if em_index<=5>
						<p >
					 &bull; &nbsp;
						<#if (expert.name!"") !=" ">${expert.name}医案： </#if> 
						 <a href="/medicalcase/info.html?materialcaseId=${em.id?string('0')}">  <#if (em.tcm_diagnosis!"") !=" ">中医治疗${em.tcm_diagnosis} </#if> </a>
						 &nbsp;&nbsp;&nbsp;   患者：
						 	<#if (em.patient_name!"") !=" ">${em.patient_name} </#if>
						 	<#if (em.gender!"") !=" ">${em.gender} </#if>
						 	<#if (em.birth_day!"") !=" ">${em.treatment_time?substring(0,4)?number-em.birth_day?substring(0,4)?number}岁 </#if>
						</#if>
									
						</p>
					</#list>
					<!-- &bull; &nbsp; <a href="/medical-case/search_info_doctor?keywords=${expert.name}">更多... </a> -->
					<#if (expert.work!"") !=""> 
					&bull; &nbsp; <a href="/medical-case/info_doctor?keywords=${expert.name}&institution=${expert.work}">更多... </a>
					  <#else> 
					  &bull; &nbsp; <a href="/medical-case/info_doctor?keywords=${expert.name}&institution=">更多... </a>
					  </#if>
					

					</blockquote>
					
				</div>
				<!-- /.blog-post --> </#if>
				
				
				
				<#if (expert.prescription!"") !="">
				<div class="blog-post" id="prescription">
					<h2 class="blog-post-title">代表性方剂</h2>
					<blockquote>
						<p>${expert.prescription}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.honor!"") !="">
				<div class="blog-post" id="honor">
					<h2 class="blog-post-title">荣誉</h2>
					<blockquote>
						<p>${expert.honor}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.flag!"") !="">
				<!--<div class="blog-post" id="id-overview">
					<h2 class="blog-post-title">标志位</h2>
					<blockquote>
						<p>${expert.flag}</p>
					</blockquote>
				</div>-->
				<!-- /.blog-post --> </#if><#if (expert.photo!"") !="">
				<div class="blog-post" id="photo">
					<h2 class="blog-post-title">照片</h2>
					<blockquote>
						<p>${expert.photo}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (expert.note!"") !="">
				<div class="blog-post" id="note">
					<h2 class="blog-post-title">备注</h2>
					<blockquote>
						<p>${expert.note}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				

			</div>
			<!-- /.blog-main -->

			<!--<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>
						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
						mattis consectetur purus sit amet fermentum. Aenean lacinia
						bibendum nulla sed consectetur.
					</p>
				</div>
				<div class="sidebar-module">
					<h4>Archives</h4>
					<ol class="list-unstyled">
						<li><a href="#">March 2014</a></li>
						<li><a href="#">February 2014</a></li>
						<li><a href="#">January 2014</a></li>
						<li><a href="#">December 2013</a></li>
						<li><a href="#">November 2013</a></li>
						<li><a href="#">October 2013</a></li>
						<li><a href="#">September 2013</a></li>
						<li><a href="#">August 2013</a></li>
						<li><a href="#">July 2013</a></li>
						<li><a href="#">June 2013</a></li>
						<li><a href="#">May 2013</a></li>
						<li><a href="#">April 2013</a></li>
					</ol>
				</div>
				<div class="sidebar-module">
					<h4>Elsewhere</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
					</ol>
				</div>
			</div>-->
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>



   
	<script>
	function getPaperId(id){
		console.log(id)
		url_check = "/expert/get_paper_id?expertPaperId="+id
		$.ajax({
			method: "GET",
			url:url_check, 
			dataType:"text",
			success:function(data)
			{
				console.log("check successs!")
				console.log(data)
				if(data !=-1){
					//修改为可点击的
					console.log("ddd")
					url_doctor_detail = "/paper/info.html?paperId="+data;
					$("#Go").attr("href",url_doctor_detail);
				}
				else{
					//设置不可点击,去掉<a>标签
					$("#Go").contents().unwrap();
					alert("暂无数据")
				}
			},
			fail:function(data){
				console.log("check failde|||")
			}
		});
    }
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}
</script>
	<script type="text/javascript">

 var expert_id='${expert.id}';
 var arrayObj = new Array();
 var showItemList = new Array();
 var showItemListEn = new Array();
 
 if('${(expert.courtesyname)!}'!=""){ showItemList.push("字"); showItemListEn.push("courtesyname");}

if('${(expert.pseudonym)!}'!=""){ showItemList.push("号"); showItemListEn.push("pseudonym");}
if('${(material.id)!}'!=""){ showItemList.push("荣誉"); showItemListEn.push("honor");}

if(('${(expert.pseudonym)!}') !=""){ showItemList.push("号"); showItemListEn.push("pseudonym");}
if(('${(expert.alias)!}') !=""){ showItemList.push("别名"); showItemListEn.push("alias");}
if('${(expert.dynasty)!}'!=""){ showItemList.push("朝代"); showItemListEn.push("dynasty");}
if('${(expert.endtime)!}'!=""){ showItemList.push("结束年月"); showItemListEn.push("endtime");}
 if('${(expert.work)!}'!=""){ showItemList.push("单位"); showItemListEn.push("work");}
if('${(expert.department)!}'!=""){ showItemList.push("科室"); showItemListEn.push("department");}
 if('${(expert.status)!}'!=""){ showItemList.push("从业情况"); showItemListEn.push("status");}
if('${(expert.book)!}'!=""){ showItemList.push("著作"); showItemListEn.push("book");}
if('${expertMedicalCase?size}'>0){ showItemList.push("医案"); showItemListEn.push("medicalcase");}

if('${(expert.patent)!}'!=""){ showItemList.push("专利"); showItemListEn.push("patent");}

if('${expertPaper?size}'>0){ showItemList.push("论文"); showItemListEn.push("paper");}

if('${(expert.prescription)!}'!=""){ showItemList.push("代表性方剂"); showItemListEn.push("prescription");}
if('${(expert.honor)!}'!=""){ showItemList.push("荣誉"); showItemListEn.push("honor");}
var tmp=0;
var div1 = document.getElementById('showDetail');
 var code = '';
 var max = 3;
 var SDROW1 = '<TR><TD><h1><b>目录</b></h1></TD>';
 var SDROW2 = '<TR><TD></TD>';
 var SDROW3 = '<TR><TD></TD>';
 var SDROW4 = '<TR><TD></TD>';
 var SDROW5 = '<TR><TD></TD>';
 var SDROW6 = '<TR><TD></TD>';
 var indexList = new Array();
/* for(var k=1;k<=max;k++){
     eval("indexList.push(SDROW"+k+")");
     alert(indexList[k-1])
 }*/
 
for(var i = 0,len=showItemList.length;i<len;i++){

    //tmp++;
    index=i%max+1;
    num=i+1;

   itemtmp="<TD id=\""+showItemList[i]+"\" onclick=\"scrollToDiv(\'"+showItemListEn[i]+"\')\"><blockquote>"+num+" "+showItemList[i]+"</blockquote></TD>";

   //alert(itemtmp);
   //alert(SDROW1+=itemtmp)
   //alert(index);
    eval("SDROW"+index+"+=itemtmp");
   // console.log(eval("SDROW"+index+"+=itemtmp"))
   //alert(eval("SDROW"+index+"+=itemtmp"))
    /*if(tmp%6==0)
        code+="<TD>"+showItemList[i]+"</TD></TR><TR>";
    else
        code+="<TD>"+showItemList[i]+"</TD>";
    if(i==len-1)
        code+="</TR>";*/
}
var end="</TR>"
for(var j=1;j<=max;j++){
    eval("SDROW"+j+"+=end")
    //alert("结果："+eval("SDROW"+index))
    eval("code+=SDROW"+j)
}

  div1.innerHTML =code;
  console.log(code)
  //alert(code);


 //$("#showDetail").append(code)


 /*data = {
					"expertId":expert_id,
					"pageNumber":'1',
					"pageSize":'20'
				};
 $.get("/expert/info.html" ,function(data){alert(data)});
 
 alert(a.description)
 // 用来保存所有的属性名称和值
var props = "" ;
// 开始遍历
for ( var p in obj ){
// 方法
if ( typeof( obj[p]) == " function " ){
obj [ p ]() ;
} else {
// p 为属性名称，obj[p]为对应属性的值
props += p + " = " + obj[p] + " \t " ;
}
}
// 最后显示所有的属性
alert ( props ) ;
*/

//var div2 = document.getElementById('aaa');
//div2.innerHTML = '<table> asas </table>';


</script>
</body>
</html>
