<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="createAccount" method="POST" modelAttribute="account">
<table>
	<tr>
		<td><label>Enter Name</label></td>
		<td><spring:input path="bankAccount.accountHolderName"/></td>
	</tr>
	<tr>
		<td><label>Enter Initial Balance</label></td>
		<td><spring:input path="bankAccount.accountBalance"/></td>
	</tr>
	<tr>
		<td><label>Select salaried</label></td>
		<td><spring:radiobutton path = "salary" value="Yes"/>Yes
		<spring:radiobutton path="salary" value="No"/>No</td>
	</tr>
	<tr>
		<td><input type="reset" value="clear"></td>
		<td><input type="submit" value="submit"></td>
	</tr>
</table>
</spring:form>
</body>
</html>