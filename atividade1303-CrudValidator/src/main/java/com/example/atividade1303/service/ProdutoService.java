package com.example.atividade1303.service;

import com.example.atividade1303.model.Produto;
import com.example.atividade1303.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto create(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> getAll(){
        return repository.findAll();
    }

    public Produto update(Long id, Produto produto){
        Produto produto1 = repository.findById(id).get();

        produto1.setNome(produto.getNome());
        produto1.setPreco(produto.getPreco());
        produto1.setQtdEstoque(produto.getQtdEstoque());

        return repository.save(produto1);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
