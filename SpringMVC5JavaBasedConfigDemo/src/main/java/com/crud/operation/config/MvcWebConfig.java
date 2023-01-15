package com.crud.operation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// Repalcement of spring-servlet.xml
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.crud.operation"})
//public class MvcWebConfig implements WebMvcConfigurer {
//
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/views/", ".jsp");
//	}
//
//}

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.crud.operation"})
//public class MvcWebConfig extends WebMvcConfigurerAdapter {
//
//	@Bean
//	public InternalResourceViewResolver resolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//
//}

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.crud.operation.controllers" })
public class MvcWebConfig extends WebMvcConfigurationSupport {

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
