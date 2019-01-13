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
		<th><a href="sortByCurrentNumber">Account Number</a></th>
		<th><a href="CurrentsortByName">Account Holder Name</a></th>		
		<th><a href="sortByCurrentBalance">Account Balance</a></th>
		<th>Salaried</th>
		<th><a href="sortByOdlimit">Over Draft Limit</a></th>
		<th>Type Of Account</th>
	</tr>

<details:forEach var="account" items="${accounts}">
	<tr>
		<td>${account.bankAccount.accountNumber}</td>
		<td>${account.bankAccount.accountHolderName}</td>
		<td>${account.bankAccount.accountBalance}</td>
		<td>${"N/A"}</td>
		<td>${account.odlimit}
		<td>${"Current"}</td>
	</tr>
	</details:forEach>
	</table>
</body>
</html>