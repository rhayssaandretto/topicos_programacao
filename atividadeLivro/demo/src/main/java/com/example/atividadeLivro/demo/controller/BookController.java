package com.example.atividadeLivro.demo.controller;

import com.example.atividadeLivro.demo.enums.StatusBook;
import com.example.atividadeLivro.demo.model.Book;
import com.example.atividadeLivro.demo.service.BookService;
import com.sun.source.tree.LambdaExpressionTree;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    public BookService bookService;

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @Valid Book book) {
        Book createdBook = bookService.create(book);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdBook.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    ;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book foundBook = bookService.findById(id);
        return ResponseEntity.ok(foundBook);
    }

    ;

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateById(@PathVariable Long id, @RequestBody @Valid Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    ;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    ;

    @GetMapping("/status/{statusBook}")
    public ResponseEntity<List<Book>> findByStatus(@PathVariable StatusBook statusBook){
        return ResponseEntity.ok(bookService.findByStatus(statusBook));
    }

};