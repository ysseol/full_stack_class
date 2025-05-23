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
    $("#nopopup").click(function() {
        var now = new Date();
        var val = "";
        if (this.checked == true) {
            val = "N"; 
        } else {
            val = "Y"; 
        }
        setCookie("showCookies", val, 7);
    });
});
function setCookie(cname, cvalue, days) {
    var d = new Date();
    d.setDate(d.getDate() + days);
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + ";" + expires;
    window.close(); 
}
</script>
</head>
<body>
  <input type="checkbox" id="nopopup">
  7일간 보이지 않기
</body>
</html>