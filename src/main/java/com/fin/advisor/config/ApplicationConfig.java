package com.fin.advisor.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rajesh.kumar
 * Web MVC configurer for Swagger.
 */
@EnableSwagger2
public class ApplicationConfig implements WebMvcConfigurer{
	
private static final String DOCUMENTATION_GROUP_NAME = "Finance Advisor Services";
private static final String DOCUMENTATION_TITLE = "Finance Advisor APIs";
private static final String DOCUMENTATION_DESCRIPTION = "Finance Advisior API documentation";
private static final String DOCUMENTATION_VERSION = "1";
private static final String SWAGGER_API_PATH_REGEX = "/.*";

/**
 * Swagger configuration.
 *
 * @return The initialized swagger configuration object.
 */
@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).groupName(DOCUMENTATION_GROUP_NAME).apiInfo(apiInfo()).select()
            .paths(regex(SWAGGER_API_PATH_REGEX)).build();
}

private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(DOCUMENTATION_TITLE).description(DOCUMENTATION_DESCRIPTION)
            .version(DOCUMENTATION_VERSION).build();
}
}

