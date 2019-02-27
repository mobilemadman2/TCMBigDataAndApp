﻿﻿﻿﻿require.config({
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
	var data_columns = ['id','paper_name','paper_abstract','updateAt'];
	var action_columns = ['查看'];
	set_url('/paper/get');
	set_data_columns(data_columns);
	set_action_columns(action_columns);
	
	var myfunction = function() {
		$('td > div > a > span').click(function(e){
			//var id = $(this).parent().parent().find('>ul>li>label>input').prop('checked', true);
			if($(this).text()=="查看") {
				var paper_id = $(this).parent().parent().parent().parent("tr ").attr("id");
				//alert(expert_id);
				paper_id = paper_id.split('-')[2]
				//alert(expert_id);
				console.log(paper_id)
				console.log(curr_page)
				console.log(curr_size)
				
				data = {
					"paperId":paper_id,
					"pageNumber":curr_page,
					"pageSize":curr_size
				}
				console.log(data)
				var params = Object.keys(data).map(function(key){
					return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
				}).join("&");
				
				window.open("/paper/info.html?"+params)
			}else if($(this).text()=="删除") {
				deletede(get_curr_span_id($(this)));
			}
		});
	};
	set_function(myfunction);
	console.log($('#page-number-id').text())
	console.log($('#page-size-id').text())
	init_page($('#page-number-id').text(),$('#page-size-id').text(),"");
	//----------------------------------------------
});
