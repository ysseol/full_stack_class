<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>점수 계산</h2>
<form name="form1" action="<%=request.getContextPath()%>/servlet/point.do" method="post">

이름: <input type="text" name="name" required><br>
국어: <input type="text" name="kor" required><br>
영어: <input type="text" name="eng" required><br>
수학: <input type="text" name="mat" required><br>
<input type="submit" value="확인">

</form>
</body>
</html>