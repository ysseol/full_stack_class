<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="season" value="spring" />
<c:choose>
	<c:when test="${season == 'spring'}">
		<img src="../images/spring.jpg">
	</c:when>
	<c:when test="${season == 'summer'}">
		<img src="../images/summer.jpg">
	</c:when>
	<c:when test="${season == 'autumn'}">
		<img src="../images/autumn.jpg">
	</c:when>
	<c:when test="${season == 'winter'}">
		<img src="../images/winter.jpg">
	</c:when>
	<c:otherwise>otherwise</c:otherwise>
</c:choose>
</body>
</html>