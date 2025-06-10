<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div align="center">
    <a href="<%=request.getContextPath()%>/product_servlet/list.do">상품목록</a>
    <a href="<%=request.getContextPath()%>/shop/product_write.jsp">상품등록</a>
    <a href="<%=request.getContextPath()%>/pdf_servlet/list.do">PDF</a>
    
    <c:choose>
        <c:when test="${sessionScope.admin_userid == null }">
            <a href="<%=request.getContextPath()%>/shop/admin_login.jsp">관리자 로그인</a>
        </c:when>
        <c:otherwise>
            ${sessionScope.admin_name}님이 로그인중입니다.
            <a href="<%=request.getContextPath()%>/admin_servlet/logout.do">로그아웃</a>
        </c:otherwise>
    </c:choose>
</div>
<hr>