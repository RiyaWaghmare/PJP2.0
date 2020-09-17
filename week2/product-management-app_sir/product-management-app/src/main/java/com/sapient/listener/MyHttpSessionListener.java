package com.sapient.listener;

import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Session object created whose jsessionid= "+se.getSession().getId());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("Session object destroyed");
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         Enumeration enumeration=se.getSession().getAttributeNames();
         while(enumeration.hasMoreElements()) {
        	 String attributeName= (String) enumeration.nextElement();
        	 System.out.println(attributeName+":"+
        			 			se.getSession().getAttribute(attributeName));
         }
    }

	
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
