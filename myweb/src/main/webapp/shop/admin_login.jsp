<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    
    <c:if test="${param.message == 'error' }">
        <script>alert("아이디 또는 비밀번호가 일치하지 않습니다.");</script>
    </c:if>
    <c:if test="${param.message == 'logout' }">
        <script>alert("로그아웃되었습니다.");</script>
    </c:if>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>

<div class="container mt-5" style="max-width: 400px;">
    <h3 class="text-center mb-4">관리자 로그인</h3>
    <form name="form1" method="post" action="<%=request.getContextPath()%>/admin_servlet/login.do">
        <div class="mb-3">
            <label class="form-label">아이디</label>
            <input type="text" name="userid" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">비밀번호</label>
            <input type="password" name="passwd" class="form-control">
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">로그인</button>
        </div>
    </form>
</div>

</body>
</html>
