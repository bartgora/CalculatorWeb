﻿<!DOCTYPE html>
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
		<th colspan = "2" id="windowTitle">RPNLibrary 3.0.0</th>
		</tr>
		<tr>
			<th>Equation</th>
			<th>Result</th>
		</tr>
		<tr>
			<td><input type="text" id="source"/></td>
			<td><input type="text" id="result" readonly/></td>
		<tr>
			<td colspan="2" align="right"> <input id="submitButton" type="button" onclick="calculate()" value="Execute"/></td>
		<tr>
		</tr>
		<tr>
		    <td>
				RPN Library works with: +, -, *, div, , ^ (power)</br>
        		You can also use functions: sin(), cos(), tg(), ctg()</br>
		    </td>
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


</body>
</html>