<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(function(){
    $("#btnWrite").click(function(){
        location.href="<%=request.getContextPath()%>/board/write.jsp";
    });
});
function list(page){
    location.href="<%=request.getContextPath()%>/board_servlet/list.do?cur_page=" + page + "&search_option=${search_option}&keyword=${keyword}";
}
</script>
</head>

<body class="p-4">

<h2 class="mb-4">게시판</h2>

<form name="form1" method="post" action="<%=request.getContextPath()%>/board_servlet/search.do" class="d-flex flex-wrap gap-2 mb-4 align-items-center">
	<select name="search_option" class="form-select w-auto">
    	<c:choose>
        	<c:when test="${search_option == null || search_option == 'all' }">
           		<option value="all" selected>전체검색</option>
       	    	<option value="writer">이름</option>
       	    	<option value="subject">제목</option>
            	<option value="contents">내용</option>
        	</c:when>
	        <c:when test="${search_option == 'writer' }">
	            <option value="all">전체검색</option>
	            <option value="writer" selected>이름</option>
	            <option value="subject">제목</option>
	            <option value="contents">내용</option>
	        </c:when>
	        <c:when test="${search_option == 'subject' }">
	            <option value="all">전체검색</option>
	            <option value="writer">이름</option>
	            <option value="subject" selected>제목</option>
	            <option value="contents">내용</option>
	        </c:when>
			<c:when test="${search_option == 'contents' }">
			    <option value="all">전체검색</option>
			    <option value="writer">이름</option>
			    <option value="subject">제목</option>
			    <option value="contents" selected>내용</option>
			</c:when>
		</c:choose>
	</select>
	<input name="keyword" value="${keyword}" class="form-control w-auto">
	<input type="submit" value="검색" id="btnSearch" class="btn btn-primary">
	<button type="button" id="btnWrite" class="btn btn-success">글쓰기</button>
</form>

<table class="table table-bordered table-hover table-sm text-center" style="width: 900px;">
    <thead class="table-light">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>제목</th>
        <th>날짜</th>
		<th>조회수</th>
		<th>첨부파일</th>
		<th>다운로드</th>
	</tr>
	</thead>
	<tbody>
   	<c:forEach var="dto" items="${list}">
       <tr>
           <td>${dto.num}</td>
           <td>${dto.writer}</td>
           <td class="text-start">
               <c:forEach var="i" begin="1" end="${dto.re_depth}">
                   &nbsp;&nbsp;
               </c:forEach>
               <c:if test="${dto.re_depth > 0}">Re:</c:if>
               <a href="<%=request.getContextPath()%>/board_servlet/view.do?num=${dto.num}">${dto.subject}</a>
               <c:if test="${dto.count_comments > 0}">
                   <span class="text-success">(${dto.count_comments})</span>
               </c:if>
           </td>
		<td>${dto.reg_date}</td>
		<td>${dto.hit}</td>
		<td>
		    <c:if test="${dto.filesize > 0}">
		        <a href="<%=request.getContextPath()%>/board_servlet/download.do?num=${dto.num}">
		            <img src="../images/file_small.png" width="30" height="30">
		        </a>
		    </c:if>
		</td>
		<td>${dto.down}</td>
	</tr>
	</c:forEach>
	</tbody>
	<tfoot>
   	<tr>
        <td colspan="7">
            <c:if test="${page.curPage > 1}">
                <a href="#" onclick="list('1')">[처음]</a>
            </c:if>
        		<c:if test="${page.curBlock > 1}">
				<a href="#" onclick="list('${page.prevPage}')">[이전]</a>
			</c:if>
			<c:forEach var="num" begin="${page.blockStart}" end="${page.blockEnd}">
			    <c:choose>
			        <c:when test="${num == page.curPage}">
			            <span class="text-danger">${num}</span>
			        </c:when>
			        <c:otherwise>
			            <a href="#" onclick="list('${num}')">${num}</a>
			        </c:otherwise>
			    </c:choose>
			</c:forEach>
			<c:if test="${page.curBlock < page.totBlock}">
			    <a href="#" onclick="list('${page.nextPage}')">[다음]</a>
			</c:if>
			<c:if test="${page.curPage < page.totPage}">
			    <a href="#" onclick="list('${page.totPage}')">[마지막]</a>
			</c:if>
		</td>
	</tr>
	</tfoot>
</table>
</body>
</html>
