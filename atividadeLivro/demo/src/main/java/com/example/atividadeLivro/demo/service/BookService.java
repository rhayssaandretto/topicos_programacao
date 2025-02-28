package com.example.atividadeLivro.demo.service;

import com.example.atividadeLivro.demo.model.Book;
import com.example.atividadeLivro.demo.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book create(Book book) {
        Book createdBook = repository.save(book);
        return createdBook;
    }

    ;

    public Book findById(Long id) {
        Book bookById = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));
        return bookById;
    }

    ;

    public Book updateBook(Long id, Book book) {
        Book updatedBook = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(("Not found")));

        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        return repository.save(updatedBook);
    }

    ;

    public void delete(Long id) {
        repository.deleteById(id);
    }

    ;
}
