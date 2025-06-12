<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootsrtrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		let writer = $("#writer");
		let memo = $("#memo");
		if (writer.val() == "") {
			alert("이름을 입력하세요");
			writer.focus();
			return;
		}
		if (memo.val() == "") {
			alert("메모를 입력하세요");
			memo.focus();
			return;
		}
		if (memo.val() == "") { 
			alert("메모를 입력하세요");
			memo.focus();
			return;
		}
		document.form1.action = "<%=request.getContextPath()%>/memo_servlet/update.do";
		document.form1.submit();
	});
	
	$("#btnDelete").click(function(){
		if (confirm("삭제하시겠습니까?")) {
			document.form1.action = "<%=request.getContextPath()%>/memo_servlet/del.do";
			document.form1.submit();
		}
	});
});
</script>
</head>
<body class="container my-5">

<h2 class="text-center mb-4">메모 수정</h2>

<form name="form1" method="post" class="mx-auto" style="max-width:600px;">
	<div class="mb-3">
		<label for="writer" class="form-label">이름</label>
		<input type="text" class="form-control" name="writer" id="writer" value="${dto.writer}">
	</div>
	<div class="mb-3">
		<label for="memo" class="form-label">메모</label>
		<input type="text" class="form-control" name="memo" id="memo" value="${dto.memo}">
	</div>
	<input type="hidden" name="idx" value="${dto.idx}">
	<div class="d-flex justify-content-between">
		<button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
		<button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
	</div>
</form>

</body>
</html>