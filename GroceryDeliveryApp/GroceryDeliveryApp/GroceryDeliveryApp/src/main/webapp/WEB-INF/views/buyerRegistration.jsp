<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error{color:red}
</style>
<meta charset="ISO-8859-1">
<title>Buyer Registration page</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:20;color:Green;"><b>REGISTER:</b></p></h1></legend>  

<form:form action="buyerRegistrationProcess" method="post" modelAttribute="account"> 
		
		<label for="buyerUser">User Name:</label>
		<form:input type="text" path="buyerUser"/> 
		<br>
		<form:errors path="buyerUser" cssClass="error"/>
		<br>

		<label for="buyerPass">Password:</label>
		<form:input type="password" path="buyerPass"/> 
		<br>
		<form:errors path="buyerPass" cssClass="error"/>
		<br>
		
		<label for="buyerAddress">Address:</label>
		<form:input type="text" path="buyerAddress" />  
		<br>
		<form:errors path="buyerAddress" cssClass="error"/>
		<br>
		
		<label for="buyerPhone">Phone:</label>
		<form:input type="text" path="buyerPhone" /> 
		<br>
		<form:errors path="buyerPhone" cssClass="error"/>
		
<br>
<input type="submit" value="Submit"/>
</form:form>
</fieldset>   
</div> 
<hr>
<p style="font-size:20"><b>SessionID: ${seshID}</b></p> 
</body>
</html>