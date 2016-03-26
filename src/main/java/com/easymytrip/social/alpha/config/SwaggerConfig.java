package com.easymytrip.social.alpha.config;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.fasterxml.classmate.TypeResolver;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/*@Autowired
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
					.apiVersion("1.0").includePatterns("/registration/*.*", "/hello/*.*");
					
		
		swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
		
	    return swaggerSpringMvcPlugin;
	}*/
	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().pathMapping("/emt")
				.directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build()));
				
	}
 
	@Autowired
	private TypeResolver typeResolver;
 
	
 
	
 
 
	
 
	
}
