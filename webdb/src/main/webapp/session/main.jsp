<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="check_session.jsp"%>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function() {
	$("#btnLogout").click(function() {
		location.href = "<%=request.getContextPath()%>/session_servlet/logout.do";
	});
});
</script>
</head>
<body>
	<h2><%=session.getAttribute("message")%>님 환영합니다.</h2>
	<%=session.getAttribute("userid")%>님이 접속중입니다.
	<br>
	<button type="button" id="btnLogout">로그아웃</button>
</body>
</html>