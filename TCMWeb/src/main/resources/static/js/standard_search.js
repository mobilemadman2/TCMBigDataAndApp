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
	var data_columns = ['id','standardNumber','standardName','releaseDepartment'];
	var data_columns_name = ['名称','出处','更新时间','操作'];
	var action_columns = ['查看'];
	set_url('/standard/standard_search');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	var myfunction = function() {		
		$('td>div>a>span').click(function(e){
			var imageId = $(this).parent().parent().parent().parent("tr").attr("id");
			if($(this).text()=="查看") {
				var standardId = $(this).parent().parent().parent().parent("tr ").attr("id");
				standardId = standardId.split('-')[2]				
				data = {
					"standardId":standardId,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				$.get("/standard/info.html", data );
				location.href = "/standard/info.html?"+params;
			}else if($(this).text()=="删除") {
				var image_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				image_id = image_id.split('-')[2];
				data = {
						"image_id":image_id,
						"pageNumber":curr_page,
						"pageSize":curr_size
					}
				$.get("/prescription/delete", data );
				location.href = "/prescription.html";
			}else if($(this).text()=="更新") {
				var image_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				image_id = image_id.split('-')[2]
				console.log(image_id)
				console.log(curr_page)
				console.log(curr_size)
				//alert(prescription_id);
				data = {
					"image_id":image_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				$.get("/prescription/infoUpdateData.html", data );
				location.href = "/prescription/infoUpdateData.html?"+params;
			}
		});
	};
	set_function(myfunction);
	init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#input-keyword").val());
	//----------------------------------------------
});
