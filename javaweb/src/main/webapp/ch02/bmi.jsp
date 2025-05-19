<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
double height=Double.parseDouble(request.getParameter("height"));
double weight=Double.parseDouble(request.getParameter("weight"));
double bmi=weight / (height/100 * height/100);
String result="";
if(bmi<=18.5) {
	result="저체중";
} else if(bmi>18.5 && bmi <=23) {
	result="정상";
} else if(bmi>23 && bmi <=25) {
	result="과체중";
} else if(bmi>25 && bmi <=30) {
	result="비만";
} else {
	result="고도비만";
}
%>
<%=name%>님의 bmi 값은 <%=String.format("%.2f",bmi)%>이며 <%=result%>입니다.
</body>
</html>