<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://www.google.com/jsapi"></script>
<script>
google.load("visualization", "1", { "packages": ["corechart"] });
google.setOnLoadCallback(drawChart);

function drawChart() {
	fetch("<%=request.getContextPath()%>/chart_servlet/cart_money_list.do")
	.then(response => response.json() )
	.then( json_data => {
		const data = new google.visualization.DataTable(json_data);
		const chart = new google.visualization.PieChart(document.getElementById("chart_div"));
		chart.draw(data, {
			title: "차트 예제",
			width: 600,
			height: 440
		});
	});
}
</script>
</head>
<body>
<div id="chart_div"></div>
<button type="button" onclick="drawChart()">refresh</button>
</body>
</html>