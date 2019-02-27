require.config({
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

require(['jquery','bootstrap','jquery_page'], function($) {
	$("#btn-login").click(function(event) {
		//		if($('#depotNewName').val()==null||$('#depotNewName').val().trim()==''){
		//			alert('新名称不能为空');
		//			return;
		//		}
		//console.log('new name '+current_depot_id)
		//		$.post('/login-action',
		//		{	
		//			inputEmail : $('#inputEmail').val(),
		//			inputPassword : $('#inputPassword').val(),
		//		});
		//
		$.ajax({
			type : "post",
			url : "user/login-action",
			data : {
				account : $('#account').val(),
				password : $('#password').val(),
			},
			async : false,
			success : function(data) {
				if(data.data=="用户已登陆") {
					window.location.href="user/user-info";
//					window.location.replace( "http://www.baidu.com" );
				}else {
					alert(data.data);
				}
			}
		});
	});
	
	$("#btn-reg").click(function(event) {
		if(document.getElementById("rules").checked){
			$.ajax({
				type : "post",
				url : "/register",
				data : {
					username : $('#username').val(),
					password : $('#password').val(),
					passwordConfirm : $('#passwordConfirm').val(),
					mobile : $('#mobile').val(),
					email : $('#email').val(),
				},
				
				async : false,
				success : function(data) {
					if(data.data=="success") {
						alert('注册成功')
						window.location.href="/index.html";
//						window.location.replace( "http://www.baidu.com" );
					}else {
						console.log(data)
						alert(data.data);
					}
				}
			});
		}else{
			alert("请接受相关条款")
		}
			

			
	
	});
	$("#btn-pass-update").click(function(event) {

		console.log($('#confirmpassword').val());
		$.ajax({
			type : "post",
			url : "/user/upt-pass",
			data : {
				password : $('#password').val(),
				newpassword: $('#newpassword').val(),
				confirmpassword: $('#confirmpassword').val(),
			},
			async : false,
			success : function(data) {
				if(data.data=="success") {
					allert('修改成功')
				}else {
					alert(data.data);
				}
			}
		});
	});
	
	$("#btn-update").click(function(event) {
		$.ajax({
			type : "post",
			url : "/user/upt-info",
			data : {
				mobile : $('#mobile').val(),
				email : $('#email').val(),
			},
			async : false,
			success : function(data) {
				if(data.data=="success") {
					allert('修改成功')
				}else {
					alert(data.data);
				}
			}
		});
	});
});