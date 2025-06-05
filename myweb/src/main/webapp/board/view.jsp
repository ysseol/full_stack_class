<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(function(){
    $("#btnEdit").click(function(){
        document.form1.action = "<%=request.getContextPath()%>/board_servlet/check_pwd.do";
        document.form1.submit();
    });
    $("#btnList").click(function(){
        location.href = "<%=request.getContextPath()%>/board_servlet/list.do";
    });
    list_comment();
    $("#btnSave").click(function(){
        insert_comment();
    });
    $("#btnReply").click(function(){
        document.form1.action = "<%=request.getContextPath()%>/board_servlet/input_reply.do";
        document.form1.submit();
    });
});

function insert_comment(){
    const params = {
        board_num: ${dto.num},
        writer: $("#writer").val(),
        contents: $("#contents").val()
    };

    fetch("<%=request.getContextPath()%>/board_servlet/insert_comment.do", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: new URLSearchParams(params)
    })
    .then(() => {
        $("#writer").val("");
        $("#contents").val("");
        list_comment();
    });
}

function list_comment(){
    fetch("<%=request.getContextPath()%>/board_servlet/list_comment.do?num=${dto.num}")
        .then(response => response.text())
        .then(txt => {
            $("#div_comment").html(txt);
        });
}
</script>
</head>
<body class="p-4">

<form name="form1" method="post">
<table class="table table-bordered w-auto" style="width: 700px;">
    <tr>
        <th class="text-center" style="width: 20%;">날짜</th>
        <td>${dto.reg_date}</td>
        <th style="width: 20%;">조회수</th>
        <td>${dto.hit}</td>
    </tr>
	<tr>
		<th class="text-center">이름</th>
		<td colspan="3">${dto.writer}</td>
	</tr>
	<tr>
	    <th class="text-center">제목</th>
	    <td colspan="3">${dto.subject}</td>
	</tr>
	<tr>
	    <th class="text-center">본문</th>
	    <td colspan="3">${dto.contents}</td>
	</tr>
	<tr>
	    <th class="text-center">비밀번호</th>
	    <td colspan="3">
			<input type="password" name="passwd" id="passwd" class="form-control w-25 d-inline">
            <c:if test="${param.message == 'error' }">
				<span class="text-danger">비밀번호가 일치하지 않습니다.</span>
			</c:if>
	    </td>
	</tr>
	<tr>
	    <th class="text-center">첨부파일</th>
	    <td colspan="3">
	        <c:if test="${dto.filesize > 0}">
				${dto.filename} ( ${dto.filesize} bytes )
				<a href="<%=request.getContextPath()%>/board_servlet/download.do?num=${dto.num}">[다운로드]</a>
			</c:if>
	    </td>
	</tr>
    <tr>
        <td colspan="4" class="text-center">
            <input type="hidden" name="num" value="${dto.num}">
            <button type="button" id="btnEdit" class="btn btn-warning">수정/삭제</button>
            <button type="button" id="btnReply" class="btn btn-secondary">답변</button>
            <button type="button" id="btnList" class="btn btn-primary">목록</button>
        </td>
    </tr>
</table>
</form>

<table class="table borderless w-auto mb-3" style="width: 700px;">
	<tr>
		<td>
			<input id="writer" placeholder="이름" class="form-control">
		</td>
		<td rowspan="2" class="align-top">
			<button id="btnSave" type="button"  class="btn btn-success">확인</button>
		</td>
	</tr>
	<tr>
		<td>
			<textarea rows="5" cols="80" placeholder="내용" id="contents" class="form-control"></textarea>
		</td>
	</tr>
</table>

<div id="div_comment" class="mt-3"></div>
	
</body>
</html>