<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.ArrayList" %>
<%
ArrayList<String> items=new ArrayList<String>();
items.add("orange");
items.add("apple");
items.add("melon");
items.add("peach");
request.setAttribute("items", items);
%>
<jsp:forward page="array_result.jsp" />
</body>
</html>