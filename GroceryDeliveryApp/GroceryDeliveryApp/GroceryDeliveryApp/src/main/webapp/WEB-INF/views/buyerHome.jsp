<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop for buyer</title>
</head>
<body>
<div align="right">
<form:form action="buyerFormUpdate">
		<input type="submit" value="Update Profile" />
</form:form>
<form:form action="logOut">
		<input type="submit" value="Logout" />
</form:form>

</div>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:25;color:Green;"><b>Grocery Items</b></p></h1></legend>
	<table border=1>
		<thead>
			<tr>
				<td>Code</td>
				<td>Name</td>
				<td>Rate(per)</td>
				<td>Quantity(kg/piece)</td>
				<td>Add to Cart</td>
			</tr>
		</thead>

		
		<c:forEach var="grocery" items="${groceries}">
			<tr>
				<td align="center">${grocery.itemCode}</td>
				<td align="center">${grocery.itemName}</td>
				<td align="center">${grocery.itemPrice}</td>
				<td align="center">${grocery.itemQuantity}</td>
				<td align="center">
				<a href = "buyerAddtoCart?cItemId=${grocery.itemCode}"> Select </a>
				</td>
			</tr>
		</c:forEach>

	</table>
</fieldset>
</div>
	<Br>

<div align="center">
<form:form action="buyerHomePage">
Search for item: <input type="text" name="sitem"/><br><br><input type="submit" value="Search" />
</form:form>
<Br>

<a href="buyerHomePage?order=asc">Price: Low to High </a>
<br><br>
<a href="buyerHomePage?order=desc">Price: High to Low </a>


</div>
 <hr>

<div align="center">
<fieldset>
<legend><h2><p style="font-size:20;color:Green;"><b>Cart Items</b></p></h2></legend>
	<table border=1>
		<thead>
			<tr>
				<td>Name</td>
				<td>Rate(Price per piece/kg)</td>
				<td>Remove from cart</td>
			</tr>
		</thead>

		
		<c:forEach var="grocery" items="${cItems}">
			<tr>
				<td align="center">${grocery.itemName}</td>
				<td align="center">${grocery.itemPrice}</td>
				<td align="center">
				<a href = "buyerDeletefromCart?cItemInt=${grocery.itemRan}" onclick = "if (!(confirm('Do you want to Remove this item from Cart?'))) return false"> Remove </a>
				</td>
			</tr>
		</c:forEach>

	</table>
</fieldset>
</div>
<Br>
 
<div align="center">
<form:form action="checkOut">
		<input type="submit" value="Buy Cart" />
</form:form>
</div>
<br>
<hr> 
SessionID: ${seshID} 
</body>
</html>