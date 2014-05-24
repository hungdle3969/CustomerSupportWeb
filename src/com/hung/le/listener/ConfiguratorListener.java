package com.hung.le.listener;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hung.le.filter.AuthenticationFilter;
import com.hung.le.filter.LoggingFilter;

/*
 * This class used to add the filter. Ofcourse, you can configure new filters via annotations or in deployment descriptor if
 * you want to. In this application, the authentication filter will replace login code in ticketServlet and sessionServlet
 * 
 */
public class ConfiguratorListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext context = event.getServletContext();
		//register the new filters
		FilterRegistration.Dynamic registration = context.addFilter("loggingFilter",  new LoggingFilter());
		registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE,
														DispatcherType.FORWARD, DispatcherType.ERROR), false, "/*");
		
		registration = context.addFilter("authenticationFilter", new AuthenticationFilter());
		registration.setAsyncSupported(true);
		registration.addMappingForUrlPatterns(null, false, "/tickets", "/chat", "/sessions");
	}

	
}
