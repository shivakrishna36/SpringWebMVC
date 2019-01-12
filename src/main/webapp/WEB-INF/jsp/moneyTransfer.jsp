<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FundTransfer">
<table>
	<tr>
		<td><label>Enter sender account number:</label></td>
		<td><input type="number" name="sender"/></td>
	</tr>
	<tr>
		<td><label>Enter receiver account number:</label></td>
		<td><input type="number" name="receiver"/></td>
	</tr>
	<tr>
		<td><label>Enter amount to transfer:</label></td>
		<td><input type="number" name="amountToTransfer"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Ok"/></td>
	</tr>
</table>
</form>
</body>
</html>