package com.example.library.dao;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookDAO extends JpaRepository<Book, Long> {

    Book findByTitleAndAuthor(String title, String author);
}
