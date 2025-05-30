<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 목록</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/include/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script>
        $(function(){
            // 전체 선택/해제
            $("#chkAll").click(function(){
                $("input[name=idx]").prop("checked", this.checked);
            });

            // 선택 삭제
            $("#btnAllDel").click(function(){
            let checked = $("input[name=idx]:checked").length;
            if (checked === 0) {
                alert("삭제할 메모를 선택하세요.");
                return;
            }
            if (confirm("선택한 메모를 삭제하시겠습니까?")) {
                document.form1.action = "<%=request.getContextPath()%>/memo_servlet/delete_all.do";
                document.form1.submit();
            }
        });

        // 개별 삭제 함수
        function memo_del(idx) {
            if (confirm("삭제하시겠습니까?")) {
                location.href = "<%=request.getContextPath()%>/memo_servlet/del.do?idx=" + idx;
            }
        }
    </script>
</head>
<body class="container my-4">
	<h2 class="text-center mb-4">메모 목록</h2>

	<c:choose>
		<c:when test="${list.size() == 0}">
			<div class="alert alert-warning text-center">등록된 메모가 없습니다.</div>
		</c:when>

		<c:otherwise>
			<form method="post" name="form1">
				<table
					class="table table-hover table-bordered align-middle text-center">
					<thead class="table-light">
						<tr>
							<th><input type="checkbox" id="chkAll"></th>
							<th>번호</th>
							<th>이름</th>
							<th>메모</th>
							<th>날짜</th>
							<th>
								<button type="button" id="btnAllDel"
									class="btn btn-sm btn-danger">선택삭제</button>
							</th>
						</tr>
					<tbody>
						<c:forEach var="row" items="${list}">
							<tr>
								<td><input type="checkbox" name="idx" value="${row.IDX}"></td>
								<td>${row.IDX}</td>
								<td>${row.WRITER}</td>
								<td><a
									href="<%=request.getContextPath()%>/memo_servlet/view.do?idx=${row.IDX}"
									class="text-decoration-none"> ${row.MEMO} </a></td>
								<td>${row.POST_DATE}</td>
								<td>
									<button type="button" class="btn btn-sm btn-outline-danger"
										onclick="memo_del('${row.IDX}')">삭제</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>