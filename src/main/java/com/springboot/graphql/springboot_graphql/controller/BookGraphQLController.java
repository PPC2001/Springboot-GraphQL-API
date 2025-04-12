package com.springboot.graphql.springboot_graphql.controller;

import com.springboot.graphql.springboot_graphql.entity.Book;
import com.springboot.graphql.springboot_graphql.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

/**
 * GraphQL Controller for managing Book resources.
 * Provides GraphQL query and mutation mappings for retrieving and creating books.
 */
@Slf4j
@Controller
public class BookGraphQLController {

    private final BookService bookService;

    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @QueryMapping
    public List<Book> getAllBooks() {
        log.info("Fetching all books via GraphQL");
        return bookService.getAllBooks();
    }

    // Get book by ID
    @QueryMapping
    public Book getBookById(@Argument int bookId) {
        log.info("Fetching book with ID: {}", bookId);
        return bookService.getBookById(bookId);
    }

    // Create a new book
    @MutationMapping
    public Book createBook(
            @Argument String title,
            @Argument String desc,
            @Argument String author,
            @Argument double price,
            @Argument int pages
    ) {
        log.info("Creating book with title: {}", title);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(desc);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPages(pages);
        return bookService.createBook(book);
    }
}