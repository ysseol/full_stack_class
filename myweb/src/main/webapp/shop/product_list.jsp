<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

<!-- Bootstrap 5 CDN 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<script>
$(function(){
    $("#btn_add").click(function(){
        location.href = "<%=request.getContextPath()%>/shop/product_write.jsp";
	});
});
</script>
</head>
<body class="container my-4">
<%@ include file="../include/admin_menu.jsp"%>

<h2 class="mb-4">상품 목록</h2>

<c:if test="${sessionScope.admin_userid != null }">
	<button type="button" id="btn_add" class="btn btn-primary mb-3">상품 등록</button>
</c:if>

<table class="table table-bordered table-hover align-middle text-center">
	<thead class="table-dark">
		<tr>
			<th>번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${list}" varStatus="s">
		<tr>
			<td>${s.count}</td>
			<td>
				<img src="<%=request.getContextPath()%>/images/${row.filename}" width="100" height="100" class="img-thumbnail">
			</td>
			<td class="text-start">
				<a href="<%=request.getContextPath()%>/product_servlet/detail.do?product_code=${row.product_code}">
						${row.product_name}
				</a>
				<c:if test="${sessionScope.admin_userid != null }">
					<br>
					<a class="btn btn-sm btn-outline-secondary mt-1"
						href="<%=request.getContextPath()%>/product_servlet/edit.do?product_code=${row.product_code}">수정</a>
				</c:if>
			</td>
			<td>
				<fmt:formatNumber value="${row.price}" pattern="#,###" /> 원
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>
