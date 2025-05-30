<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		list('1');
	});

	function list(cur_page){
		fetch("<%=request.getContextPath()%>/page_servlet/list.do?cur_page=" + cur_page)
		.then(res => res.text())
		.then(html => document.getElementById("result").innerHTML = html );
	}
</script>
</head>
<body>
	<h2>페이지 나누기</h2>
	<div id="result"></div>
</body>
</html>
