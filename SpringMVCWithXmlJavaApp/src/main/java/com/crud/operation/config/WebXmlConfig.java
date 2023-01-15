package com.crud.operation.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// Replacement of web.xml
// Step 1 :-First Implements of WebApplicationInitializer
public class WebXmlConfig implements WebApplicationInitializer {

	private XmlWebApplicationContext xmlWebApplicationContext;

	// Step 2 :- Overvide the onStartup(ServletContext servletContext)
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Step 3 :- Create the XmlWebApplicationContext Class Object and Register the
		// app-config.xml
		xmlWebApplicationContext = new XmlWebApplicationContext();
		xmlWebApplicationContext.setConfigLocation("/WEB-INF/spring-servlet.xml");

		// Step 4. Create Dispatcher Servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet();

		// Step 5:- dd DispatcherServlet object by using ServletContext class object
		ServletRegistration.Dynamic servet = servletContext.addServlet("spring", dispatcherServlet);
		
		servet.addMapping("/");
		
		servet.setLoadOnStartup(1);

	}

}
