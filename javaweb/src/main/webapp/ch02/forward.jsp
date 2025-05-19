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
request.setAttribute("id", "kim");
request.setAttribute("name", "김철수");
%>
<jsp:forward page="forward_result.jsp"/>
</body>
</html>