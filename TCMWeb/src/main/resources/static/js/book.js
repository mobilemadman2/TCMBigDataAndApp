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
	var test = function(){
		var data = $.getJSON("/dynasty", function(jsonData){
			console.log(jsonData)
			for(var i=0;i<jsonData.length;i++){
				if(i==0)
				alert(jsonData[i])
				console.log(jsonData[i]['dynasty']['name'])
				var tmp = '<div class="col-xs-offset-1	col-xs-10">'
					+ '<div class="panel panel-default">'
					+ '  <div class="panel-heading">'+ jsonData[i]['dynasty']['name'] + '</div>'
					+ '		  <div class="panel-body">'
					+ '  <table class="table">'
					+ '	  <tr>'
					+ '	  <td>中医古籍</td>'
					+ '	  <td>中医古籍</td>'
					+ '	  <td>中医古籍</td>'
					+ '	  <td>中医古籍</td>'
					+ '	  </tr>'
					+ '	</table>'
					+ '</div>'
					+ '</div>'
					+ '</div>'
					
					$('#books').append(tmp);
			}


		});
		
	}
	
	test()
	
	//----------------------------------------------


	//----------------------------------------------
});
