package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.service.Product;
import com.sapient.service.ProductService;
import com.sapient.service.ProductServiceImpl;

@WebServlet("/all-products")
public class AllProductsServlet extends HttpServlet {
	private static ProductService service=new ProductServiceImpl();
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		try {
			List<Product> productList=service.getAllProducts();
			productList.stream().forEach(System.out::println);
//			request.setAttribute("productList", productList);
			HttpSession session=request.getSession(false);
			if(session !=null) {
				session.setAttribute("productList", productList);
				request
				.getRequestDispatcher("WEB-INF/views/all-products.jsp")
				.forward(request, response);
			}else {
				request
				.getRequestDispatcher("login.html")
				.include(request, response);
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
