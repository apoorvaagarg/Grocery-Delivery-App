<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Page</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:20;color:Green;"><b>Bill:</b></p></h1></legend>

	<table border=1>
		<thead>
			<tr>
				<td>Item Name</td>
				<td>Quantity Taken</td>
				<td>Price</td>
				
			</tr>
		</thead>

		
		<c:forEach var="grocery" items="${FinalBillItems}">
			<tr>
				<td align="center">${grocery.itemName}</td>
				<td align="center">${grocery.quantity}</td>
				<td align="center">${grocery.itemPrice}</td>
			</tr>
		</c:forEach>

	</table>
	

<Br>


<form:form action="backToShop">
		<input type="submit" value="Edit Cart" />
</form:form>
</div>
</fieldset>


<div align="center">
	<br>
	<div align="center">
	<table border=1>
		<thead>
			<tr>
				<td>Total No. of Items</td>
				<td>Final Amount</td>				
			</tr>
		</thead>

		
		<c:forEach var="grocery" items="${FinalBillAmount}">
			<tr>
				<td align="center">${grocery.quantity}</td>
				<td align="center">${grocery.itemPrice}</td>
			</tr>
		</c:forEach>

	</table>
	</div>

<Br>

<form:form action="buyerPayment">
		<input type="submit" value="Pay" />
</form:form>
</div>
<hr>
SessionID: ${seshID} 
</body>
</html>