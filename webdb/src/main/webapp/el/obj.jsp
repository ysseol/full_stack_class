<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="member.MemberDTO" %>
<%
MemberDTO dto=new MemberDTO();
dto.setUserid("kim");
dto.setName("김철수");
dto.setPasswd("1234");
request.setAttribute("dto", dto);
%>
<jsp:forward page="obj_result.jsp" />
</body>
</html>