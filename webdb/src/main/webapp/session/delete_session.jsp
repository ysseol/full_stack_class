<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//session.removeAttribute("id");
//session.removeAttribute("passwd");
session.invalidate();
%>
<a href="view_session.jsp">세션 확인</a>
</body>
</html>