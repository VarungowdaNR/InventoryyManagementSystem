package test;

import java.sql.Date;
import java.util.List;

import dao.ProductDAO;
import daoimpl.ProductDAOImpl;
import dto.ProductDTO;

public class ProductModule {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAOImpl();

        // INSERT
       

//        ProductDTO product = new ProductDTO();
//
//        product.setProductName("Laptop");
//        product.setCategoryId(1);
//        product.setSupplierId(1);
//        product.setPrice(55000);
//        product.setQuantity(10);
//        product.setDescription("Dell Laptop");
//        product.setManufactureDate(Date.valueOf("2026-01-15"));
//        product.setExpiryDate(Date.valueOf("2028-01-15"));
//
//        boolean result = dao.addProduct(product);
//
//        if(result)
//            System.out.println("Product Added Successfully");
//        else
//            System.out.println("Product Add Failed");



        // DISPLAY ALL
       

//        List<ProductDTO> list = dao.getAllProducts();
//
//        for(ProductDTO product : list){
//
//            System.out.println(product);
//
//        }



        // ============================
        // DISPLAY WITH CATEGORY &
        // SUPPLIER DETAILS
        // ============================

//        List<ProductDTO> list = dao.getAllProductsWithDetails();
//
//        for(ProductDTO product : list){
//
//            System.out.println(product);
//
//        }


        // SEARCH
        

//        ProductDTO product = dao.getProductById(1);
//
//        if(product != null)
//            System.out.println(product);
//        else
//            System.out.println("Product Not Found");



        // ============================
        // UPDATE
        // ============================

//        ProductDTO product = new ProductDTO();
//
//        product.setProductId(1);
//        product.setProductName("HP Laptop");
//        product.setCategoryId(1);
//        product.setSupplierId(1);
//        product.setPrice(60000);
//        product.setQuantity(15);
//        product.setDescription("HP Pavilion Laptop");
//        product.setManufactureDate(Date.valueOf("2026-02-10"));
//        product.setExpiryDate(Date.valueOf("2028-02-10"));
//
//        boolean result = dao.updateProduct(product);
//
//        if(result)
//            System.out.println("Product Updated Successfully");
//        else
//            System.out.println("Update Failed");



        // DELETE
        

//        boolean result = dao.deleteProduct(1);
//
//        if(result)
//            System.out.println("Product Deleted Successfully");
//        else
//            System.out.println("Delete Failed");

    }

}