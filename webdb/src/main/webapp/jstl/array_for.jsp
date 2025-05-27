<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
int[] nums={10,70,80,50,40,30,20};
%>
<c:set var="numbers" value="<%=nums%>" />
<c:forEach var="num" items="${numbers}">
	${num},
</c:forEach>
</body>
</html>