<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
저장되었습니다.
<a href="<%=request.getContextPath()%>/survey_servlet/input.do">Home</a>
<a href="<%=request.getContextPath()%>/survey_servlet/summary.do?survey_idx=1">Summary</a>
</body>
</html>