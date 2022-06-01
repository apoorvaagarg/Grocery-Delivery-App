<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Login</title>
</head>
<body>
<div align="center">
<form action="buyerloginProcess"  method="post"> 
<fieldset>
<legend><h1><p style="font-size:20;color:Green;"><b>Login as Customer:</b></p></h1></legend>  
	<b>Username:</b> 
<input type="text" name="username" required="required"/><br/><br/>   
	<b>Password:</b> 
<input type="password" name="password" required="required"/><br/><br/>
 <br>
<input type="submit" value="Submit"/><br><br/>

<a href="buyerRegistrationForm">Not a registered user? Click here.</a>
</fieldset>   
</form>
</div> 
<hr>
<p style="font-size:20"><b>SessionID: ${seshID}</b></p> 
</body>
</html>