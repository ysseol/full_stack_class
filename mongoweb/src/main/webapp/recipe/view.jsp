<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recipe.title}</title>
<style>
    body { font-family: sans-serif; padding: 20px; }
    h2 { margin-bottom: 10px; }
    ul, ol { margin-left: 20px; }
</style>
</head>
<body>

<h2>${recipe.title}</h2>

<h3>재료</h3>
<p>${recipe.ingredients}</p>

<h3>만드는 법</h3>
<p>${recipe.steps}</p>

<p>
    <a href="<%=request.getContextPath()%>/recipe_servlet?action=edit&id=${recipe.id}">수정</a> |
    <a href="<%=request.getContextPath()%>/recipe_servlet?action=delete&id=${recipe.id}" onclick="return confirm('삭제하시겠습니까?');">삭제</a> |
    <a href="<%=request.getContextPath()%>/recipe_servlet?action=list">목록으로</a>
</p>

</body>
</html>