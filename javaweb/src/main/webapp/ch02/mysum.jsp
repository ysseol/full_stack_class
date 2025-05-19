<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/ch02_servlet/sum.do">
	숫자를 입력하세요: <input name="number"><br>
	<input type="submit" value="확인">
</form>
</body>
</html>