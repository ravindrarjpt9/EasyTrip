package com.easymytrip.social.alpha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.sun.jersey.spi.inject.Inject;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	@Inject
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Bean
	public SwaggerSpringMvcPlugin configureSwagger() {
		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
		
		ApiInfo apiInfo = new ApiInfoBuilder()
							        .title("EasyMyTrip Engagement REST API")
							        .description("EasyMyTrip Api for social Engagement")
							        .termsOfServiceUrl("http://example.com/terms-of-service")
							        .contact("ravindra.rajpoot@hotmail.com")
							        .license("MIT License")
							        .licenseUrl("http://opensource.org/licenses/MIT")
							        .build();
		
		swaggerSpringMvcPlugin
					.apiInfo(apiInfo)
					.apiVersion("1.0")
					.includePatterns("/emt/registration/*.*", "/emt/hello/*.*");
		
		swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
		
	    return swaggerSpringMvcPlugin;
	}
}
