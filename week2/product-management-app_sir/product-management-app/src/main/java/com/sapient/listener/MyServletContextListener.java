package com.sapient.listener;

import java.util.Enumeration;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

      	
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
        System.out.println("Attribute added to Servlet context object");
        Enumeration<String> enumeration=
        		scae.getServletContext().getAttributeNames();
        while(enumeration.hasMoreElements()) {
        	System.out.println("-------------------------------");
        	String attributeName=enumeration.nextElement();
        	System.out.println(attributeName+":"+
        			scae.getServletContext().getAttribute(attributeName));
        }
    
    }

	
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println(sce.getClass().getName()+" destroyed");
    }

	
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println(sce.getClass().getName()+" initialized");
    }
	
}
