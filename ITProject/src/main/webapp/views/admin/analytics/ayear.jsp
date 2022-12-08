<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/admin-analytics/ayear" method ="get">
		<label for="birthday">Time</label> <input type="date" id="date"
			name="date"> <input id="statuson" class="form-check-input"
			type="radio" name="status" value="true"> <label
			for="statuson" class="form-check-label">Order</label> <input
			id="statusoff" class="form-check-input" type="radio" name="status"
			value="false"> <label for="statusoff"
			class="form-check-label">Total Money</label> <input type="submit">
	</form>

	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>

	<div class="column">

		<!--Div for our chart -->
		<div id="chart"></div>

		<!-- load Google AJAX API -->
		<script type="text/javascript" src="http://www.google.com/jsapi"></script>
		<script type="text/javascript">
		//load the Google Visualization API and the chart
		google.load('visualization', '1', {
			'packages' : [ 'columnchart' ]
		});

		//set callback
		google.setOnLoadCallback(createChart);

		//callback function
		function createChart() {

			//create data table object
			var dataTable = new google.visualization.DataTable();

			//define columns
			dataTable.addColumn('string', 'Quarters 2009');
			dataTable.addColumn('number', '${column_properities}');  // thay đổi cái cột xanh xanh 

			//define rows of data
			//dataTable.addRows([ [ '${name}'', 20 ] ]);
			dataTable.addRows([['1', ${total1}],['2', ${total2}],['3', ${total3}],['4', ${total4}],['5', ${total5}],['6', ${total6}],['7', ${total7}],['8', ${total8}],['9', ${total9}],['10', ${total10}],['11', ${total11}],['12', ${total12}]]);

			//instantiate our chart object
			var chart = new google.visualization.LineChart(document
					.getElementById('chart'));

			//define options for visualization
			var options = {
				width : 800,
				height : 300,
				is3D : false,
				title : '${title}'
			};

			//draw our chart
			chart.draw(dataTable, options);

		}
	</script>
	</div>
</body>
</html>