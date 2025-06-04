<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<!-- Bootstrap CDN 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<c:if test="${param.message == 'error' }">
    <script>
        alert("아이디 또는 비밀번호가 일치하지 않습니다.");
    </script>
</c:if>
<c:if test="${param.message == 'logout' }">
    <script>
        alert('로그아웃되었습니다.');
    </script>
</c:if>
</head>
<body class="container my-5">

<%@ include file="../include/menu.jsp" %>

<h2 class="mb-4">로그인</h2>

<div class="row justify-content-center">
    <div class="col-md-6">
        <form method="post" action="<%=request.getContextPath()%>/login_servlet/login.do" class="border p-4 rounded shadow-sm bg-light">
            <div class="mb-3">
                <label for="userid" class="form-label">아이디</label>
                <input type="text" name="userid" id="userid" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="passwd" class="form-label">비밀번호</label>
                <input type="password" name="passwd" id="passwd" class="form-control" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">로그인</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
    