<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
int basic = Integer.parseInt(request.getParameter("basic"));
int bonus = Integer.parseInt(request.getParameter("bonus"));
int total = basic * 12 + bonus;
int tax = (int) (total * 0.03);
int money = total - tax;
%>
이름: <%=name%><br>
기본급: <%=basic%><br>
보너스: <%=bonus%><br>
총액: <%=total%><br>
세액: <%=tax%><br>
실수령액: <%=money%><br>
</body>
</html>