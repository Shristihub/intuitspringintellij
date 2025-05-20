package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.util.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService{
    //an instance of BookUtil
    @Autowired
    private BookUtil bookUtil;

    @Override
    public List<Book> getBooks() {
        return bookUtil.getBooks();
    }

    @Override
    public Book getBookById(int id) {
//        Optional<Book> bookOpt = bookUtil.getBooks().stream()
//                .filter(book->book.getBookId()==id)
//                .findFirst();
//        if(bookOpt.isPresent())
//            return bookOpt.get(); // returns a book object
//        return null;

       return bookUtil.getBooks().stream()
              .filter(book->book.getBookId()==id)
                .findFirst().orElseThrow(()->new RuntimeException("Book not found"));

    }

    @Override
    public List<Book> getByLesserPrice(double price) {
        return bookUtil.getBooks().stream()
                .filter(book->book.getPrice()<=price)
                .collect(Collectors.toList());
    }
}
