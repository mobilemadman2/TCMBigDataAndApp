﻿﻿﻿﻿﻿require.config({
  //urlArgs: "version=20170407",
  paths: {
	'jquery' : '/js/packages/jquery-2.14-min',
	'bootstrap' : '/bootstrap/js/bootstrap.min',
    'jquery_page':"/js/packages/jquery.twbsPagination",    
  },
  shim: {
    'bootstrap': {
      deps: ['jquery'],
      exports: 'bootstrap'
    },
  	'jquery_page':{
  		deps: ['jquery'],
        exports: 'bootstrap'
  	}
  }
});

require(['jquery','bootstrap','jquery_page'], function ($) {
	//----------------------------------------------
	var data_columns = ['id','tcm_diagnosis','wm_diagnosis','doctor_name','patient_description','therapeutic'];
	var data_columns_name = ['中医诊断','西医诊断','名老中医','主诉症状','治则治法','操作'];
	var action_columns = ['查看'];
	set_url('/medical-case/search_info');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	//判断是否有disease-search组件
	$('#disease-search').click(function(e){
		//console.log('acupoint-search')
		init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#input-keyword").val());
//		action="/disease/disease-search" method="get"
	});
			
	var set_table_header = function(){
//		console.log('set table header')
		for(var i=0;i<data_columns_name.length;i++){
			var th = document.createElement("th");
			th.setAttribute("class",'patent-data-table show_column-'+(i+1));
			if(i==data_columns_name.length-1){
				th.innerHTML = '<div class="th-order"><div class="col-name">'
					+ data_columns_name[i] + '</div></div>'
			}else{
				th.innerHTML =
					'<div class="th-order"><div class="col-name">'
					+ data_columns_name[i] + '</div><div class="order-icon">'
					+ '</div></div></th>'
			}
			

			$('#table-header').append(th);
		}
		

	}
	var myfunction = function() {
	$('td > div > a > span').unbind();
	$('td > div > a > span').click(function(e){
		//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
		if($(this).text()=="查看") {
			var diagnosis_id = String($(this).parent().parent().parent().parent("tr ").attr("id"));
			diagnosis_id = diagnosis_id.split('-')[2]
			console.log(diagnosis_id)
			console.log(curr_page)
			console.log(curr_size)
			
			data = {
				"materialcaseId":diagnosis_id,
				"pageNumber":curr_page,
				"pageSize":curr_size
			}
			console.log(data)
			var params = Object.keys(data).map(function(key){
				return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
			}).join("&");
			//$.get("/medicalcase/info.html", data );
			//location.href = "/medicalcase/info.html?"+params; 
			window.open("/medicalcase/info.html?"+params); 
		}
	});
	};
	set_table_header();
	set_function(myfunction);
	console.log('number\t'+$('#page-number-id').text())
	console.log('size\t'+$('#page-size-id').text())
//	console.log('sort\t'+$('#sort-type').text())
	init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#input-keyword").val());
	//----------------------------------------------
});
