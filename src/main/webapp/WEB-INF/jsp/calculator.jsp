<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<spring:url value="css/style.css" />">
<script type="text/javascript" src="webjars/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="<spring:url value="js/rpnCalculator.js"/> " ></script>
    <meta charset="UTF-8">
    <title>RPN calculator</title>
</head>
<body>
<div id="header">RPN Library test site
</div>

<div class="mainWindow">
	<table>
		<tr>
		<th colspan = "2" id="windowTitle">RPNLibrary 2.0</th>
		</tr>
		<tr>
			<th>Equation</th>
			<th>Result</th>
		</tr>
		<tr>
			<td><input type="text" id="source"/></td>
			<td><input type="text" id="result" readonly/></td>
		<tr>
			<td colspan="2" align="right"> <input type="button" onclick="calculate()" value="Execute"/></td>
		<tr>
		</tr>
	</table>
</div>
<div class="errors">
	<table>
		<tr>
			<th colspan="2" id="errorTitle">Error</th>
		</tr>
		<tr>
			<td><span id="errorCode"></span></td>
		</tr>
		<tr>
			<td><span id="errorMessage"></span></td>
		</tr>
	</table>
</div>

<div class="yellow-notes-right">
		RPN Library works with:</br>
		+, -, *, /, , ^ (power)</br>
		You can also use functions:</br>
		sin(), cos(), tg(), ctg()</br>
	
</div>

</body>
</html>