<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>급여계산</h2>

<form action="<%=request.getContextPath()%>/servlet/salary.do" method="post">

이름: <input name="name"><br>
기본금: <input name="basic"><br>
보너스: <input name="bonus"><br>

<input type="submit" value="확인">

</form>
</body>
</html>