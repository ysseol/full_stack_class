<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="<%=request.getContextPath()%>/encrypt_servlet/join.do">
아이디 : <input name="userid"><br>
비밀번호 : <input type="password" name="passwd"><br>
이름 : <input name="name"><br>
<button>회원가입</button>
</form>
</body>
</html>