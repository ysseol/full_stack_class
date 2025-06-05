<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="p-4">

<table class="table table-borered table-sm w-auto" style="width: 700px;">
	<c:forEach var="row" items="${list}">
	<tr>
		<td>
			<strong>${row.writer}</strong>
			<small class="text-muted">
				( <fmt:formatDate value="${row.reg_date}" pattern="yyyy-MM-dd HH:mm:ss" /> )
			</small>
			<br>
			<div class="mt-2">${row.contents}</div>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>