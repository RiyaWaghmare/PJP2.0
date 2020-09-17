package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.service.Product;
import com.sapient.service.ProductService;
import com.sapient.service.ProductServiceImpl;

@WebServlet("/product-registration")
public class ProductRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductService service= 
							new ProductServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String productName=request.getParameter("productname");
			String description=request.getParameter("description");
			double price=
					Double.parseDouble(request.getParameter("price"));
			SimpleDateFormat dateFormat=
							new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date expDate=
					dateFormat.parse(request.getParameter("expirydate"));
			Product product =
					new Product(productName,description,expDate,price);
			Integer productId=service.addNewProduct(product);
			if(productId!=null) {
				out.println("<h2>Product Registered</h2>");
			}else {
				out.println("<h2>Product Registration Failed</h2>");
			}
			
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
					e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
