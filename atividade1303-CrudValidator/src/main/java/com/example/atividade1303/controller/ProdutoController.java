package com.example.atividade1303.controller;

import com.example.atividade1303.model.Produto;
import com.example.atividade1303.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    private ResponseEntity<Produto> create(@RequestBody @Valid Produto produto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        Produto response = service.create(produto);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    private ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    private ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        return ResponseEntity.ok(service.update(id, produto));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
