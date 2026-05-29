package de.physikraum.inventory.service;

import de.physikraum.inventory.entity.Category;
import de.physikraum.inventory.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) { this.repository = repository; }

    public List<Category> findAll() { return repository.findAll(); }
    public Category save(Category c) { return repository.save(c); }
}
