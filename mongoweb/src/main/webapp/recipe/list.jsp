<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 목록</title>
<script>
function delete_recipe(id){
	if(confirm("삭제하시겠습니까?")){
		location.href="<%=request.getContextPath()%>/recipe_servlet?action=delete&id="+id;
	}
}
</script>
<style>
	body { font-family: sans-serif; padding: 20px;}
	ul { list-style: noe; padding: 0; }
	li { margin-bottom: 10px; }
	a { text-decoration: none; color: #2c3e50; }
	a:hover { color: #e74c3c; }
</style>
</head>
<body>

<h2>레시피 목록</h2>
<a href="<%=request.getContextPath()%>/recipe/form.jsp">새 레시피 등록</a>

<c:if test="${empty recipes}">
    <p>등록된 레시피가 없습니다.</p>
</c:if>

<ul>
    <c:forEach var="recipe" items="${recipes}">
        <li>
            <strong>
                <a href="<%=request.getContextPath()%>/recipe_servlet?action=view&id=${recipe.id}">${recipe.title}</a>
            </strong>
            
            [<a href="<%=request.getContextPath()%>/recipe_servlet?action=edit&id=${recipe.id}">수정</a>]
            [<a href="#" onclick="delete_recipe('${recipe.id}')">삭제</a>]
        </li>
    </c:forEach>
</ul>

</body>
</html>