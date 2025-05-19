<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function() {
	$("#btnUpdate").click(function() {
		document.form1.action = "<%=request.getContextPath()%>/member_servlet/update.do";
		document.form1.submit();
	});
	
	$("#btnDelete").click(function() {
		if(confirm("삭제할까요?")){
			document.form1.action = "<%=request.getContextPath()%>/member_servlet/delete.do";
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<%
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>
<form name="form1" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><%=dto.getUserid()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" value="<%=dto.getPasswd()%>"></td>
 	</tr>
 	<tr>
		<td>이름</td>
		<td><input name="name" value="<%=dto.getName()%>"></td>
 	</tr>
 	<tr>
		<td>회원가입일자</td>
		<td><%=dto.getReg_date()%></td>
 	</tr>
 	<tr>
		<td>주소</td>
		<td><input name="address" value="<%=dto.getAddress()%>" size="50"></td>
 	</tr>
 	<tr>
		<td>전화</td>
		<td><input name="tel" value="<%=dto.getTel()%>"></td>
 	</tr>
 	<tr>
		<td colspan="2" align="center">
			<input type="hidden" name="userid" value="<%=dto.getUserid()%>">
			<button type="button" id="btnUpdate">수정</button>
			<button type="button" id="btnDelete">삭제</button>
		</td>
 	</tr>
</table>
</form>
</body>
</html>