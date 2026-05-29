package de.physikraum.inventory.repository;

import de.physikraum.inventory.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {}
