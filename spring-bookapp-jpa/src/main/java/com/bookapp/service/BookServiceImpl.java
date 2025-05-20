package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService{

    private final IBookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        //check if bookId exists in database
        // if available update the record
        // if not insert it as a new record
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(int bookId) {
        bookRepository.deleteById(bookId);

    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int bookId) {
//        Optional<Book> bookOpt =  bookRepository.findById(bookId);
//        if(bookOpt.isPresent())
//            return bookOpt.get();
//        return null;
        return bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException("invalid id"));

    }

    @Override
    public List<Book> getByLesserPrice(double price) {
        return List.of();
    }

    @Override
    public List<Book> getByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Book> getByCategoryLessPrice(String category, double price) {
        return List.of();
    }

    @Override
    public List<Book> getByTitleContains(String choice) {
        return List.of();
    }
}
