package com.infotech.book.ticket.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;



@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.infotech.book.ticket.app"))
				.paths(regex("/api/tickets.*"))
				.build()
				.apiInfo(metaData());
		
		
	}
	
	
	private ApiInfo metaData() {

        Contact contact = new Contact("XYZ", "XYZ.com", "XYZ@gmail.com");
        return new ApiInfoBuilder()

        .title("Spring Boot REST API")
        .description("Spring Boot REST API for Space Study")
        .version("1.0.0")
        .license("Apache 2.0")
        .contact(contact)
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")       
        .build();
    }
	
	
    
}
