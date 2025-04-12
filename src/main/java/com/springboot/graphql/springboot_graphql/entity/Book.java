package com.springboot.graphql.springboot_graphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;

    public Book(String title, String desc, String author, double price, int pages) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }
}
