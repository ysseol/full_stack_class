<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// String name="김철수";
String name = URLEncoder.encode("김철수", "utf-8");
response.sendRedirect("redirect_result.jsp?name=" + name + "&age=20");
%>
</body>
</html>