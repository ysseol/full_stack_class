<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방명록 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function gb_search() {
            document.form1.action = "<%=request.getContextPath()%>/gb_servlet/list.do";
            document.form1.submit();
        }
    </script>
</head>
<body class="container py-5">

    <h2 class="mb-4">방명록</h2>

    <form name="form1" method="post" class="row gy-2 gx-3 align-items-center mb-4">
        <div class="col-auto">
            <select name="searchKey" class="form-select">
                <option value="name" ${searchKey == 'name' ? 'selected' : ''}>이름</option>
                <option value="contents" ${searchKey == 'contents' ? 'selected' : ''}>내용</option>
                <option value="name_contents" ${searchKey == 'name_contents' ? 'selected' : ''}>이름+내용</option>
            </select>
        </div>
        <div class="col-auto">
            <input type="text" name="search" value="${search}" class="form-control" placeholder="검색어 입력">
        </div>
        <div class="col-auto">
            <button type="button" class="btn btn-primary" onclick="gb_search()">조회</button>
        </div>
        <div class="col-auto ms-auto">
            <button type="button" class="btn btn-success" onclick="location.href='<%=request.getContextPath()%>/guestbook/write.jsp'">글쓰기</button>
        </div>
    </form>

    <p class="text-muted">${count}개의 글이 있습니다.</p>

	<c:forEach var="dto" items="${list}">
		<form action="<%=request.getContextPath()%>/gb_servlet/passwd_check.do" method="post" class="mb-4">
			<input type="hidden" name="idx" value="${dto.idx}">
			<div class=card shadow-sm">
				<div class="card-header d-flex justify-content-between bg-info text-white">
					<div><strong>${dto.name}</strong></div>
					<div>${dto.post_date}</div>
				</div>
				<div class="card-body">
					<h6 class="card-subtitle mb-2 text-muted">${dto.email}</h6>
					<p class="card-text">${dto.contents}</p>
					<div class="input-group mt-3">
						<input type="password" name="passwd" class="form-control" placeholder="비밀번호 입력">
						<button type="submit" class="btn btn-outline-secondary">수정/삭제</button>
					</div>
				</div>
			</div>
		</form>
	</c:forEach>
</body>
</html>
