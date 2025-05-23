<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
document.addEventListener('DOMContentLoaded', function () {
	const useridInput = document.getElementById('userid');
	const chkSave = document.getElementById('chkSave');
	const btnLogin = document.getElementById('btnLogin');
	
	const show = getCookie('showCookies');
	if (show === '' || show === 'Y') {
		window.open('popup.jsp', '', 'width=300,height=400');
	}
	
	const cookie_userid = getCookie('userid');
	if (cookie_userid !== '') {
		useridInput.value = cookie_userid;
		chkSave.checked = true;
	}
	
	btnLogin.addEventListener('click', function () {
		if (chkSave.checked) {
			saveCookie(useridInput.value);
		} else {
			saveCookie('');
		}
	});
	
	chkSave.addEventListener('click', function () {
		if (chkSave.checked) {
			const result = confirm('로그인 정보를 저장하시겠습니까?');
			if (!result) {
				chkSave.checked = false;
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
	const today = new Date();
	today.setDate(today.getDate() + days);
	document.cookie = `${name}=${value}; path=/webdb; expires=${today.toUTCString()};`;
}

function getCookie(name) {
	const cookies = document.cookie.split(';');
	for (let cookie of cookies) {
		let [key, val] = cookie.trim().split('=');
		if (key === name) {
			return val;
		}
	}
	return '';
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
			<td colspan="2" align="center">
				<input type="button" value="로그인" id="btnLogin">
			</td>
		</tr>
	</table>
</form>
</body>
</html>