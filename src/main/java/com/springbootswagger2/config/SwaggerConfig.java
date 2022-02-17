package com.springbootswagger2.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths(){
        return Predicates.or(PathSelectors.regex("/api/posts.*"), PathSelectors.regex("/api/hello.*"));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Spring Boot Swagger 2")
                .description("Using swagger2 to document Spring Boot REST APIs")
                .termsOfServiceUrl("http://bedubiz.com")
                .contact("bizbedu@gmaal.com").license("Bedubiz License")
                .licenseUrl("bizbedu@gmaal.com").version("1.0").build();
    }
}
