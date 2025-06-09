<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recipe != null ? "레시피 수정" : "새 레시피 등록"}</title>
<style>
    body { font-family: sans-serif; padding: 20px; }
    label { display: block; margin-top: 10px; font-weight: bold; }
    input, textarea { width: 300px; margin-bottom: 5px; }
    textarea { height: 60px; }
</style>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${not empty recipe}">레시피 수정</c:when>
        <c:otherwise>새 레시피 등록</c:otherwise>
    </c:choose>
</h2>

<form method="post" action="<%=request.getContextPath()%>/recipe_servlet?recipe">
    <c:if test="${not empty recipe}">
        <input type="hidden" name="id" value="${recipe.id}">
    </c:if>

    <label>제목</label>
    <input type="text" name="title" value="${recipe.title}">

    <label>재료</label>
    <input type="text" name="ingredients" value="${recipe.ingredients}">

    <label>만드는 법</label>
    <textarea name="steps">${recipe.steps}</textarea>
    
    <br>
    <input type="submit" value="저장">
    <br>
    <input type="button" onclick="location.href='<%=request.getContextPath()%>/recipe_servlet?action=list'" value="목록">
</form>

</body>
</html>