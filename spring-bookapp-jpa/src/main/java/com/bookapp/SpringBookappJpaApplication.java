package com.bookapp;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookappJpaApplication.class, args);
    }

    @Autowired
    private IBookService bookService;
    @Override
    public void run(String... args) throws Exception {
        Book book = new Book(null,"Head First Java","Kathy",900,"Tech");
        bookService.addBook(book);
        book = new Book(null,"Leadership","Robin",780,"Selfhelp");
        bookService.addBook(book);
        book = new Book(null,"5 am club","Robin",460,"Selfhelp");
        bookService.addBook(book);
        book = new Book(null,"Seven Habits","Steve",1890,"Selfhelp");
        bookService.addBook(book);

        System.out.println();
        System.out.println("Getting all books");
        bookService.getBooks().forEach(System.out::println);

        System.out.println();
        System.out.println("Getting Book By Id");
        Book nbook = bookService.getById(102);
        System.out.println("Book "+nbook);

        System.out.println();
        System.out.println("Update Book");
        nbook.setPrice(1200);
        nbook.setAuthor("Teena");
        bookService.updateBook(nbook);

        System.out.println();
        System.out.println("Getting  books by category");
        bookService.getByCategory("Tech").forEach(System.out::println);

        System.out.println();
        System.out.println("Getting  books by Less price");
        bookService.getByLesserPrice(1000).forEach(System.out::println);

        System.out.println();
        System.out.println("Getting  books by category price");
        bookService.getByCategoryLessPrice("Tech",900).forEach(System.out::println);

        System.out.println();
        System.out.println("Getting  books by title a");
        bookService.getByTitleContains("a").forEach(System.out::println);






    }
}
