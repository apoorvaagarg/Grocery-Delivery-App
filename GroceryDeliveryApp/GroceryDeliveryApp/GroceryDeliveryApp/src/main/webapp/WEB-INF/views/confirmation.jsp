<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>

<div align="center">
<fieldset>
<legend><h2><p style="font-size:15;color:Red;"><b>Username or Password Incorrect</b></p></h2></legend>  

<form:form action="goBack">
		<input type="submit" value="Go to Home Page" />
</form:form>
</fieldset></div>
<hr>
SessionID: ${seshID} 
</body>
</html>