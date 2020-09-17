package com.sapient.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestListenerDemo implements ServletRequestListener {
	private static int count=0;
	
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.print("The Request object destroyed at :"+new java.util.Date());
	}
	public void requestInitialized(ServletRequestEvent sre) {
		count++;
		System.out.print("Request Object created At:"+ new java.util.Date());
		System.out.print("The hit count for this web application :"+count);
	}
} 