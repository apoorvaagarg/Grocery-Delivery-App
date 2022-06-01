<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ThankYou Page</title>
</head>
<body>
<div align="center">
<c:forEach var="account" items="${buyerInfo}">
<fieldset>
<legend><h1><p style="font-size:20;color:Green;">Thank You for Patronage!</p></h1></legend>
<p> Your Grocery will be delivered to your address : ${account.buyerAddress} within 30 minutes!</p>
<p>And you will be contacted through your given phone no : ${account.buyerPhone}</p>
</fieldset>
</c:forEach>
</div>
<br>
<div align="center">
<form:form action="buyerFormUpdate">
		<input type="submit" value="Update Profile" />
</form:form>
</div>
<br>
<div align="center">
<form:form action="logOut">
		<input type="submit" value="Finish and Logout" />
</form:form>
</div>
<hr>
SessionID: ${seshID} 
</body>
</html>