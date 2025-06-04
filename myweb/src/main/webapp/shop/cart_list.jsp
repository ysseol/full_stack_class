<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
$(function(){
    $("#btnList").click(function(){
        location.href="<%=request.getContextPath()%>/product_servlet/list.do";
    });
	$("#btnDelete").click(function(){
    	if(confirm("장바구니를 비우시겠습니까?")){
        	location.href="<%=request.getContextPath()%>/cart_servlet/delete_all.do";
    	}
	});
});
</script>
</head>
<body class="container my-5">
<%@ include file="../include/menu.jsp" %>

<h2 class="text-center mb-4">장바구니</h2>

<form name="form1" method="post" action="<%=request.getContextPath()%>/cart_servlet/update.do">
<div class="table-responsive">
<table class="table table-bordered text-center align-middle">
	<thead class="table-light">
	    <tr>
	        <th>상품명</th>
	        <th>단가</th>
	        <th>수량</th>
	        <th>금액</th>
	        <th>삭제</th>
	    </tr>
	</thead>
	<tbody>
    <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.product_name}</td>
            <td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
            <td>
                <input type="number" class="form-control form-control-sm text-center mx-auto"
                    style="max-width: 70px;" name="amount" value="${row.amount}"  min="0" max="100">
                <input type="hidden" name="product_code" value="${row.product_code}">
                <input type="hidden" name="cart_id" value="${row.cart_id}">
            </td>
            <td><fmt:formatNumber value="${row.money}" pattern="#,###" /></td>
            <td>
                <a href="<%=request.getContextPath()%>/cart_servlet/delete.do?cart_id=${row.cart_id}"
                   class="btn btn-sm btn-danger">삭제</a>
            </td>
        </tr>
    </c:forEach>
	</tbody>
</table>
</div>

<div class="my-4 text-center">
    <c:if test="${map.sum_money > 0 }">
        <div class="mb-2">
    		<strong>장바구니 금액 합계:</strong>
    		<fmt:formatNumber value="${map.sum_money}" pattern="#,###" />원
		</div>
		<div class="mb-2">
		    <strong>배송료:</strong> ${map.fee}원
		</div>
		<div class="mb-3">
		    <strong>총합계:</strong>
		    <fmt:formatNumber value="${map.sum}" pattern="#,###,###" />원
		</div>
		<button type="submit" class="btn btn-primary" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-warning" id="btnDelete">장바구니 비우기</button>
	</c:if>
	<c:if test="${map.sum_money == 0 }">
	    <div class="alert alert-info">장바구니가 비었습니다.</div>
	</c:if>
	<button type="button" class="btn btn-secondary mt-2" id="btnList">상품목록</button>
</div>
</form>

</body>
</html>

   