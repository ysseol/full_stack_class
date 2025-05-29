<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정/삭제</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    function gb_update() {
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

        document.form1.action = "<%=request.getContextPath()%>/gb_servlet/update.do";
        document.form1.submit();
    }

    function gb_delete() {
        if (confirm("삭제하시겠습니까?")) {
            document.form1.action = "<%=request.getContextPath()%>/gb_servlet/delete.do";
            document.form1.submit();
        }
    }
</script>
</head>
<body class="container py-5">
    <h2 class="text-center mb-4">방명록 수정/삭제</h2>

    <form name="form1" id="form1" method="post" class="card p-4 shadow-sm" style="max-width: 600px; margin: auto;">
        <input type="hidden" name="idx" value="${dto.idx}">

        <div class="mb-3">
            <label for="name" class="form-label">이름</label>
            <input type="text" class="form-control" name="name" id="name" value="${dto.name}">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">이메일</label>
            <input type="email" class="form-control" name="email" id="email" value="${dto.email}">
        </div>

        <div class="mb-3">
            <label for="passwd" class="form-label">비밀번호</label>
            <input type="password" class="form-control" name="passwd" id="passwd" value="${dto.passwd}">
        </div>

        <div class="mb-3">
            <label for="contents" class="form-label">내용</label>
            <textarea class="form-control" name="contents" id="contents" rows="5">${dto.contents}</textarea>
        </div>

        <div class="text-center">
            <button type="button" class="btn btn-primary me-2" onclick="gb_update()">수정</button>
            <button type="button" class="btn btn-danger me-2" onclick="gb_delete()">삭제</button>
            <button type="button" class="btn btn-secondary" onclick="location.href='<%=request.getContextPath()%>/gb_servlet/list.do';">목록</button>
        </div>
    </form>
</body>
</html>

        