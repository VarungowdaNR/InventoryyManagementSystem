package dao;

import java.util.List;

import dto.ProductDTO;

public interface ProductDAO {

    boolean addProduct(ProductDTO product);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int productId);

    boolean updateProduct(ProductDTO product);

    boolean deleteProduct(int productId);
    List<ProductDTO> getAllProductsWithDetails();
}