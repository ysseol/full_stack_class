<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(function(){
    $("#btnDelete").click(function(){
        if(confirm("삭제하시겠습니까?")){
            document.form1.action = "<%=request.getContextPath()%>/board_servlet/delete.do";
            document.form1.submit();
        }
    });

    $("#btnUpdate").click(function(){
        let writer = $("#writer").val();
        let subject = $("#subject").val();
        let contents = $("#contents").val();
        let passwd = $("#passwd").val();

        if(writer == ""){
            alert("이름을 입력하세요.");
            $("#writer").focus();
            return;
        }
        if(subject == ""){
            alert("제목을 입력하세요.");
            $("#subject").focus();
            return;
        }

        if(contents == ""){
            alert("내용을 입력하세요.");
            $("#contents").focus();
            return;
        }

        if(passwd == ""){
            alert("비번을 입력하세요.");
            $("#passwd").focus();
            return;
        }

        let filename = document.form1.file1.value;
        let start = filename.lastIndexOf(".") + 1;

        if(start != 0){
            let ext = filename.substring(start).toLowerCase();
            if(ext === "jsp" || ext === "exe"){
                alert("업로드할 수 없는 파일입니다.");
                return;
            }
        }

        document.form1.action = "<%=request.getContextPath()%>/board_servlet/update.do";
        document.form1.submit();
    });
});
</script>
</head>
<body class="p-4">
<h2 class="mb-4">글 수정</h2>

<form name="form1" method="post" enctype="multipart/form-data">
<table class="table table-bordered w-auto" style="width: 700px;">
    <tr>
        <th class="text-center">이름</th>
        <td><input name="writer" id="writer" value="${dto.writer}" class="form-control"></td>
    </tr>
    <tr>
        <th class="text-center">제목</th>
        <td><input name="subject" id="subject" value="${dto.subject}" class="form-control"></td>
    </tr>
    <tr>
        <th class="text-center">본문</th>
        <td><textarea rows="5" name="contents" id="contents" class="form-control">${dto.contents}</textarea></td>
    </tr>
    <tr>
        <th class="text-center">첨부파일</th>
        <td>
            <c:if test="${dto.filesize > 0}">
                <div class="mb-2">
                    ${dto.filename} (${dto.filesize} bytes)
                    <label class="form-check-label ms-2">
                        <input type="checkbox" name="delete_file" class="form-check-input"> 첨부파일 삭제
                    </label>
                </div>
            </c:if>
            <input type="file" name="file1" class="form-control">
        </td>
    </tr>
    <tr>
        <th class="text-center">비밀번호</th>
        <td>
        	<input type="password" name="passwd" id="passwd" class="form-control w-50 d-inline">
        	<c:if test="${param.pwd_error == 'y'}">
           		<span class="text-danger ms-2">비밀번호가 틀렸습니다.</span>
        	</c:if>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="text-center">
            <input type="hidden" name="num" value="${dto.num}">
            <button type="button" id="btnUpdate" class="btn btn-primary me-2">수정</button>
            <button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
        </td>
    </tr>
</table>
</form>

</body>
</html>