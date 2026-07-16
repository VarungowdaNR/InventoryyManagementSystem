package dao;

import java.util.List;

import dto.CategoryDTO;

public interface CategoryDAO {

    boolean addCategory(CategoryDTO category);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(int categoryId);

    boolean updateCategory(CategoryDTO category);

    boolean deleteCategory(int categoryId);

}