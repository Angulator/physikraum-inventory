package de.physikraum.inventory.service;

import de.physikraum.inventory.entity.Subcategory;
import de.physikraum.inventory.repository.SubcategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    private final SubcategoryRepository repository;
    public SubcategoryService(SubcategoryRepository repository) { this.repository = repository; }
    public List<Subcategory> findAll() { return repository.findAll(); }
    public Subcategory save(Subcategory s) { return repository.save(s); }
}
