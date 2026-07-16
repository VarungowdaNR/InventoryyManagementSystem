package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import database.DBConnection;
import dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addProduct(ProductDTO product) {

    	String query ="INSERT INTO product(product_name,category_id,supplier_id,price,quantity,description,manufacture_date,expiry_date) VALUES(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setInt(3, product.getSupplierId());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getDescription());
            ps.setDate(7, product.getManufactureDate());
            ps.setDate(8, product.getExpiryDate());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductDTO> list = new ArrayList<ProductDTO>();

        String query = "SELECT * FROM product";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProductDTO product = new ProductDTO();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setSupplierId(rs.getInt("supplier_id"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setCreatedAt(rs.getTimestamp("created_at"));
                product.setManufactureDate(rs.getDate("manufacture_date"));
                product.setExpiryDate(rs.getDate("expiry_date"));
                list.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ProductDTO> getAllProductsWithDetails() {

        List<ProductDTO> list = new ArrayList<ProductDTO>();

        String query = "SELECT p.*, c.category_name, s.supplier_name "
                + "FROM product p "
                + "INNER JOIN category c "
                + "ON p.category_id = c.category_id "
                + "INNER JOIN supplier s "
                + "ON p.supplier_id = s.supplier_id";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProductDTO product = new ProductDTO();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setSupplierId(rs.getInt("supplier_id"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setCreatedAt(rs.getTimestamp("created_at"));

                // Data from JOIN tables
                product.setCategoryName(rs.getString("category_name"));
                product.setSupplierName(rs.getString("supplier_name"));

                list.add(product);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public ProductDTO getProductById(int productId) {

        String query = "SELECT * FROM product WHERE product_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ProductDTO product = new ProductDTO();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setSupplierId(rs.getInt("supplier_id"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setCreatedAt(rs.getTimestamp("created_at"));
                product.setManufactureDate(rs.getDate("manufacture_date"));
                product.setExpiryDate(rs.getDate("expiry_date"));
                return product;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateProduct(ProductDTO product) {

    	String query =
    			"UPDATE product SET product_name=?,category_id=?,supplier_id=?,price=?,quantity=?,description=?,manufacture_date=?,expiry_date=? WHERE product_id=?";
        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getCategoryId());
            ps.setInt(3, product.getSupplierId());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getDescription());
            ps.setDate(7, product.getManufactureDate());
            ps.setDate(8, product.getExpiryDate());
            ps.setInt(9, product.getProductId());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {

        String query = "DELETE FROM product WHERE product_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, productId);

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}