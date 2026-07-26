package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import database.DBConnection;
import dto.CategoryDTO;

public class CategoryDAOImpl implements CategoryDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addCategory(CategoryDTO category) {

        String query = "INSERT INTO category(category_name,description) VALUES(?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        List<CategoryDTO> list = new ArrayList<CategoryDTO>();

        String query = "SELECT * FROM category";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                CategoryDTO category = new CategoryDTO();

                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));

                list.add(category);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {

        String query = "SELECT * FROM category WHERE category_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                CategoryDTO category = new CategoryDTO();

                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));

                return category;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateCategory(CategoryDTO category) {

        String query = "UPDATE category SET category_name=?,description=? WHERE category_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());
            ps.setInt(3, category.getCategoryId());

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteCategory(int categoryId) {

        String query = "DELETE FROM category WHERE category_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, categoryId);

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}