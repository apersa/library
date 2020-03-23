package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookDTO;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookControler {

    private final BookService bookService;

    @Autowired
    BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getAllBooks")
    public List<Book> getAllBooks() {
        try {
            return bookService.getAllBooks();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getBookById")
    public Book getBookById(@RequestParam Long bookId) {
        try {
            return bookService.getBookById(bookId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("saveBook")
    public Book saveBook(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.saveBook(bookDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateBook")
    public Book updateBook(@RequestParam Long bookId, @RequestBody BookDTO bookDTO) {
        try {
            return bookService.updateBook(bookId, bookDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("deleteBookById")
    public String deleteBookById(Long bookId) {
        try {
            bookService.deleteBookById(bookId);
            return "Book with id= " + bookId + " successful deleted!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
