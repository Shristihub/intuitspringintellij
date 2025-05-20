package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return bookRepository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<Book> getByCategory(String category) {

        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> getByCategoryLessPrice(String category, double price) {

        return bookRepository.findByCatLessPrice(category, price);
    }

    @Override
    public List<Book> getByCategoryPrice(String category, double price) {

        return bookRepository.findByCatPrice(category, price);
    }

    @Override
    public List<Book> getByTitleContains(String choice) {
        return bookRepository.findByTitleContains(choice);
    }
}
