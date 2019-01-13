<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="withdrawMoney">
<table>
<tr>
		<td><label>Enter Account Number</label></td>
		<td><input type="number" name="accountNumber"/></td>
	</tr>
	<tr>
		<td><label>Enter amount to withdraw</label></td>
		<td><input type="number" name="accountBalance"/></td>
	</tr>
	<tr><td><input type="submit" value="withdraw"></td></tr>
	</table>
	</form>
</body>
</html>