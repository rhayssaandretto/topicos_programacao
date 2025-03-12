package com.example.atividadeLivro.demo.repository;

import com.example.atividadeLivro.demo.enums.StatusBook;
import com.example.atividadeLivro.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByStatus(StatusBook statusBook);
}
