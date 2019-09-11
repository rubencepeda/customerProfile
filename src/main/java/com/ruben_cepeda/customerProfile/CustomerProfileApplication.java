package com.ruben_cepeda.customerProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@Configuration
@EnableSwagger2
public class CustomerProfileApplication {
    @RequestMapping("/")
    public String index() {
        return "Greetings from the Consumer Reports Customer Profile Application";
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ruben_cepeda.customerProfile.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Customer Profile Service API Documentation")
                .description("This is the customer profile service which is the source of truth for first name, last name and email address")
                .contact(
                        new Contact(
                                "Ruben Cepeda",
                                "www.ruben.io",
                                "ruben.cepeda@gmail.com"
                        )
                )
                .version("0.0.1")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerProfileApplication.class, args);
    }
}