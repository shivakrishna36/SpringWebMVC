<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<tr>
		<td>${account.bankAccount.accountNumber}</td>
		<td>${account.bankAccount.accountHolderName}</td>
		<td>${account.bankAccount.accountBalance}</td>
		<td>${"N/A"}</td>
		<td>${account.odlimit}
		<td>${"Current"}</td>
	</tr>
	
	</table>
</body>
</html>