<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] names = {"protocol", "server's name", "method", "context", "uri", "url", "ip"};

String[] values = {request.getProtocol(), request.getServerName(), request.getMethod(),
					request.getContextPath(), request.getRequestURI(), request.getRequestURL().toString(),
					request.getRemoteAddr() };

for (int i = 0; i < names.length; i++) {
	out.println(names[i] + ":" + values[i] + "<br>");
}

out.println("<hr>");
Enumeration<String> en = request.getHeaderNames();
String key = "";
String value = "";
while (en.hasMoreElements()) {
	key = en.nextElement();
	value = request.getHeader(key);
	out.println(key + ":" + value + "<br>");
}
%>
</body>
</html>