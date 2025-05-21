package com.bookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="book_details") // to give a different table name
public class Book {
    @Id
    @GeneratedValue(generator = "book_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="book_gen",sequenceName = "book_sequence",initialValue = 100, allocationSize = 1)
    private Integer bookId;
    @Column(length = 30)
    private String title;
    @Column(length = 30)
    private String author;
    @Column(name = "cost")
    private double price;
    @Column(length = 30)
    private String category;

}
