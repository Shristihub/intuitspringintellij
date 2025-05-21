package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepository bookRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public BookDto addBook(BookDto bookDto) {
        //object of model mapper to covert dto object to entity
        Book book = mapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(book);
        // convert entity back to dto
        return mapper.map(savedBook, BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = mapper.map(bookDto, Book.class);
        Book updatedBook = bookRepository.save(book);
        // convert entity back to dto
        return mapper.map(updatedBook, BookDto.class);
    }

    @Override
    public void deleteById(int bookId) {
        bookRepository.deleteById(bookId);

    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public BookDto getById(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        return mapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getByLesserPrice(double price) {
        List<Book> books = bookRepository.findByPriceLessThanEqual(price);
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> getByCategory(String category) {

        List<Book> books = bookRepository.findByCategory(category);
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> getByCategoryLessPrice(String category, double price) {

        List<Book> books = bookRepository.findByCatLessPrice(category, price);
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> getByCategoryPrice(String category, double price) {

        List<Book> books = bookRepository.findByCatPrice(category, price);
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> getByTitleContains(String choice) {
        List<Book> books = bookRepository.findByTitleContains(choice);
        return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }
}
