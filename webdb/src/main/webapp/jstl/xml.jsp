<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<x:parse var="xmldata">
	<items>
		<item>
			<model>갤럭시</model>
			<company>SKT</company>
			<product>삼성</product>
		</item>
		<item>
			<model>아이폰</model>
			<company>KT</company>
			<product>애플</product>
		</item>
		<item>
			<model>G2</model>
			<company>LG U+</company>
			<product>LG</product>
		</item>
	</items>
</x:parse>
<table border="1">
	<tr align="center">
		<th>모델</th>
		<th>통신사</th>
		<th>제조사</th>
	</tr>
<x:forEach select="$xmldata//item">
	<tr>
		<td><x:out select="./model" /></td>
		<td><x:out select="./company" /></td>
		<td>
			<x:choose>
				<x:when select="./product!='unKnown'">
					<x:out select="./product" />
				</x:when>
				<x:otherwise>[알 수 없음]</x:otherwise>
			</x:choose>
		</td>
	</tr>
</x:forEach>
</table>
</body>
</html>