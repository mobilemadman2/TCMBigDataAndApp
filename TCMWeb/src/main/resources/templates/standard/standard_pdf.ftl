<!DOCTYPE html>
<html lang="en">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<style> 
			html,body{height:100%} 	 
			body{ margin:0} 
			/* 去除设置div 高度100% 浏览器右侧产生滚动条 */ 
		</style> 
	</head> 
	<body>
		<div id="example1" style="height: 99%;"></div>
		<script src="/js/pdfobject.js"></script>
		<script>
			PDFObject.embed("${file_path}", "#example1");
		</script>
	</body>
</html>
