package com.springboot.graphql.springboot_graphql.service.Impl;

import com.springboot.graphql.springboot_graphql.entity.Book;
import com.springboot.graphql.springboot_graphql.repository.BookRepository;
import com.springboot.graphql.springboot_graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
}
