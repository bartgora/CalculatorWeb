<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<spring:url value="css/style.css" />">
    <meta charset="UTF-8">
    <title>RPN calculator</title>
</head>
<body>

<div class="mainWindow">
	<table>
		<tr>
			<th>Równianie</th>
			<th>Wynik</th>
		</tr>
		<tr>
		<td><input type="text" /></td>
		<td><input type="text" readonly/></td>
		<tr>
		<td colspan="3"> <input type="button" onclick="calculate()" value="Oblicz"/></td>
		<tr>
		</tr>
	</table>
</div>

</body>
</html>