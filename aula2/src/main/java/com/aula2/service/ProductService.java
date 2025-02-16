package com.aula2.service;

import com.aula2.entity.Product;
import com.aula2.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> find() {
        return repository.findAll();
    }

    public Long save(final Product product) {
        return repository.save(product).getId();
    }

    public Product findById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public void update(final Long id, final Product product) {
        final Product productFound = findById(id);

        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());
        productFound.getCategories().retainAll(product.getCategories());

        repository.save(productFound);
    }

    public void delete(final Long id) {
        final Product productFound = findById(id);
        repository.delete(productFound);
    }
}
