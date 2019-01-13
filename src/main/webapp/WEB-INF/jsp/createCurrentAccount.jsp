<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
		color: red;
		}
</style>
</head>
<body>
<spring:form action="createNewAccount" method="POST" modelAttribute="account">
<table>
	<tr>
		<td><label>Enter Name</label></td>
		<td><spring:input path="bankAccount.accountHolderName"/><spring:errors path="bankAccount.accountHolderName" cssClass="error" /><</td>
		
	</tr>
	<tr>
		<td><label>Enter Initial Balance</label></td>
		<td><spring:input path="bankAccount.accountBalance"/><spring:errors path="bankAccount.accountBalance" cssClass="error" /></td>
	</tr>
	<tr>
		<td><label>Enter odlimit</label></td>
		<td><spring:input path = "odlimit" /><spring:errors path="odlimit" cssClass="error" /></td>
	</tr>
	<tr>
		<td><input type="reset" value="clear"></td>
		<td><input type="submit" value="submit"></td>
	</tr>
</table>
</spring:form>
</body>
</html>