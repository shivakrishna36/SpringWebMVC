<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="depositMoney">
<table>
<tr>
		<td><label>Enter Account Number</label></td>
		<td><input type="number" name="accountNumber"/></td>
	</tr>
	<tr>
		<td><label>Enter amount to deposit</label></td>
		<td><input type="number" name="accountBalance"/></td>
	</tr>
	<tr><td><input type="submit" value="deposit"></td></tr>
	</table>
	</form>
</body>
</html>