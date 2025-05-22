package com.bookapp.controllers;

import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {
    @Autowired
    private IBookService bookService;

    //    http://localhost:8081/book-api/v1/books
    @PostMapping("/admin/books")
    ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.addBook(bookDto);
        //add custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("info","Adding Book to db");
        headers.add("desc","Book added successfully");
        return ResponseEntity.status(201).headers(headers).body(savedBook);
    }


    //    http://localhost:8081/book-api/v1/books
    @PutMapping("/admin/books")
    ResponseEntity<BookDto>  updateBook(@RequestBody BookDto bookDto) {
        BookDto updatedBook = bookService.updateBook(bookDto);
        ResponseEntity<BookDto> responseEntity =
                new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    //    http://localhost:8081/book-api/v1/books/bookId/103
    @DeleteMapping("/admin/books/bookId/{bookId}")
    ResponseEntity<Void> deleteById(int bookId) {
        bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }

    //    http://localhost:8081/book-api/v1/books
    @GetMapping("/books")
    ResponseEntity<List<BookDto>> getBooks() {
        List<BookDto> bookDtos = bookService.getBooks();
        return ResponseEntity.ok(bookDtos);
    }

    //    http://localhost:8081/book-api/v1/books/bookId/103
    @GetMapping("/admin/books/bookId/{bookId}")
    ResponseEntity<BookDto> getById(@PathVariable int bookId) {
        BookDto bookDto = bookService.getById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("info","Get one Book by Id");
        return ResponseEntity.ok().headers(headers).body(bookDto);
    }

    // http://localhost:8081/book-api/v1/books/price/400
    @GetMapping("/books/price/{price}")
    ResponseEntity<List<BookDto>> getByLesserPrice(@PathVariable double price) {
        List<BookDto> bookDtos = bookService.getByLesserPrice(price);
        return ResponseEntity.status(HttpStatusCode.valueOf(200))
                             .body(bookDtos);
    }

    // http://localhost:8081/book-api/v1/books/category?category=tech
    @GetMapping("/books/category")
    ResponseEntity<List<BookDto>> getByCategory(@RequestParam String category) {
        List<BookDto> bookDtos = bookService.getByCategory(category);
        return ResponseEntity.ok(bookDtos);
    }

    @GetMapping("/books/category/{category}/price/{price}")
    ResponseEntity<List<BookDto>> getByCategoryLessPrice(@PathVariable String category, @PathVariable double price) {
        List<BookDto> bookDtos = bookService.getByCategoryLessPrice(category, price);
        return ResponseEntity.ok(bookDtos);
    }


}
