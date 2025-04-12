package com.springboot.graphql.springboot_graphql;

import com.springboot.graphql.springboot_graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot.graphql.springboot_graphql.entity.Book;

@SpringBootApplication
public class SpringbootGraphqlApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGraphqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Preloading sample books
		bookService.createBook(new Book("GraphQL Basics", "Intro to GraphQL", "Pratik Chavan", 299.99, 200));
		bookService.createBook(new Book("Spring Boot Mastery", "Spring Boot deep dive", "John Doe", 449.99, 350));
		bookService.createBook(new Book("Microservices", "Building microservices with Spring Cloud", "Jane Doe", 599.99, 400));

		System.out.println("📚 Sample books added at startup!");
	}
}
