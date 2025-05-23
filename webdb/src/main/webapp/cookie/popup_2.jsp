<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
document.addEventListener('DOMContentLoaded', function () {
	const checkbox = document.getElementById('nopopup');

	checkbox.addEventListener('click', function () {
		const val = this.checked ? 'N' : 'Y';
		setCookie('showCookies', val, 7);
	});
	
	function setCookie(cname, cvalue, days) {
		const d = new Date();
		d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000));
		const expired = 'expired=' + d.toUTCString();
		document.cookie = `${cname}=${cvalue}; ${expires}; path=/`;
		
		setTimeout(() => window.close(), 100);
	}
});
</script>
</head>
<body>
	<input type="checkbox" id="nopopup"> 7일간 보이지 않기
</body>
</html>