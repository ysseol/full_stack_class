<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
a:link, a:visited {
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}

a:active {
	color: yellow;
	text-decoration: none;
}
</style>
</head>
<body class="bg-light">
	<div class="container my-5">
		<h2 class="text-center mb-4">사원 목록</h2>
		<table class="table table-bordered table-hover text-center">
			<thead class="table-dark">
				<tr>
					<th>사번</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${list}">
					<tr>
						<td>${row.empno}</td>
						<td>${row.ename}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<div class="d-flex justify-content-center flex-wrap gap-2 mt-3">
							<c:if test="${page.curPage > 1}">
								<a class="btn btn-outline-secondary btn-sm" href="#"
									onclick="list('1')">처음</a>
							</c:if>

							<c:if test="${page.curBlock > 1}">
								<a class="btn btn-outline-secondary btn-sm" href="#"
									onclick="list('${page.prevPage}')">이전</a>
							</c:if>

							<c:forEach var="num" begin="${page.blockStart}"
								end="${page.blockEnd}">
								<c:choose>
									<c:when test="${num == page.curPage}">
										<span class="btn btn-danger btn-sm disabled">${num}</span>
									</c:when>
									<c:otherwise>
										<a class="btn btn-outline-primary btn-sm" href="#"
											onclick="list('${num}')">${num}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${page.curBlock < page.totBlock}">
								<a class="btn btn-outline-secondary btn-sm" href="#"
									onclick="list('${page.nextPage}')">다음</a>
							</c:if>

							<c:if test="${page.curPage < page.totPage}">
								<a class="btn btn-outline-secondary btn-sm" href="#"
									onclick="list('${page.totPage}')">마지막</a>
							</c:if>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>
