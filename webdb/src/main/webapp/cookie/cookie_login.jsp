<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function() {
    var show = getCookie("showCookies");
    if (show != "N") {
        window.open("popup.jsp", "", "width=300,height=400");
    }
    var cookie_userid = getCookie("userid");
    if (cookie_userid != "") {
        $("#userid").val(cookie_userid);
        $("#chkSave").attr("checked", true);
    }
    $("#btnLogin").click(function() {
        if ($("#chkSave").is(":checked")) { 
            saveCookie($("#userid").val());
        } else { 
            saveCookie("");
        }
    });
    $("#chkSave").click(function() {
        if ($("#chkSave").is(":checked")) {
            if (!confirm("로그인 정보를 저장하시겠습니까?")) {
                $("#chkSave").prop("checked", false);
            }
        }
    });
});
function saveCookie(id) {
    if (id != "") {
        setCookie("userid", id, 7); 
    } else {
        setCookie("userid", id, -1); 
    }
}
function setCookie(name, value, days) {
    var today = new Date();
    today.setDate(today.getDate() + days);
    document.cookie = name + "=" + value + ";expires="
            + today.toGMTString() + ";";
}
function getCookie(cname) {
    var cookie = document.cookie + ";";
    console.log(cookie);
    var idx = cookie.indexOf(cname, 0);
    var val = "";
    if (idx != -1) {
        console.log(idx + "," + cookie.length);
        cookie = cookie.substring(idx, cookie.length);
        begin = cookie.indexOf("=", 0) + 1;
        end = cookie.indexOf(";", begin);
        console.log(begin + "," + end);
        val = cookie.substring(begin, end);
    }
    return val;
}
</script>
</head>
<body>
<form method="post" name="form1">
<table border="1">
    <tr>
        <td>아이디</td>
        <td>
            <input name="userid" id="userid"> 
            <input type="checkbox" id="chkSave"> 아이디 저장
        </td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><input type="password" name="passwd"></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="button" value="로그인" id="btnLogin"></td>
    </tr>
</table>
</form>
</body>
</html>