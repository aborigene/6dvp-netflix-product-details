package com.dvp6.grupo1.product_details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;


@SpringBootApplication
public class ProductDetailsApplication {
	private static final Logger log = LoggerFactory.getLogger(ProductDetailsApplication.class);

	static final String topicExchangeName = "product-details";

	static final String queueName = "product-details-queue";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("#");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
		MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(ProductDetailsMessageReceiver productDetailsMessageReceiver) {
		return new MessageListenerAdapter(productDetailsMessageReceiver, "receiveMessage");
	}

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
			/*// fetch all customers
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
			log.info("");*/
		  };
		}

}
