<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Add Form</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1><p style="font-size:20;color:Green;"><b>Insert Items:</b></p></h1></legend>

<form action="itemInsertProcess" method="post">

Item Code 
<input type="text" name="itemCode" required="required"/><br/><br/>   
Item Name 
<input type="text" name="itemName" required="required"/><br/><br/>		
Item Price 
<input type="text" name="itemPrice"/><br/><br/>	
Item Quantity 
<input type="text" name="itemQuantity"/><br/><br/>	
Item Discount 
<input type="text" name="itemDiscount"/><br/><br/>	
	<input type="submit" value="submit" />
</form>
</fieldset>
</div>

<hr>
SessionID: ${seshID} 
</body>
</html>