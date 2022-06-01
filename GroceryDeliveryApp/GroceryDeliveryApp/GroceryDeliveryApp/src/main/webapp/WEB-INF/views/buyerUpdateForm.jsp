<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Update Form</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:20;color:Green;"><b>Update Profile:</b></p></h1></legend>
<form:form action="buyerUpdateProcess" method="post" modelAttribute="account">
		
		<label for="buyerUser">Username</label>
		<form:input type="text" path="buyerUser" readonly="true"/><br><br>
		
		<label for="buyerAddress">Address</label>
		<form:input type="text" path="buyerAddress" /> <br><br>
		
		<label for="buyerPhone">Phone</label>
		<form:input type="text" path="buyerPhone" /> <br><br>

		<input type="submit" value="submit" />

</form:form>
</fieldset>
</div>
<hr>
SessionID: ${seshID} 
</body>
</html>