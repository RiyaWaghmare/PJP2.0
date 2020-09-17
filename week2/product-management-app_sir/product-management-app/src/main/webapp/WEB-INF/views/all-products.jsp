<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<jsp:useBean id="productList" 
			type="java.util.ArrayList" scope="session"/>
			
	<div class="container" class="bg-img">
				  	<h2>Product Details</h2>
				  
				  <table class="table">
					    <thead>
						      <tr>
						        <th>Product Id</th>						        
						        <th>Product Name</th>
						        <th>Product Description</th>
						         <th>Expiry Date</th>
						        <th>Product Price</th>						        
						        <th>Edit</th>
						        <th>Delete</th>
						      </tr>
					    </thead>
					    <tbody>					    	
					    	<c:forEach var="p" items="${productList}">
						      <tr class="success">
						        <td>${p.productId}</td>				        
						        <td>${p.productName}</td>
						        <td>${p.description}</td>
						        <td>${p.expiryDate}</td>
						        <td>${p.productPrice}</td>						        				        
						        <td><a href="http://localhost:8090/product-management-app/edit-product?productid=${p.productId}">edit</a></td>
						        <td><a href="http://localhost:8090/product-management-app/delete-product?productid=${p.productId}">delete</a></td>
						      </tr>      
						    </c:forEach>
					    </tbody>
				  </table>
			</div>
</body>
</html>