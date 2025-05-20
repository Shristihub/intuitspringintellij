package com.bookapp.service;

import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    //CRUD OPERATION
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteById(int bookId);
    List<Book> getBooks();
    Book getById(int bookId);

     // derived
    List<Book> getByLesserPrice(double price);
    List<Book> getByCategory(String category);
    //custom query
    List<Book> getByCategoryLessPrice(String category, double price);

    //native query
    List<Book> getByCategoryPrice(String category,double price);
    List<Book> getByTitleContains(String choice);
}
