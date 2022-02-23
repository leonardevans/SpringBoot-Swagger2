package com.springbootswagger2.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile("swagger-enabled-for-qa")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();

        //If the user has default response messages which are to be applied to all the REST APIs then these can be specified when defining the Docket bean. Hence these will not need to be applied at the method level
        // For example if the response for code 404 and 500 is going to be same throughout all services
        docket.globalResponseMessage(RequestMethod.GET, ImmutableList.of(new ResponseMessageBuilder()
                .code(400)
                .message("Bad Request")
                .responseModel(new ModelRef("Error")).build(),new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .responseModel(new ModelRef("Error")).build()));

        return docket;
    }

    private Predicate<String> postPaths(){
        return Predicates.or(PathSelectors.regex("/api/posts.*"), PathSelectors.regex("/api/hello.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot Swagger 2")
                .description("Using swagger2 to document Spring Boot REST APIs")
                .termsOfServiceUrl("http://bedubiz.com")
                .contact("bizbedu@gmaal.com").license("Bedubiz License")
                .licenseUrl("bizbedu@gmaal.com").version("1.0").build();
    }

}