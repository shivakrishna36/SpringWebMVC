<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateDetails">
<table>
	<tr>
		<td><label>Account Number</label></td>
		<td><input type="text" name="accountNumber" value="${account.bankAccount.accountNumber}" readonly="readonly"></td>
	</tr>
	<tr>
		<td><label>Update Holder Name</label></td>
		<td><input type="text" name="name" value="${account.bankAccount.accountHolderName}"></td>
	</tr>
	<tr>
		<td><label>Balance</label></td>
	<td><input type="number" value="${account.bankAccount.accountBalance}" readonly="readonly"></td>
	</tr>
	<tr>
		<td><label>Select salaried</label></td>
		<td><input type="radio" name ="salary" value="Yes" ${account.salary==true?"checked":"unchecked"}>YES
		<input type="radio" name="salary" value="No"${account.salary==true?"unchecked":"checked"}> NO</td>
	</tr>
	<tr>
		<td><input type="reset" value="clear"></td>
		<td><input type="submit" value="submit"></td>
	</tr>
</table>
</body>
</html>