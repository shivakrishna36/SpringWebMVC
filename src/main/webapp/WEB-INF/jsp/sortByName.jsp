<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="details" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

<tr>
		<th><a href="sortByAccountNumber">Account Number</a></th>
		<th><a href="sortByName">Holder Name</a></th>		
		<th><a href="sortByBalance">Balance</a></th>
		<th><a href="sortBySalaried">Salaried</a></th>
		<th>Over Draft Limit</th>
		<th>Type Of Account</th>
	</tr>

<details:forEach var="account" items="${account}">
	<tr>
		<td>${account.bankAccount.accountNumber}</td>
		<td>${account.bankAccount.accountHolderName}</td>
		<td>${account.bankAccount.accountBalance}</td>
		<td>${account.salary==true?"YES":"NO"}
		<td>${"N/A"}</td>
		<td>${"Savings"}</td>
	</tr>
	</details:forEach>
	</table>
</body>
</html>