<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	감사합니다.
	<a href="<%=request.getContextPath()%>/survey_servlet/input.do">설문메인화면</a>
	<a href="<%=request.getContextPath()%>/survey_servlet/survey_result.do?survey_idx=1">투표결과</a>
</body>
</html>