package com.example.library.service.impl;

import com.example.library.dao.BookDAO;
import com.example.library.model.Book;
import com.example.library.service.BookDTO;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookDAO.findById(bookId).get();
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book bookToBeSaved = new Book(bookDTO.getTitle(), bookDTO.getAuthor());

        if (bookDAO.findByTitleAndAuthor(bookToBeSaved.getTitle(), bookToBeSaved.getAuthor()) == null) {
            bookDAO.save(bookToBeSaved);
            return bookDAO.findByTitleAndAuthor(bookDTO.getTitle(), bookDTO.getAuthor());
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(Long bookId, BookDTO bookDTO) {
        Book bookToBeUpdated = bookDAO.findById(bookId).get();

        if (bookToBeUpdated != null) {
            bookToBeUpdated.setAuthor(bookDTO.getAuthor());
            bookToBeUpdated.setTitle(bookDTO.getTitle());

            bookDAO.save(bookToBeUpdated);
            return bookToBeUpdated;
        } else {
            return null;
        }
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookDAO.deleteById(bookId);
    }
}
