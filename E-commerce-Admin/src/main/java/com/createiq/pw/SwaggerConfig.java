package com.createiq.pw;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.createiq"))
                .paths(regex("/*.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Test REST API",
                "Spring Boot Test REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("John Thompson", "https://createiq/about/", "balaji@createiq"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",Arrays.asList(new VendorExtension[] {new StringVendorExtension("Test", "Test")})) ;
        return apiInfo;
    }
}