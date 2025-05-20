package com.bookapp.util;

import com.bookapp.model.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookUtil {
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book(1,"Java in Action","David",1500,"Tech"),
                new Book(2,"5 am club","Robin",370,"Selfhelp"),
                new Book(3,"Head First Java","Kathy",1200,"Tech"),
                new Book(4,"Leadership","Robin",1000,"Selfhelp"),
                new Book(5,"Seven Habits","Steve",780,"Selfhelp")
        );
    }
}
