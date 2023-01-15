package com.rest.api.main;

import static io.undertow.servlet.Servlets.listener;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.servlet.Listener;

import com.rest.api.config.JerseyConfig;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

public class Application {

	private static Undertow server;

	private static DeploymentManager deploymentManager;

	private static final int DEFAULT_PORT = 9999;

	private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

	/**
	 * Start server on the port 8080.
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		startServer(DEFAULT_PORT);
	}

	/**
	 * Start server on the given port.
	 *
	 * @param port
	 */
	public static void startServer(int port) {

		LOGGER.info(String.format("Starting server on port %d", port));

		PathHandler path = Handlers.path();

		server = Undertow.builder().addHttpListener(port, "localhost").setHandler(path).build();

		server.start();

		LOGGER.info(String.format("Server started on port %d", port));

		DeploymentInfo servletBuilder = Servlets.deployment().setClassLoader(Application.class.getClassLoader())
				.setContextPath("/").addListeners(listener(Listener.class))
				.setResourceManager(new ClassPathResourceManager(Application.class.getClassLoader()))
				.addServlets(Servlets.servlet("jerseyServlet", ServletContainer.class).setLoadOnStartup(1)
						.addInitParam("javax.ws.rs.Application", JerseyConfig.class.getName())
//                                .addInitParam("jersey.config.server.provider.packages", "com.rest.api.config")
						.addMapping("/api/*"))
				.setDeploymentName("JerseyWebServiceWithJwtRestApiDemo.war");

		LOGGER.info("Starting application deployment");

		deploymentManager = Servlets.defaultContainer().addDeployment(servletBuilder);
		deploymentManager.deploy();

		try {
			path.addPrefixPath("/", deploymentManager.start());
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}

		LOGGER.info("Application deployed");
	}

	/**
	 * Stop server.
	 */
	public static void stopServer() {

		if (server == null) {
			throw new IllegalStateException("Server has not been started yet");
		}

		LOGGER.info("Stopping server");

		deploymentManager.undeploy();
		server.stop();

		LOGGER.info("Server stopped");
	}
}