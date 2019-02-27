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
	var data_columns = ['id','id','bookName','author_name','origin','modify','time_string'];
	//var data_columns_name = ['中医诊断','西医诊断','名老中医','主诉症状','治则治法','操作'];
	var action_columns = ['实体抽取'];
	set_url('/proof/listinfo-json');
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
	
	
	$(".show-column2").children("div").wrap("<a href=\"#\" ></a>")
	$(".show-column5").children("div").wrap("<a href=\"#\" ></a>")
	$(".show-column4").children("div").wrap("<a href=\"#\" ></a>")
	$(".col-xs-9").removeClass().addClass("col-xs-10")
	
	
	function jump_detail(){
		//古籍书名来跳转的
		$(".show-column2 ").click(function(){
			var name = $(this).parent().children().eq(1).children().children('div').text();
		    console.log(name)
	    	data = {
				"name":name,
				"old":1
			}
			var params = Object.keys(data).map(function(key){
				return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
			}).join("&");
			window.open("proof?"+params);
		});
			
		
		//原始书籍跳转的
		$(".show-column4 ").click(function(){
			var name = $(this).parent().children().eq(1).children().children('div').text();
		    console.log(name)
	    	data = {
				"name":name,
				"old":0
			}
			var params = Object.keys(data).map(function(key){
				return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
			}).join("&");
			window.open("proof?"+params);
		});
		
		
		//矫正版本跳转的
		$(".show-column5 ").click(function(){
			var name = $(this).parent().children().eq(1).children().children('div').text();
		    console.log(name)
	    	data = {
				"name":name,
				"old":1
			}
			var params = Object.keys(data).map(function(key){
				return encodeURIComponent(key)+"="+encodeURIComponent(data[key]);
			}).join("&");
			window.open("proof?"+params);
		});
	}
	
	jump_detail()
	
	var all_file_size = 0
	
	//异步访问有多少json文件
	$.get("/proof/json-file-number",function(result){
	    console.log("json 文件大小");
	    console.log(result)
	    all_file_size = result;
	  });
	//当数据表发生变化的时候加载
	var title = $("#table-all");
	var tr_number = 0;
	var start_tr = 0;
	title.bind('DOMNodeInserted', function(e) {
		//console.log($(".page-link").eq(9).text())
		if(tr_number != $('#table-all').children().length){
			tr_number = $('#table-all').children().length
			$("#table-all").children().eq(tr_number-1).children().eq(1).children("div").wrap("<a href=\"#\" ></a>")
			$("#table-all").children().eq(tr_number-1).children().eq(4).children("div").wrap("<a href=\"#\" ></a>")
			$("#table-all").children().eq(tr_number-1).children().eq(3).children("div").wrap("<a href=\"#\" ></a>")
			//当加载到页面最后一个条数据的时候加载,每个页面２０条数据
			if(tr_number%20 == 0 ){
				console.log("开始的标记")
				console.log(start_tr)
				console.log(tr_number)
				
				jump_detail()
			}
			
			
			if(($(".disabled").eq(0).text() == "下一页" || $(".disabled").eq(3).text() == "下一页" ) && (($(".page-link").eq(9).text()-1)*20 + tr_number) == all_file_size){
				console.log("下一页")
				jump_detail()
			}
			
		}
		
		
		
	});
	
	
	
	
	//----------------------------------------------
});
