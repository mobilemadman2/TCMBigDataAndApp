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
	var data_columns = ['id','nameCn','attribution','updateAt'];
	var action_columns = ['查看','|','删除','|','更新'];
	set_url('/material/get');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	//alert("asasas");
	var myfunction = function() {
	//$('td>div>span').click(function(e){
		$('td > div > a > span').click(function(e){
			//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
			if($(this).text()=="查看") {
				//alert("asasas");
				var material_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				material_id = material_id.split('-')[2]
				console.log(material_id)
				console.log(curr_page)
				console.log(curr_size)
				
				data = {
					"materialId":material_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				console.log("参数"+params)
				//alert(params)
				location.href = "/material/info.html?"+params;
				
			}else if($(this).text()=="删除") {
				//alert("111");
				var material_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				material_id = material_id.split('-')[2];
				data = {
						"materialId":material_id,
						"pageNumber":curr_page,
						"pageSize":curr_size
					}
				$.get("/material/delete", data );
				location.href = "/material.html";
				//deletede(get_curr_span_id($(this)));
			}else if($(this).text()=="更新") {
				var material_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				material_id = material_id.split('-')[2]
				console.log(material_id)
				console.log(curr_page)
				console.log(curr_size)
				//alert(material_id);
				data = {
					"materialId":material_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				$.get("/material/infoUpdateData.html", data );
				location.href = "/material/infoUpdateData.html?"+params;
				//location.href = "/material/info.html?"+params;
			}
		});
	};
	set_function(myfunction);
	console.log($('#page-number-id').text())
	console.log($('#page-size-id').text())
	//init_page($('#page-number-id').text(),$('#page-size-id').text());
	init_page($('#page-number-id').text(), $('#page-size-id').text(), "");
	//----------------------------------------------
});
