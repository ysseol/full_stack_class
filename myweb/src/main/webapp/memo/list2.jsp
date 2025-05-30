<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" name="form1">
<table border="1">
  <tr>
    <th><input type="checkbox" onchange="check_all(this.checked)"></th>
    <th>번호</th>
    <th>이름</th>
    <th>메모</th>
    <th>날짜</th>
    <th><input type="button" value="선택삭제" onclick="delete_all()"></th>
  </tr>
  <c:forEach var="row" items="${list}">
    <tr>
      <td><input type="checkbox" name="idx" value="${row.IDX}"></td>
      <td>${row.IDX}</td>
      <td>${row.WRITER}</td>
      <td><a href="<%=request.getContextPath()%>/memo_servlet/view.do?idx=${row.IDX}">${row.MEMO}</a></td>
      <td>${row.POST_DATE}</td>
      <td><input type="button" value="삭제" onclick="memo_del('${row.IDX}')"></td>
    </tr>
  </c:forEach>
</table>
</form>
</body>
</html>