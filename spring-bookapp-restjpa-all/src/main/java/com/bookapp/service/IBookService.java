package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.model.BookDto;

import java.util.List;

public interface IBookService {
    //CRUD OPERATION
    BookDto addBook(BookDto book);
    BookDto updateBook(BookDto book);
    void deleteById(int bookId);
    List<BookDto> getBooks();
    BookDto getById(int bookId);

     // derived
    List<BookDto> getByLesserPrice(double price);
    List<BookDto> getByCategory(String category);
    //custom query
    List<BookDto> getByCategoryLessPrice(String category, double price);

    //native query
    List<BookDto> getByCategoryPrice(String category,double price);
    List<BookDto> getByTitleContains(String choice);
}
