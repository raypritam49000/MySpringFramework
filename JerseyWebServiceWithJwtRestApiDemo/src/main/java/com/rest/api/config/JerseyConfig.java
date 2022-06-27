package com.rest.api.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
// Deployment of a JAX-RS application using @ApplicationPath with Servlet 3.0
// Descriptor-less deployment
import org.glassfish.jersey.server.ResourceConfig;

import com.rest.api.controller.AuthenticationController;
import com.rest.api.controller.GreetingResource;
import com.rest.api.controller.UserControllers;
import com.rest.api.controller.UserResource;
import com.rest.api.exception.AccessDeniedExceptionMapper;
import com.rest.api.exception.AuthenticationExceptionMapper;
import com.rest.api.exception.AuthenticationTokenRefreshmentExceptionMapper;
import com.rest.api.filters.AuthenticationFilter;
import com.rest.api.filters.AuthorizationFilter;
import com.rest.api.provider.ObjectMapperProvider;

@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// packages("com.rest.api.controller");
		register(UserControllers.class);
		register(AuthenticationController.class);
		register(GreetingResource.class);
		register(UserResource.class);

		register(AuthenticationFilter.class);
		register(AuthorizationFilter.class);

		register(AccessDeniedExceptionMapper.class);
		register(AuthenticationExceptionMapper.class);
		register(AuthenticationTokenRefreshmentExceptionMapper.class);
		
		register(ObjectMapperProvider.class);
		
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
				LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}
}