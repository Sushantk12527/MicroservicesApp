package com.example.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@OpenAPIDefinition(
		info=@Info(
				title="Department Service REST APIs",
				description = "Department Service REST APIs Documentation",
				version= "v1.0",
				contact= @Contact(
						name = "Sushant",
						email="sushantk297@gmail.com",
						url="https://www.google.com"
				),
				license = @License(
						name = "Apache 2.0",
						url="https://www.google.com"
				)


		),
		externalDocs=@ExternalDocumentation(
				description = "Department-Service Docs",
				url = "https://www.google.com"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
