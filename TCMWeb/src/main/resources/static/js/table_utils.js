
	//var data_columns = ['id','name','count','updateAt'];
	//var action_columns = ['重命名','删除']
	//init_page(1,20);//当前页，每页个数
	var curr_page = 1;
	var curr_size = 20;
	var sort_type = '';
	var alphabet = 'B';
	
	var curr_url="";
	var data_columns = [];
	var action_columns = [];
	var click_function;
	var query_type;
	var has_input = false;
	function set_has_input(f_has_input) {
		has_input = f_has_input;
	}
	function set_query_type(f_type) {
		query_type = f_type;
	}
	function set_function(my_function) {
		click_function = my_function;
	}
	function set_url(f_url) {
		curr_url = f_url;
	}
	function set_data_columns(f_data_columns) {
		data_columns = f_data_columns;
	}
	function set_action_columns(f_action_columns) {
		action_columns = f_action_columns;
	}
	
	function init_page(curr_page,curr_size,sort_type) {
		get_data_ordered(curr_page,curr_size,sort_type,curr_url);
	}
	
	
	/******     search page     ******/
	function init_search_page(curr_page,curr_size,keyword) {
		console.log(curr_page);
		console.log(keyword);
		if(keyword!=undefined||keyword=='')
			get_datas_keyword(curr_page,curr_size,curr_url,keyword);
	}
	function get_datas_keyword(f_page_number,f_page_size,url,keyword) {
		var jsondata = {
			'pageNumber' : f_page_number,
			'pageSize' : f_page_size,
			'keywords' : keyword
		}
		if(query_type!=null) {
			jsondata['quey_type'] = query_type;
		}
		console.log('in-number\t'+f_page_number)
		console.log('in-size\t'+f_page_size)
		curr_page = f_page_number
		curr_size = f_page_size
		
		
		$.ajaxSetup({   
            async : false  
        }); 
		$.post(url,jsondata,
		function(data,status){
//			jsns = $.parseJSON(data)
//			var res = new Array()
//			for(var i=0;i<jsns.length;i++){
//				console.log(jsns[i]['_source'])
//				res.push(jsns[i]['_source'])
//			}
//			console.log(jsns)
			console.log("json data is return")
			show_datas(data.entries);
			console.log("data.page"+data.page)
			console.log("data.totalPages"+data.totalPages)
			show_pages(data.page,data.totalPages,keyword)
		});
		click_function();
	}
	function show_pages_keyword(page,totalPages,keyword) {
		console.log(totalPages)
		console.log(page)
		$("#page_all").twbsPagination({
			onPageClick:function pageselectCallback(event,page_index){
				jump_page_keyword(page_index,keyword);
				console.log("jump_page(page_index)"+page_index)
			},
			initiateStartPageClick:false,
			totalPages:totalPages,
			visiblePages:8,
			first:'首页',
			last:'尾页',
			prev:'上一页',
			next:'下一页',
	    });
	}
	function jump_page_keyword(f_curr_page,keyword) {
		curr_page = f_curr_page;
		get_datas_keyword(f_curr_page,curr_size,curr_url,keyword);
	}

	
	function init_page_order(curr_page,curr_size,sort_type) {
		get_data_ordered(curr_page,curr_size,sort_type,curr_url);
	}
	
	//add alphabet order
	function init_page_table_alphabet(curr_page,curr_size,sort_type,f_alphabet) {
		console.log("init_page_table_alphabet")
		//console.log(curr_page+curr_size+sort_type+"asasas")
		get_data_alphabet(curr_page,curr_size,curr_url,f_alphabet);
		console.log("init_pagealphabet:"+f_alphabet)
		
	}
	
	function get_data_alphabet(f_page_number,f_page_size, url,f_alphabet) {
		console.log("get_data_alphabet")
		console.log("get_data_alphabet:"+f_alphabet)
		var jsondata = {
			'pageNumber' : f_page_number,
			'pageSize' : f_page_size,
			'alphabet' : f_alphabet
		}
		if(query_type!=null) {
			jsondata['quey_type'] = query_type;
		}
		curr_page = f_page_number
		curr_size = f_page_size
		alphabet = f_alphabet
		$.ajaxSetup({   
            async : false  
        }); 
		$.post(url,jsondata,
		function(data,status){
			show_datas(data.entries);
			show_pages_alpabet(data.page,data.totalPages,f_alphabet)
			
		});
		click_function();
	}
	
	function show_pages_alpabet(page,totalPages,alphabet) {
		console.log("show_pages_alpabet:"+alphabet)
		console.log(totalPages)
		console.log(page)
		$("#page_all").twbsPagination({
			onPageClick:function (event,page_index){
				console.log("jump_page(page_index)_before"+page_index)
				jump_page_alphabet(page_index,alphabet);
				console.log("jump_page(page_index)"+page_index)
			},
			initiateStartPageClick:false,
			totalPages:totalPages,
			visiblePages:8,
			first:'首页',
			last:'尾页',
			prev:'上一页',
			next:'下一页',
	    });
	}
	function jump_page_alphabet(f_curr_page,alphabet) {
		console.log("jump_page_alphabet:"+alphabet)
		curr_page = f_curr_page;
		get_data_alphabet(f_curr_page,curr_size,curr_url,alphabet);
	}

	
	function get_data_ordered(f_page_number,f_page_size,f_sort_type, url) {
		var jsondata = {
			'pageNumber' : f_page_number,
			'pageSize' : f_page_size,
			'sortType' : f_sort_type
		}
		if(query_type!=null) {
			jsondata['quey_type'] = query_type;
		}
		curr_page = f_page_number
		curr_size = f_page_size
		sort_type = f_sort_type
		$.ajaxSetup({   
            async : false  
        }); 
		$.post(url,jsondata,
		function(data,status){
			show_datas(data.entries);
			show_pages_ordered(data.page,data.totalPages)
			click_function();
		});
	}
	
	
	function get_datas(f_page_number,f_page_size,url) {
		var jsondata = {
			'pageNumber' : f_page_number,
			'pageSize' : f_page_size
		}
		if(query_type!=null) {
			jsondata['quey_type'] = query_type;
		}
		curr_page = f_page_number
		curr_size = f_page_size
		$.ajaxSetup({   
            async : false  
        }); 
		$.post(url,jsondata,
		function(data,status){
			show_datas(data.entries);
			show_pages(data.page,data.totalPages)
		});
		click_function();
	}
	function show_datas(datas) {
//		console.log(datas)
		$('#table-all').empty();
		for(var i in datas) {
			console.log(datas[i])
			if(!has_input) {
				common_addtd(datas[i]);
			}else {
				common_addtd_input(datas[i],parseInt(i)+1);
			}
		}
	}
	//show detail information,构造table的html代码
	function common_addtd(data){
		var tr = document.createElement("tr");
		tr.setAttribute('id','tr-id-'+data[data_columns[0]]);//source-id//WX//FILE
		for(var i=1;i<data_columns.length;i++) {
			var td = document.createElement("td");
			td.setAttribute("class","patent-data-table show-column"+i);
			td.setAttribute("id","td-"+i+"-id-"+data[data_columns[0]]);
			td.innerHTML=convert_data(data_columns[i],data[data_columns[i]],data);
			tr.appendChild(td);
		}
		var td_action = document.createElement("td");
		td.setAttribute("class","patent-data-table show-column-last");
		var actionHTML = "";
		for(var i in action_columns) {
			actionHTML=actionHTML+convert_action_data(action_columns[i],data);
		}
		td_action.innerHTML = convert_data('action',actionHTML,data);
		tr.appendChild(td_action);
		$('#table-all').append(tr);
	}
	function common_addtd_input(data,index){
//		console.log(index)
		var tr = document.createElement("tr");
		tr.setAttribute('id','tr-id-'+data[data_columns[0]]);//source-id//WX//FILE
		var td_input = document.createElement("td");
		td_input.setAttribute("class","patent-data-table show-column");
		td_input.setAttribute("id","td-"+0+"-id-"+data[data_columns[0]]);
		td_input.innerHTML="<input type='checkbox' id='selected-query-"+data[data_columns[0]]+"'>";
		tr.appendChild(td_input);
		var td_index = document.createElement("td");
		td_index.setAttribute("class","query-index patent-data-table show-column"+0);
		td_index.setAttribute("id","td-"+0+"-id-"+data[data_columns[0]]);
		td_index.innerHTML="#"+index;
		tr.appendChild(td_index);
		
		for(var i=1;i<data_columns.length;i++) {
			var td = document.createElement("td");
			if(data_columns[i]=="content") {
				td.setAttribute("class","query-value patent-data-table show-column"+i);
			}else {
				td.setAttribute("class","patent-data-table show-column"+i);
			}
			
			td.setAttribute("id","td-"+i+"-id-"+data[data_columns[0]]);
			td.innerHTML=convert_data(data_columns[i],data[data_columns[i]],data);
			tr.appendChild(td);
		}
		var td_action = document.createElement("td");
		td.setAttribute("class","patent-data-table show-column-last");
		var actionHTML = "";
		for(var i in action_columns) {
			actionHTML=actionHTML+convert_action_data(action_columns[i],data);
		}
		td_action.innerHTML = convert_data('action',actionHTML,data);
		tr.appendChild(td_action);
	
		$('#table-all').append(tr);
	}
	function convert_data(data_name,data_content,data) {
		var div_start = "<div class = 'table-content' data-container='body' data-toggle='popover' data-placement='bottom' >";
		var div_end = "</div>";
		var res = data_content;
		if(data_name=="updateAt") {
			res = new Date(data_content).toLocaleDateString();
		}else if(data_name=="createAt") {
			res = new Date(data_content).toLocaleDateString();
		}else if(data_name=="nameCn") {
			if(data_content==null){
				res = "-";
			}
		}
		
		if(res=='None') res=''
		res = div_start+res+div_end;
		return res;
	}
	
	function convert_action_data(action_data,data) {
		var res = action_data;
		if(action_data=="报告下载") {
			if(!!data['reportPath']) {
				res = "<a href='/report/download/wordres?depot_id="+data[data_columns[0]]+"'>报告下载</a>";
			}else {
				res = "";
			}
		}
		
		res = '<a href="#"><span class="glyphicon action-span">'+res+'</span></a>';
		return res;
	}
	
	function show_pages(page,totalPages) {
		console.log(totalPages)
		console.log(page)
		$("#page_all").twbsPagination({
			onPageClick:function pageselectCallback(event,page_index){
				jump_page(page_index);
				console.log("jump_page(page_index)"+page_index)
			},
			initiateStartPageClick:false,
			totalPages:totalPages,
			visiblePages:8,
			first:'首页',
			last:'尾页',
			prev:'上一页',
			next:'下一页',
	    });
	}
	function jump_page(f_curr_page) {
		curr_page = f_curr_page;
		get_datas(f_curr_page,curr_size,curr_url);
	}
	
	function show_pages_ordered(page,totalPages) {
		console.log(totalPages)
		$("#page_all").twbsPagination({
			onPageClick:function pageselectCallback(event,page_index){
				jump_page_ordered(page_index);
			},
			initiateStartPageClick:false,
			totalPages:totalPages,
			visiblePages:8,
			first:'首页',
			last:'尾页',
			prev:'上一页',
			next:'下一页',
	    });
	}
	function jump_page_ordered(f_curr_page) {
		curr_page = f_curr_page;
//		console.log('jump_page_ordered ' + sort_type)
		get_data_ordered(f_curr_page,curr_size,sort_type, curr_url);
	}
	function get_curr_span_id(span) {
		var id = span.parent().parent().parent().attr('id');
		return id;
	}
	