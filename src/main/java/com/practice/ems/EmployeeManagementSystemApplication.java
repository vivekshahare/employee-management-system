package com.practice.ems;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API documentation",
                description = "Spring Boot REST API documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Vivek Shahare",
                        email = "support@test.com",
                        url = "www.test.com"
                )
        )
)
@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

}
