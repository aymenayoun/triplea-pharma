package com.ayouni.tripleA.Pharma.service.interf;

import com.ayouni.tripleA.Pharma.dto.CategoryDto;
import com.ayouni.tripleA.Pharma.dto.Response;

public interface CategoryService {
    Response createCategory(CategoryDto categoryRequest);
    Response updateCategory(Long categoryId, CategoryDto categoryRequest);
    Response getAllCategories();
    Response getCategoryById(Long categoryId);
    Response deleteCategory(Long categoryId);
}
