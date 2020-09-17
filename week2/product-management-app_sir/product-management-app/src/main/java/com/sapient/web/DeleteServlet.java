package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.service.ProductService;
import com.sapient.service.ProductServiceImpl;

@WebServlet("/delete-product")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service= new ProductServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			Integer productId = 
					Integer.parseInt(request.getParameter("productid"));
			Integer deletedId= service.deleteProduct(productId);
			if(deletedId !=null) {
				out.println("<h2>"+deletedId +" deleted</h2>");				
			}else {
				out.println("<h2>"+"Invalid Id</h2>");				
			}
			
			request
			.getRequestDispatcher("all-products")
			.forward(request, response);
			
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
