package com.springboot.graphql.springboot_graphql.repository;

import com.springboot.graphql.springboot_graphql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
