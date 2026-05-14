package com.juliofhernandez.ledgerlyapi.repository;

import com.juliofhernandez.ledgerlyapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}