package com.springboot.graphql.springboot_graphql.controller;

import com.springboot.graphql.springboot_graphql.entity.Book;
import com.springboot.graphql.springboot_graphql.repository.BookRepository;
import com.springboot.graphql.springboot_graphql.service.BookService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API Controller for managing Book resources.
 * Supports creating, retrieving all, and retrieving individual books.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/books")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid parameters or input"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - Authentication required"),
        @ApiResponse(responseCode = "403", description = "Forbidden - Access denied"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new Book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("Creating a new book: {}", book);
        Book savedBook = bookService.createBook(book);
        log.info("Book created successfully with ID: {}", savedBook.getId());
        return ResponseEntity.ok(savedBook);
    }

    // Get all Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Fetching all books...");
        List<Book> books = bookService.getAllBooks();
        log.info("Total books fetched: {}", books.size());
        return ResponseEntity.ok(books);
    }

    // Get Book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        log.info("Fetching book by ID: {}", id);
        Book book = bookService.getBookById(id);
        log.info("Book fetched: {}", book);
        return ResponseEntity.ok(book);
    }

}
