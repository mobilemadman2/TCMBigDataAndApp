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
	//var data_columns_name = ['中医诊断','西医诊断','名老中医','主诉症状','治则治法','操作'];
	var action_columns = ['查看'];
	set_url('/medical-case/listinfo');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
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
				console.log("materialcaseId")
				
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
			}else if($(this).text()=="删除") {
				deletede(get_curr_span_id($(this)));
			}
		});
	};
	set_function(myfunction);
	console.log($('#page-number-id').text())
	console.log($('#page-size-id').text())
	init_page($('#page-number-id').text(),$('#page-size-id').text());
	//----------------------------------------------
});
