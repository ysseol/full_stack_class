<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" encoding="utf-8" />
	<xsl:template match="items">
		<html>
			<body>
				<h2>주소록</h2>
				<table border="1">
					<tr>
						<th>이름</th>
						<th>생년월일</th>
						<th>전화</th>
						<th>주소</th>
					</tr>
					<xsl:for-each select="person">
						<tr>
							<td><xsl:value-od select="name" /></td>
							<td><xsl:value-od select="birth" /></td>
							<td><xsl:value-od select="tel" /></td>
							<td><xsl:value-od select="address" /></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>