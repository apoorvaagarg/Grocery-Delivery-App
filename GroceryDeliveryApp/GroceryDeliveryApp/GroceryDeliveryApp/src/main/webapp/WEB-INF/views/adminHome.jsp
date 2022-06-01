<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Workspace</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:25;color:Green;"><b>Grocery Items</b></p></h1></legend>

	
	<table border=2>
		<thead>
			<tr>
				<td>Code</td>
				<td>Name</td>
				<td>Price(per)</td>
				<td>Quantity(kg/piece)</td>
				<td>Discount(in %)</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>

		
		<c:forEach var="grocery" items="${groceries}">
			<tr>
				<td align="center">${grocery.itemCode}</td>
				<td align="center">${grocery.itemName}</td>
				<td align="center">${grocery.itemPrice}</td>
				<td align="center">${grocery.itemQuantity}</td>
				<td align="center">${grocery.itemDiscount}</td>
				<td align="center">
				<a href = "adminFormUpdate?itemId=${grocery.itemCode}"> Edit </a>
				</td>
				<td align="center">
				<a href = "adminDeleteItem?itemId=${grocery.itemCode}" onclick = "if (!(confirm('Do you really want to delete this Grocery Item?'))) return false"> Delete </a>
				</td>
			</tr>
		</c:forEach>

	</table>
	</div>
<Br>
</fieldset>

<div align="center">

<form:form action="adminFormInsert">
		<input type="submit" value="Add Items" />
</form:form>
<Br> 
 
<form:form action="logOut">
		<input type="submit" value="Log Out" />
</form:form>
</div>
<hr>
SessionID: ${seshID} 
</body>
</html>