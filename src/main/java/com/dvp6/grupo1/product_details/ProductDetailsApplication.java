package com.dvp6.grupo1.product_details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class ProductDetailsApplication {
	private static final Logger log = LoggerFactory.getLogger(ProductDetailsApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(ProductDetailsApplication.class, args);
		SpringApplication app = new SpringApplication(ProductDetailsApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}

	@Bean
  	public CommandLineRunner demo(MovieRepository repository) {
    	return (args) -> {
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Movie movie : repository.findAll()) {
			  log.info(movie.toString());
			}
			log.info("");
	  
			// fetch an individual customer by ID
			Optional<Movie> movie = repository.findById("tt0205423");
			log.info("Movie found with findById(\"tt0205423\"):");
			log.info("--------------------------------");
			log.info(movie.toString());
			log.info("");
	  
			// fetch customers by last name
			log.info("Movie found with findByTitleContaining('South'):");
			log.info("--------------------------------------------");
			repository.findTopByTitleContainingIgnoreCase("South").forEach(movie_title_containing -> {
			  log.info(movie_title_containing.toString());
			});
			
			// fetch customers by last name
			log.info("Movie search with searchByTitleAndYear('Black Emanuelle', '1975'):");
			log.info("--------------------------------------------");
			repository.searchByTitleAndYear("Black Emanuelle", "1975").forEach(movie_by_title_year -> {
			  log.info(movie_by_title_year.toString());
			});
			log.info("");
		  };
		}

}
