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
	var data_columns = ['id','name','overview','updateAt'];
	var data_columns_name = ['名称','概要','更新时间','操作'];
	var action_columns = ['查看','|','删除','|','更新'];
	set_url('/disease/get');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	$('#disease-search').click(function(e){
		console.log('disease-search')
//		action="/disease/disease-search" method="get"
	});
			
	var set_table_header = function(){
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
					+ ''
					+ '<span id="'+(i+1)+'-asc" class="glyphicon glyphicon-chevron-up span-cursor"></span> </br>'
					+ '<span id="'+(i+1)+'-dsc" class="glyphicon glyphicon-chevron-down span-cursor"></span></div></div></th>'
			}
			

			$('#table-header').append(th);
		}
		

	}
	var myfunction = function() {
		$('tr > th > div > div > span').unbind();
		$('td > div > a > span').unbind();
		$('tr > th > div > div > span').click(function(e){			
			tmp = $(this).attr("id").split('-');
			$('tr > th > div > div > span').removeClass("active-order-color")
			$(this).addClass("active-order-color")
			console.log(data_columns_name[parseInt(tmp[0])-1]);
			tmp = data_columns[parseInt(tmp[0])]+'-'+tmp[1]
//			console.log(tmp)
			if(sort_type==tmp){
				curr_page=1
				curr_size=20
				sort_type = ""
				$(this).removeClass("active-order-color")
			}else {
				sort_type = tmp
			}
			console.log('After click sort Type ' + sort_type)
			$('#sort-type').text(sort_type)
			init_page_order($('#page-number-id').text(), $('#page-size-id').text(), $('#sort-type').text());
		});
		$('td > div > a > span').click(function(e){
			//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
			if($(this).text()=="查看") {
				var disease_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				disease_id = disease_id.split('-')[2]
				
				data = {
					"diseaseId":disease_id,
					"pageNumber":curr_page,
					"pageSize":curr_size,
					"sortType":sort_type,
					"from":"disease"
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
//				$.get("/disease/info.html", data );
//				location.href = "/disease/info.html?"+params;
				window.open("/disease/info.html?"+params)
			}else if($(this).text()=="删除") {
				//alert("111");
				var disease_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				disease_id = disease_id.split('-')[2];
				data = {
						"diseaseId":disease_id,
						"pageNumber":curr_page,
						"pageSize":curr_size
					}
				$.get("/disease/delete", data );
				location.href = "/disease.html";
				//deletede(get_curr_span_id($(this)));
			}else if($(this).text()=="更新") {
				var disease_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				disease_id = disease_id.split('-')[2]
				console.log(disease_id)
				console.log(curr_page)
				console.log(curr_size)
				//alert(disease_id);
				data = {
					"diseaseId":disease_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				$.get("/disease/infoUpdateData.html", data );
				location.href = "/disease/infoUpdateData.html?"+params;
				//location.href = "/disease/info.html?"+params;
			}
		});
	};
	set_table_header()
	set_function(myfunction);
//	console.log('number\t'+$('#page-number-id').text())
//	console.log('size\t'+$('#page-size-id').text())
//	console.log('sort\t'+$('#sort-type').text())
	init_page($('#page-number-id').text(), $('#page-size-id').text(), $('#sort-type').text());
	//----------------------------------------------
});
