<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="http://localhost:8090/product-management-app/css/style1.css" rel="stylesheet">
<script type="text/javascript" src="http://localhost:8090/product-management-app/js/product-validate.js"></script>
</head>
<body>
	<div class="bg-img" >
		<form action="product-registration" method="post" class="container1" onsubmit="return validate()">
			<h2 align="center">Product Registration</h2>
			
			<!-- <label for="product"><b>Enter Product Name</b></label>  -->
			<input type="text" placeholder="Enter Product name"  id="productname" name="productname" required onblur="isValidProductName()" >
			<!-- <label for="description"><b>Enter Description</b></label>  -->
			<input type="text"placeholder="Enter description" id="description" name="description">
			<!-- <label for="expirydate"><b>Enter Expiry Date</b></label>  -->
			<input type="text" placeholder="Enter expiry date(dd/mm/yyyy)" size=30  id="expirydate" name="expirydate" >
			<!-- <label for="price"><b>Enter Price</b></label>  -->
			<input type="text" placeholder="Enter Price" id="price" size=30 name="price"  onblur="isValidPrice()">
			
			<br>
			<input type="submit" value="Register">		
		</form>
	</div>	
</body>
</html>