package com.rest.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.rest.controllers.AuthController;
import com.rest.controllers.EchoEndpoint;
import com.rest.filters.JWTTokenNeededFilter;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(EchoEndpoint.class);
		register(JWTTokenNeededFilter.class);
		register(AuthController.class);
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}

}