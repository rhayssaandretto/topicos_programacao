package com.aula2.service;

import com.aula2.entity.Category;
import com.aula2.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> find() {
        return repository.findAll();
    }

    public Long save(final Category category) {
        return repository.save(category).getId();
    }

    public Category findById(final Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    public void update(final Long id, final Category category) {
        final Category categoryFound = findById(id);

        categoryFound.setName(category.getName());

        repository.save(categoryFound);
    }

    public void delete(final Long id) {
        final Category categoryFound = findById(id);
        repository.delete(categoryFound);
    }
}
