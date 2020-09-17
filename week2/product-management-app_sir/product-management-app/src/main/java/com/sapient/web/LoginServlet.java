package com.sapient.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			if(userid.equals("admin") && password.equals("admin@123")) {
				
				ServletContext context=this.getServletContext();
				context.setAttribute("org","Sapient");
				HttpSession session=request.getSession();
				session.setAttribute("userid", userid);
				out.println("<h1>Welcome To Product Management System,"+
								session.getAttribute("userid")+"<h/>");
				request.getRequestDispatcher("WEB-INF/views/menu.jsp")
				.include(request,response);
			}else {
				out.println("<h1><font color='red'>Invalid Credentials</font></h1>");
				request.getRequestDispatcher("login.html")
										.include(request,response);
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
