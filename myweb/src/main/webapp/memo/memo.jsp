<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 메모장</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function() {
    list();

    $("#btnSave").click(function() {
        insert();
    });
    $("#btnSearch").click(function() {
        list();
    });
});

function list() {
    let search_option = $("#search_option").val();
    let search = $("#search").val();
    fetch("<%=request.getContextPath()%>/memo_servlet/list.do?search_option=" + search_option + "&search=" + search)
       .then(response => response.text())
       .then(txt => {
           $("#result").html(txt);
       });
}

function insert() {
    let writer = $("#writer").val();
    let memo = $("#memo").val();
    let params = { writer, memo };
    fetch("<%=request.getContextPath()%>/memo_servlet/insert.do", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
        body: new URLSearchParams(params).toString()
    })
    .then(() => {
        list();
        $("#writer").val("");
        $("#memo").val("");
    });
}

function memo_del(idx) {
    location.href = "<%=request.getContextPath()%>/memo_servlet/del.do?idx=" + idx;
}

function check_all(ck) {
    $("input[name=idx]").prop("checked", ck);
}

function delete_all() {
    let arr = $("input[name=idx]");
    let cnt = arr.filter(":checked").length;

    if (cnt == 0) {
        alert("삭제할 메모를 선택하세요.");
        return;
    }

    document.form1.action = "<%=request.getContextPath()%>/memo_servlet/delete_all.do";
    document.form1.submit();
}
</script>
</head>
<body class="container my-5">
	<h2 class="text-center mb-4">한줄 메모장</h2>
	<!-- 작성 영역 -->
	<div class="row g-2 mb-3 align-items-center">
		<div class="col-sm-2">
			<input id="writer" class="form-control" placeholder="이름">
		</div>
		<div class="col-sm-6">
			<input id="memo" class="form-control" placeholder="메모">
		</div>
		<div class="col-sm-2">
			<button id="btnSave" class="btn btn-primary w-100">확인</button>
		</div>
	</div>

	<!-- 검색 영역 -->
	<div class="row g-2 mb-4 align-items-center">
		<div class="col-sm-2">
			<select id="search_option" class="form-select">
				<option value="writer">이름</option>
				<option value="memo">메모</option>
				<option value="writer_memo">이름+메모</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input id="search" class="form-control" value="${search}"
				placeholder="검색어 입력">
		</div>
		<div class="col-sm-2">
			<button id="btnSearch" class="btn btn-info w-100">조회</button>
		</div>
	</div>

	<!-- 결과 출력 -->
	<div id="result"></div>

</body>
</html>
