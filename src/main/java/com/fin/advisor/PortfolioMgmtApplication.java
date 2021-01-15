package com.fin.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.fin.advisor.config.ApplicationConfig;

/**
 * @author rajesh.kumar
 * Application Startup class.
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
public class PortfolioMgmtApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("configure() <<");
		return application.sources(ApplicationConfig.class);
	}
	
	public static void main(String[] args) {
		logger.info("main() <<");
		SpringApplication.run(PortfolioMgmtApplication.class, args);
		logger.info("main() >>");
	}
}
