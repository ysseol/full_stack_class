<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
function product_write() {
    let product_name = document.form1.product_name.value.trim();
    let price = document.form1.price.value.trim();
    let description = document.form1.description.value.trim();

    if (product_name === "") {
        alert("상품명을 입력하세요");
	    document.form1.product_name.focus();
	    return;
	}
	if (price === "") {
	    alert("가격을 입력하세요");
	    document.form1.price.focus();
	    return;
	}
	if (description === "") {
	    alert("상품 설명을 입력하세요");
	    document.form1.description.focus();
	    return;
	}
	document.form1.action = "<%=request.getContextPath()%>/product_servlet/insert_product.do";
	    document.form1.submit();
}
</script>
</head>

<body class="container mt-4">

<%@ include file="../include/admin_menu.jsp" %>

<h2 class="mb-4">상품 등록</h2>

<form name="form1" method="post" enctype="multipart/form-data">
    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">상품명</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="product_name">
        </div>
    </div>

    <div class="mb-3 row">
        <label class="col-sm-2 col-form-label">가격</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="price">
        </div>
    </div>
    
	<div class="mb-3 row">
	    <label class="col-sm-2 col-form-label">상품설명</label>
	    <div class="col-sm-10">
	        <textarea class="form-control" name="description" rows="4"></textarea>
	    </div>
	</div>

	<div class="mb-3 row">
	    <label class="col-sm-2 col-form-label">상품이미지</label>
	    <div class="col-sm-10">
	        <input class="form-control" type="file" name="file1">
	    </div>
	</div>

	<div class="text-center">
	    <button type="button" class="btn btn-primary me-2" onclick="product_write()">등록</button>
	    <a href="<%=request.getContextPath()%>/product_servlet/list.do" class="btn btn-secondary">목록</a>
	</div>
</form>

</body>
</html>