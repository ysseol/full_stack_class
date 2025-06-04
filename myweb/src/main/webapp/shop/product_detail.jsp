<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품정보</title>

<!-- Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container my-5">

<h2 class="mb-4">상품정보</h2>

<div class="row">
	<!-- 이미지 영역 -->
	<div class="col-md-5 text-center">
		<img src="<%=request.getContextPath()%>/images/${dto.filename}"
			class="img-fluid border rounded" style="max-width: 300px;">
	</div>

	<!-- 상품 정보 영역 -->
	<div class="col-md-7">
		<table class="table table-bordered">
			<tr>
				<th class="table-light" style="width: 100px;">상품명</th>
				<td>${dto.product_name}</td>
			</tr>
			<tr>
				<th class="table-light">가격</th>
				<td>${dto.price}원</td>
			</tr>
			<tr>
				<th class="table-light">설명</th>
				<td>${dto.description}</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<form name="form1" method="post" action="<%=request.getContextPath()%>/cart_servlet/insert.do" class="d-inline-block">
						<input type="hidden" name="product_code" value="${dto.product_code}">
						<div class="input-group">
							<select name="amount" class="form-select" style="max-width: 100px;">
								<c:forEach begin="1" end="10" var="i">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select>
							<span class="input-group-text">개</span>
							<button type="submit" class="btn btn-primary">장바구니에 담기</button>
						</div>
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>