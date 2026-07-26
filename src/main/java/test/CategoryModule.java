package test;

import java.util.List;

import dao.CategoryDAO;
import daoimpl.CategoryDAOImpl;
import dto.CategoryDTO;

public class CategoryModule {

    public static void main(String[] args) {

        CategoryDAO dao = new CategoryDAOImpl();

   

//        CategoryDTO category = new CategoryDTO();
//
//        category.setCategoryName("Electronics");
//        category.setDescription("Electronic Products");
//
//        boolean result = dao.addCategory(category);
//
//        if(result)
//            System.out.println("Category Added Successfully");
//        else
//            System.out.println("Failed to Add Category");



        // ============================
        // DISPLAY ALL
        // ============================

//        List<CategoryDTO> list = dao.getAllCategories();
//
//        for(CategoryDTO category : list){
//
//            System.out.println(category);
//
//        }



        // ============================
        // SEARCH
        // ============================

//        CategoryDTO category = dao.getCategoryById(1);
//
//        if(category != null)
//            System.out.println(category);
//        else
//            System.out.println("Category Not Found");



        // ============================
        // UPDATE
        // ============================

//        CategoryDTO category = new CategoryDTO();
//
//        category.setCategoryId(1);
//        category.setCategoryName("Computer");
//        category.setDescription("Computer Accessories");
//
//        boolean result = dao.updateCategory(category);
//
//        if(result)
//            System.out.println("Category Updated Successfully");
//        else
//            System.out.println("Update Failed");



        // ============================
        // DELETE
        // ============================

//        boolean result = dao.deleteCategory(1);
//
//        if(result)
//            System.out.println("Category Deleted Successfully");
//        else
//            System.out.println("Delete Failed");

    }

}