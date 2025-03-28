package com.ayouni.tripleA.Pharma.repository;

import com.ayouni.tripleA.Pharma.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
