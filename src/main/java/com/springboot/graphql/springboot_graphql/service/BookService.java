package com.springboot.graphql.springboot_graphql.service;

import com.springboot.graphql.springboot_graphql.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
}
