<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변글쓰기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(function(){
    $("#btnSave").click(function(){
        let writer = $("#writer").val();
        let subject = $("#subject").val();
        let contents = $("#contents").val();
        let passwd = $("#passwd").val();

        if(writer === ""){
            alert("이름을 입력하세요.");
            $("#writer").focus();
            return;
        }
        if(subject === ""){
            alert("제목을 입력하세요.");
            $("#subject").focus();
            return;
        }
        if(contents === ""){
            alert("내용을 입력하세요.");
            $("#contents").focus();
            return;
        }
        if(passwd === ""){
            alert("비번을 입력하세요.");
            $("#passwd").focus();
            return;
        }
        document.form1.submit();
    });
});
</script>
</head>
<body class="p-4">

<h2 class="mb-4">답변글쓰기</h2>

<form name="form1" method="post" action="<%=request.getContextPath()%>/board_servlet/insert_reply.do">
<table class="table table-bordered w-auto" style="width: 700px;">
    <tr>
        <th class="text-center">이름</th>
        <td><input type="text" name="writer" id="writer" class="form-control"></td>
    </tr>
    <tr>
        <th class="text-center">제목</th>
        <td><input type="text" name="subject" id="subject" class="form-control" value="${dto.subject}"></td>
    </tr>
    <tr>
        <th class="text-center">본문</th>
        <td><textarea rows="5" name="contents" id="contents" class="form-control">${dto.contents}</textarea></td>
    </tr>
	<tr>
	    <th class="text-center">비밀번호</th>
	    <td><input type="password" name="passwd" id="passwd" class="form-control w-50 d-inline"></td>
	</tr>
	<tr>
	    <td colspan="2" class="text-center">
	        <input type="hidden" name="num" value="${dto.num}">
	        <button type="button" id="btnSave" class="btn btn-primary">확인</button>
	    </td>
	</tr>
</table>
</form>

</body>
</html>
