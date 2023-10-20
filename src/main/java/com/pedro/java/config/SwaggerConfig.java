package com.pedro.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi(){
        return new Docket (DocumentationType.SWAGGER_2)
                .select ()
                .apis (RequestHandlerSelectors.basePackage ("com.pedro.java"))
                .paths (regex("/person"))
                .build ()
                .apiInfo (metaInfo());
    }
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo (
                "springbootyt",
                "Descrição springbootyt",
                "1.0",
                "Terms od Services",
                new Contact ("Pedro Parreira Cunha", "https://www.youtube.com/", "pedropcunh1916@gmail.com"),
                "Apache Lisence Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
