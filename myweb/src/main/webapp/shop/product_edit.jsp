<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
function delete_product() {
    if (confirm("삭제하시겠습니까?")) {
        document.form1.action = "<%=request.getContextPath()%>/product_servlet/delete.do";
        document.form1.submit();
    }
}
function update_product() {
    let product_name = document.form1.product_name.value;
    let price = document.form1.price.value;
	let description = document.form1.description.value;

    if (product_name == "") {
        alert("상품명을 입력하세요");
        document.form1.product_name.focus();
        return;
    }
    if (price == "") {
        alert("가격을 입력하세요");
        document.form1.price.focus();
        return;
    }
    if (description == "") {
        alert("상품 설명을 입력하세요");
        document.form1.description.focus();
        return;
    }

    document.form1.action = "<%=request.getContextPath()%>/product_servlet/update.do";
    document.form1.submit();
}
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>

<div class="container mt-5" style="max-width: 700px;">
    <h3 class="text-center mb-4">상품 수정</h3>
    <form name="form1" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label class="form-label">상품명</label>
            <input name="product_name" class="form-control" value="${dto.product_name}">
        </div>

        <div class="mb-3">
            <label class="form-label">가격</label>
            <input type="text" name="price" class="form-control" value="${dto.price}">
        </div>

        <div class="mb-3">
            <label class="form-label">상품설명</label>
            <textarea rows="5" name="description" class="form-control">${dto.description}</textarea>
        </div>
		<div class="mb-3">
		    <label class="form-label d-block">기존 이미지</label>
		    <img src="<%=request.getContextPath()%>/images/${dto.filename}" width="300" height="300" class="mb-2">
		    <input type="file" name="file1" class="form-control">
		</div>
		<input type="hidden" name="product_code" value="${dto.product_code}">
		<div class="d-flex justify-content-center gap-2">
		    <button type="button" class="btn btn-primary" onclick="update_product()">수정</button>
		    <button type="button" class="btn btn-danger" onclick="delete_product()">삭제</button>
		    <button type="button" class="btn btn-secondary" onclick="location.href='<%=request.getContextPath()%>/product_servlet/list.do'">목록</button>
		</div>

	</form>
</div>

</body>
</html>