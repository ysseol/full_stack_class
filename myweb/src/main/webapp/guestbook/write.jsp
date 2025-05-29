<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    function check() {
    	let name = $("#name");
        let email = $("#email");
        let passwd = $("#passwd");
        let contents = $("#contents");

        if (name.val() == "") {
            alert("이름을 입력하세요");
            name.focus();
            return;
        }

        if (email.val() == "") {
            alert("이메일을 입력하세요");
            email.focus();
            return;
        }
        
        if (passwd.val() == "") {
            alert("비밀번호를 입력하세요");
            passwd.focus();
            return;
        }
        
        if (contents.val() == "") {
            alert("내용을 입력하세요");
            contents.focus();
            return;
        }

        document.form1.action = "<%=request.getContextPath()%>/gb_servlet/insert.do";
        document.form1.submit();
    }
</script>
</head>
<body>
<div class="container py-5">
    <h2 class="mb-4 text-center">방명록 작성</h2>
    <form name="form1" id="form1" method="post" class="card p-4 shadow-sm" style="max-width: 600px; margin: auto;">
        <div class="mb-3">
            <label for="name" class="form-label">이름</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요.">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">이메일</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="이메일을 입력하세요">
        </div>
        <div class="mb-3">
            <label for="passwd" class="form-label">비밀번호</label>
            <input type="password" class="form-control" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요">
        </div>
        <div class="mb-3">
            <label for="contents" class="form-label">내용</label>
            <textarea class="form-control" name="contents" id="contents" rows="5" placeholder="내용을 입력하세요"></textarea>
        </div>
        <div class="text-center">
            <button type="button" class="btn btn-primary me-2" onclick="check()">확인</button>
            <button type="reset" class="btn btn-secondary">취소</button>
        </div>
    </form>
</div>
</body>
</html>
