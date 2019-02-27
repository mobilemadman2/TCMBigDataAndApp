<!DOCTYPE html>
<html lang="en">
<head>
	<#include "/common/common-head.ftl"/>
	<link href="/medical-case/medical-case-info.css" rel="stylesheet">
	<link href="/info-page.css" rel="stylesheet">
	<link href="/entity-annotation.css" rel="stylesheet">
</head>
<body>
<style> 
.v {border-collapse: seperate;} 
.v td{ border: none; border-bottom: dashed 1px #ddd; padding:5px;} 
</style> 
	<!-- Fixed navbar -->
	<#include "/common/nav.ftl">
	
	<div class="container">
	
	<#assign nav_name = ["中医医案","${medicalcase.tcm_diagnosis}"]>
    <#assign nav_href = ["/medicalcase.html", "medicalcase/info.html?materialcaseId=${medicalcase.id}"]>
    <#include "/common/nav-pos.ftl"/>
    
		<div class="blog-header">
			<h1 class="blog-title">医案</h1>
<!-- 			<p class="lead blog-description">The official example template of -->
<!-- 				creating a blog with Bootstrap.</p> --> 
		</div>
		
		<div class="row">
		<div class="col-md-12 blog-main">
		<table class="u" cellspacing="30px">
		<tr>
		<td>
		<div id="targetname" class="col-xs-16" style="color:#708090">名老中医：</div></td>
		<td>
		<div id="doctor_name" class="col-xs-16"><a href="#" id="Go"><#if (medicalcase.doctor_name!"") !="">${medicalcase.doctor_name}
		 </#if></a>
		 </div>
		<!-- /.blog-post --></td>
				
		<td > 
		<div class="col-xs-16" style="color:#708090;margin-left:40px;">科别：</div></td>
		<td><div class="col-xs-16"><#if (medicalcase.department!"") !="">${medicalcase.department} </#if></div>	
		<!-- /.blog-post -->
		</td>
		</tr>
		</table>
		</div>
		</div>
		<br><br>
		
		<div class="row">
			<div class="col-sm-8 blog-main">
				<!-- angular.js bootstrap -->		      
		<table class="v" >
		<tr>
		<td>

		<div id="targetname" class="col-xs-16" style="color:#708090">患者：</div></td><td><div class="col-xs-16"><#if (medicalcase.patient_name!"") !="">${medicalcase.patient_name}
		 </#if></div>
				<!-- /.blog-post --></td>
				<td> 
					<div class="col-xs-16" style="color:#708090">性别：</div></td>
					<td><div class="col-xs-16"><#if (medicalcase.gender!"") !="">${medicalcase.gender} </#if></div>
			
				<!-- /.blog-post -->
				</td>
		</tr>
		
		<tr>
			<td> 
					<div class="col-xs-16" style="color:#708090"><#if (medicalcase.birth_day!"") !="">出生年月：</div>
			</td>
			<td>
					<div class="col-xs-16">${medicalcase.birth_day}</#if></div>
			</td>
		<td> 
					<div class="col-xs-16" style="color:#708090">年龄：</div></td><td><div class="col-xs-16"><#if (medicalcase.birth_day!"") !="">${medicalcase.treatment_time?substring(0,4)?number-medicalcase.birth_day?substring(0,4)?number}岁</#if></div>
				
				<!-- /.blog-post --> </td>
        </tr>
        
        <tr>
		<td> 
				<div class="col-xs-16" style="color:#708090">就诊时间：</div></td><td><div class="col-xs-16"><#if (medicalcase.treatment_time!"") !="">${medicalcase.treatment_time}</#if></div>
				<!-- /.blog-post --> </td>
		<td> 
				<div class="col-xs-16" style="color:#708090">发病节气：</div></td><td><div class="col-xs-16"><#if (medicalcase.solar_term!"") !="">${medicalcase.solar_term}</#if></div>
				<!-- /.blog-post --> </td>
        </tr>

     </table>
<!--
<h4>相关知识链接：<small id="no-relation"></small></h4>
<div class="row" ng-app="material" ng-controller="matCtrl" id="entityRelations">
<div class="relation-block">
<div ng-repeat="(entitykey, name) in entities.views" class="label-collection">{{ name }}:
	<div ng-repeat="entity in entities.relations[entitykey]" >
	    <div class="label label-info label-entity" style="margin:3px;" 
	    id="{{ entitykey + '_' + entity.relatedEntity }}">
	    <a href="{{ entity.uri }}" target="_blank" ng-if="entity.uri!=null">{{ entity.relatedEntity }}</a>
	    <span ng-if="entity.uri==null">{{ entity.relatedEntity }}</span>
	    </div>
     </div>
</div> 
</div>
</div>
-->

<br><br>				
<table id="showDetail">

 </table>

 


<#if (medicalcase.patient_description!"")!="" || (medicalcase.personal_history!"")!="" || (medicalcase.current_illness_history!"")!="" || (medicalcase.illness_history!"")!="" >
				<div class="blog-post" id="问诊">

					<h2 class="blog-post-title" id="description">问诊</h2>

					<blockquote>
					<table>
					<tr>
						<td width="15%">
							<p><b>【主诉】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.patient_description!"") !=""> ${medicalcase.patient_description}</p></#if>
						</td>
					</tr>
					<tr>
						<td width="15%">
							<p><b>【现病史】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.current_illness_history!"") !="">${medicalcase.current_illness_history}</p></#if>
						</td>
					</tr>
					
					<tr>
						<td width="15%">
							<p><b>【既往史】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.illness_history!"") !=""> ${medicalcase.illness_history}</p></#if>
						</td>
					</tr>
					
					<tr>
						<td width="15%">
							<p><b>【个人史】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.personal_history!"") !=""> ${medicalcase.personal_history}</p></#if>
						</td>
					</tr>
					
					
					<tr>
						<td width="15%">
							<p><b>【过敏史】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.allergy_history!"") !="">${medicalcase.allergy_history}</p></#if>
						</td>
					</tr>
					
					
					<tr>
						<td width="15%">
							<p><b>【家族史】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.family_history!"") !="">${medicalcase.family_history}</p></#if>
						</td>
					</tr>
					
					
					<tr>
						<td width="15%">
							<p><b>【刻下症】</b></p>
						</td>
						<td>
							<p><#if (medicalcase.current_symptom!"") !="">${medicalcase.current_symptom}</p></#if>
						</td>
					</tr>
					
					<!-- 
						<p><#if (medicalcase.current_illness_history!"") !=""><b>【现病史】</b> ${medicalcase.current_illness_history}</p></#if>
						<p><#if (medicalcase.illness_history!"") !=""><b>【既往史】</b> ${medicalcase.illness_history}</p></#if>
						<p><#if (medicalcase.personal_history!"") !=""><b>【个人史】</b> ${medicalcase.personal_history}</p></#if>
						<p><#if (medicalcase.allergy_history!"") !=""><b>【过敏史】</b> ${medicalcase.allergy_history}</p></#if>
						<p><#if (medicalcase.family_history!"") !=""><b>【家族史】</b> ${medicalcase.family_history}</p></#if>
						<p><#if (medicalcase.current_symptom!"") !=""><b>【刻下症】</b> ${medicalcase.current_symptom}</p></#if>
					 -->
					</table>
					</blockquote>
					
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (medicalcase.tongue_symptom!"") !="">
				<div class="blog-post" id="望诊">

					<h2 class="blog-post-title" id="tongue_symtom">望诊</h2>

					<blockquote>
						<p><b>【舌象】</b> ${medicalcase.tongue_symptom}</p>
						<!-- <p><b>【全身】</b> </p> -->
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalcase.pulse_symptom!"") !="">
				<div class="blog-post" id="切诊">

					<h2 class="blog-post-title" id="pulse_symptom">切诊</h2>


					<blockquote>
						<p><b>【脉象】</b> ${medicalcase.pulse_symptom}</p>
						<!-- <p><b>【按诊】</b> </p> -->
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				
				
				<#if (medicalcase.assist_exam!"") !="">
				<div class="blog-post" id="辅助检查">

					<h2 class="blog-post-title" id="assist_exam">辅助检查</h2>


					<blockquote>
						<p>${medicalcase.symptom_analysis}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if><#if (medicalcase.symptom_analysis!"") !="">
				<div class="blog-post" id="辩证分析">

					<h2 class="blog-post-title" id="symptom_analysis">辩证分析</h2>

					<blockquote>
						<p>${medicalcase.symptom_analysis}</p>
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
				<#if (medicalcase.massage!"") !="" || (medicalcase.point_select!"") !="" || (medicalcase.acupuncture!"") !="" || (medicalcase.doctor_comments!"") !="" || (medicalcase.usages!"") !="" || (medicalcase.composition!"") !="" || (medicalcase.tcm_diagnosis!"") !="" || (medicalcase.wm_diagnosis!"")!="" || (medicalcase.tcm_syndrome!"") !="" || (medicalcase.therapeutic!"") !="" || (medicalcase.prescription!"") !="">
				<div class="blog-post" id="诊断分析">

					<h2 class="blog-post-title" id="tcm_diagnosis">诊断分析</h2>

					<blockquote>
					<table>
						<tr>
							<td width="15%">
								<p><b>【中医诊断】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.tcm_diagnosis!"") !="">${medicalcase.tcm_diagnosis}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【西医诊断】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.wm_diagnosis!"") !="">${medicalcase.wm_diagnosis}</p></#if>
							</td>
						</tr>
						
						<tr>
							<td width="15%">
								<p><b>【中医症候】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.tcm_syndrome!"") !="">${medicalcase.tcm_syndrome}</p></#if>
							</td>
						</tr>
						
						<tr>
							<td width="15%">
								<p><b>【治则法治】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.therapeutic!"") !="">${medicalcase.therapeutic}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【方名】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.prescription!"") !="">${medicalcase.prescription}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【组成】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.composition!"") !="">${medicalcase.composition}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【用法】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.usages!"") !="">${medicalcase.usages}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【医嘱】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.doctor_comments!"") !="">${medicalcase.doctor_comments}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【针灸】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.acupuncture!"") !="">${medicalcase.acupuncture}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【选穴】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.point_select!"") !="">${medicalcase.point_select}</p></#if>
							</td>
						</tr>
						
						
						<tr>
							<td width="15%">
								<p><b>【推拿】</b></p>
							</td>
							<td>
								<p><#if (medicalcase.massage!"") !="">${medicalcase.massage}</p></#if>
							</td>
						</tr>
					</table>
					<!--  
						<p><#if (medicalcase.tcm_diagnosis!"") !=""><b>【中医诊断】</b> 　${medicalcase.tcm_diagnosis}</p></#if>
						<p><#if (medicalcase.wm_diagnosis!"") !=""><b>【西医诊断】</b>　${medicalcase.wm_diagnosis}</p></#if>
						<p><#if (medicalcase.tcm_syndrome!"") !=""><b>【中医症候】</b>　${medicalcase.tcm_syndrome}</p></#if>
						<p><#if (medicalcase.therapeutic!"") !=""><b>【治则法治】</b>　${medicalcase.therapeutic}</p></#if>
						<p><#if (medicalcase.prescription!"") !=""><b>【方名】</b>　${medicalcase.prescription}</p></#if>
						<p><#if (medicalcase.composition!"") !=""><b>【组成】</b>　${medicalcase.composition}</p></#if>
						<p><#if (medicalcase.usages!"") !=""><b>【用法】</b>　${medicalcase.usages}</p></#if>
						<p><#if (medicalcase.doctor_comments!"") !=""><b>【医嘱】</b>　${medicalcase.doctor_comments}</p></#if>
						<p><#if (medicalcase.acupuncture!"") !=""><b>【针灸】</b>　${medicalcase.acupuncture}</p></#if>
						<p><#if (medicalcase.point_select!"") !=""><b>【选穴】</b>　${medicalcase.point_select}</p></#if>
						<p><#if (medicalcase.massage!"") !=""><b>【推拿】</b>　${medicalcase.massage}</p></#if>
					-->
					</blockquote>
				</div>
				<!-- /.blog-post --> </#if>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Bootstrap core JavaScript
    ================================================== --> <!-- Placed at the end of the document so the pages load faster -->
	
	<script src="/js/angular.min.js"></script>
    <script src="/js/packages/jquery-2.14-min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script>
var app = angular.module('material', []);
app.controller('matCtrl', function($scope, $http) {
	console.log('wlkejalsdfa')

});
</script>
	<script>
function scrollToDiv(s){
	window.location.hash="#"+s;
	//alert(s)

		window.scrollBy(0,-90)
}
</script>
<script type="text/javascript">
 var showItemList = new Array();
 var showItemListEn = new Array();
 
 if('${(medicalcase.patient_description)}'!=""){ showItemList.push("问诊"); showItemListEn.push("description");}
 if('${(medicalcase.tongue_symptom)}'!=""){ showItemList.push("望诊"); showItemListEn.push("tongue_symptom");}
 if('${(medicalcase.pulse_symptom)}'!=""){ showItemList.push("切诊"); showItemListEn.push("pulse_symptom");}
 if('${(medicalcase.assist_exam)}'!=""){ showItemList.push("辅助检查"); showItemListEn.push("assist_exam");}
 if('${(medicalcase.symptom_analysis)}'!=""){ showItemList.push("辩证分析"); showItemListEn.push("symptom_analysis");}
 if('${(medicalcase.tcm_diagnosis)}'!=""){ showItemList.push("诊断治疗"); showItemListEn.push("tcm_diagnosis");}

//alert("长度："+showItemList.length)
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
 
for(var i = 0,len=showItemList.length;i<len;i++){

    //tmp++;
    index=i%max+1;
    num=i+1;

   itemtmp="<TD id=\""+showItemList[i]+"\" onclick=\"scrollToDiv(\'"+showItemListEn[i]+"\')\"><blockquote>"+num+" "+showItemList[i]+"</blockquote></TD>";
   eval("SDROW"+index+"+=itemtmp");

}
var end="</TR>"
for(var j=1;j<=max;j++){
    eval("SDROW"+j+"+=end")
    //alert("结果："+eval("SDROW"+index))
    eval("code+=SDROW"+j)
}

 div1.innerHTML =code;
 console.log(code)
 

//ajax方式访问数据库，expert表中是否有当前医生的名字
url_check = "/medicalcase/check_doctor_name?doctor_name="+'${medicalcase.doctor_name}'
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
			url_doctor_detail = "/expert/info.html?expertId="+data;
			$("#Go").attr("href",url_doctor_detail);
		}
		else{
			//设置不可点击,去掉<a>标签
			$("#Go").contents().unwrap();
		}
	},
	fail:function(data){
		console.log("check failde|||")
	}
});
 </script>

