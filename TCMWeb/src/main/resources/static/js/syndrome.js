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
	//----------------------------------------------updateAt
	var data_columns = ['id','name','general_description','data_source'];
	var data_columns_name = ['病证名','概述','出处','操作'];
	var action_columns = ['查看'];
	set_url('/syndrome/get');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	$('#disease-search').click(function(e){
		//console.log('acupoint-search')
		init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#input-keyword").val());
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
		$('td > div > a > span').click(function(e){
			//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
			if($(this).text()=="查看") {
				var syndrome_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				//alert(expert_id);
				syndrome_id = syndrome_id.split('-')[2]
				//alert(expert_id);
				console.log(syndrome_id)
				console.log(curr_page)
				console.log(curr_size)
				
				data = {
					"syndromeId":syndrome_id,
					"pageNumber":curr_page,
					"pageSize":curr_size,
					"sortType":sort_type,
					"from":"disease"
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				
				window.open("/syndrome/info.html?"+params)
			}else if($(this).text()=="删除") {
				deletede(get_curr_span_id($(this)));
			}
		});
	};
	set_table_header()
	set_function(myfunction);
//	console.log($('#page-number-id').text())
//	console.log($('#page-size-id').text())
//	console.log("我日")
//	init_search_page($('#page-number-id').text(), $('#page-size-id').text(), $("#from").val());
	init_page($('#page-number-id').text(),$('#page-size-id').text(),"");
	//----------------------------------------------
});
