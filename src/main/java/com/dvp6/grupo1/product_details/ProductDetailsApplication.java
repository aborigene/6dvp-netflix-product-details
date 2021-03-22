package com.dvp6.grupo1.product_details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class ProductDetailsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProductDetailsApplication.class, args);
		SpringApplication app = new SpringApplication(ProductDetailsApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}

}
