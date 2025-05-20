package com.bookapp.service;

import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    Book getBookById(int id);
    List<Book> getByLesserPrice(double price);
}
