package com.example.library.service;

import com.example.library.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book saveBook(BookDTO bookDTO);

    Book updateBook(Long bookId, BookDTO bookDTO);

    void deleteBookById(Long bookId);
}
