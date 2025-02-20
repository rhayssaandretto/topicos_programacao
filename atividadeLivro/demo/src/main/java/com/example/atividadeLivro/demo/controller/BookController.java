package com.example.atividadeLivro.demo.controller;

import com.example.atividadeLivro.demo.model.Book;
import com.example.atividadeLivro.demo.service.BookService;
import com.sun.source.tree.LambdaExpressionTree;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    public BookService bookService;

    @PostMapping()
    public ResponseEntity<Book> create(@RequestBody Book book){
        Book createdBook = bookService.create(book);
        return ResponseEntity.ok(createdBook);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
      Book foundBook = bookService.findById(id);
      return ResponseEntity.ok(foundBook);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateById(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    };

};