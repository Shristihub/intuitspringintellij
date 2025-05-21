package com.bookapp.controllers;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {
    @Autowired
    private IBookService bookService;

    //    http://localhost:8081/book-api/v1/books
    @PostMapping("/books")
    Book addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return savedBook;
    }

    //    http://localhost:8081/book-api/v1/books
    @PutMapping("/books")
    Book updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return updatedBook;
    }

    //    http://localhost:8081/book-api/v1/books/bookId/103
    @DeleteMapping("/books/bookId/{bookId}")
    void deleteById(int bookId) {
        bookService.deleteById(bookId);
    }

    //    http://localhost:8081/book-api/v1/books
    @GetMapping("/books")
    List<Book> getBooks() {
        List<Book> books = bookService.getBooks();
        return books;
    }

    //    http://localhost:8081/book-api/v1/books/bookId/103
    @GetMapping("/books/bookId/{bookId}")
    Book getById(@PathVariable int bookId) {
        Book book = bookService.getById(bookId);
        return book;
    }

    // http://localhost:8081/book-api/v1/books/price/400
    @GetMapping("/books/price/{price}")
    List<Book> getByLesserPrice(@PathVariable double price) {
        bookService.getByLesserPrice(price);
        return List.of();
    }

    // http://localhost:8081/book-api/v1/books/category?category=tech
    @GetMapping("/books/category")
    List<Book> getByCategory(@RequestParam String category) {
        List<Book> books = bookService.getByCategory(category);
        return books;
    }

    @GetMapping("/books/category/{category}/price/{price}")
    List<Book> getByCategoryLessPrice(@PathVariable String category, @PathVariable double price) {
        List<Book> books = bookService.getByCategoryLessPrice(category, price);
        return books;
    }


}
