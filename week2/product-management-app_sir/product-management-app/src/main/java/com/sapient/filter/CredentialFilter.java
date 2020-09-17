package com.sapient.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = "/login")
public class CredentialFilter implements Filter {
	
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out= response.getWriter();
		try {
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			if(userid.equals("ravi") && password.equals("ravi@123")) {				
				out.println("<h1>You are black-listed"+"</h1>");
				request.getRequestDispatcher("login.html")
				.include(request,response);
			}else {
				chain.doFilter(request, response);				
				out.println("<h5><font color='green'>Response passed through filter</font></h5>");
				
			}
		}catch(Exception e) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,
									e.getMessage());
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
