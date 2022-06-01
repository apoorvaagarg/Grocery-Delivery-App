<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Update Form</title>
</head>
<body>
<form:form action="itemUpdateProcess" method="post" modelAttribute="grocery">
		
		<label for="itemCode">Item Code</label>
		<form:input type="text" path="itemCode" readonly="true"/> <br><br>

		<label for="itemName">Item Name</label>
		<form:input type="text" path="itemName" readonly="true" /> <br><br>
		
		<label for="itemQuantity">Item Quantity</label>
		<form:input type="text" path="itemQuantity" /> <br><br>
		
		<label for="itemPrice">Item Price</label>
		<form:input type="text" path="itemPrice" /> <br><br>
		
		<label for="itemDiscount">Item Discount</label>
		<form:input type="text" path="itemDiscount" /> <br><br>

		<input type="submit" value="submit" />

</form:form>
<hr>
SessionID: ${seshID} 
</body>
</html>