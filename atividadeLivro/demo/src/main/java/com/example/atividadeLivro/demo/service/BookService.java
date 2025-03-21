package com.example.atividadeLivro.demo.service;

import com.example.atividadeLivro.demo.enums.StatusBook;
import com.example.atividadeLivro.demo.exceptions.GlobalExceptionHandler;
import com.example.atividadeLivro.demo.exceptions.NotFoundException;
import com.example.atividadeLivro.demo.model.Book;
import com.example.atividadeLivro.demo.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends GlobalExceptionHandler {

    @Autowired
    private BookRepository repository;

    public Book create(Book book) {

        Book createdBook = repository.save(book);
        return createdBook;
    }

    ;

    public List<Book> getAll() {

        List<Book> books = repository.findAll();
        if (repository.findAll().isEmpty()){
            return null;
        }
        return repository.findAll();
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
        updatedBook.setStatus(book.getStatus());

        return repository.save(updatedBook);
    }

    ;

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException(("Not found")));
        repository.deleteById(id);
    }

    ;

    public List<Book> findByStatus(StatusBook statusBook){
        List<Book> foundBook =  repository.findByStatus(statusBook);
        return foundBook;
    };
}
