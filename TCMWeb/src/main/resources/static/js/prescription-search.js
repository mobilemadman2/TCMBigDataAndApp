﻿﻿﻿﻿﻿require.config({
  //urlArgs: "version=20170407",
  paths: {
	'jquery' : '/js/packages/jquery-3.3.1',
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
	var data_columns = ['id','name','source','updateAt'];
	var data_columns_name = ['名称','出处','更新时间','操作'];
	var action_columns = ['查看','|','删除','|','更新'];
	set_url('/prescription/prescription-search');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	var myfunction = function() {
		$('td>div>a>span').click(function(e){
			//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
			var prescription_id = $(this).parent().parent().parent().parent("tr").attr("id");
			if($(this).text()=="查看") {
				var prescription_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				prescription_id = prescription_id.split('-')[2]
				console.log(prescription_id)
				console.log(curr_page)
				console.log(curr_size)
				
				data = {
					"prescriptionId":prescription_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				window.open("/prescription/info.html?"+params);
			}else if($(this).text()=="删除") {
				//alert("111");
				var prescription_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				prescription_id = prescription_id.split('-')[2];
				data = {
						"prescriptionId":prescription_id,
						"pageNumber":curr_page,
						"pageSize":curr_size
					}
				$.get("/prescription/delete", data );
				location.href = "/prescription.html";
				//deletede(get_curr_span_id($(this)));
			}else if($(this).text()=="更新") {
				var prescription_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				prescription_id = prescription_id.split('-')[2]
				console.log(prescription_id)
				console.log(curr_page)
				console.log(curr_size)
				//alert(prescription_id);
				data = {
					"prescriptionId":prescription_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				$.get("/prescription/infoUpdateData.html", data );
				location.href = "/prescription/infoUpdateData.html?"+params;
				//location.href = "/prescription/info.html?"+params;
			}
		});
	};
	set_function(myfunction);
	init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#input-keyword").val());
	//----------------------------------------------
});
