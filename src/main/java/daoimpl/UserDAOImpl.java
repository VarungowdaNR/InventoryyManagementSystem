package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import database.DBConnection;
import dto.UserDTO;

public class UserDAOImpl implements UserDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean registerUser(UserDTO user) {

        String query = "INSERT INTO users(full_name,email,mobile,username,password,role) VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole());

            int result = ps.executeUpdate();

            System.out.println("Inserted Rows : " + result);

            return result > 0;

        } catch (SQLException e) {

        	 System.out.println("SQL Error: " + e.getMessage());
        	    e.printStackTrace();

        }

        return false;
    }

    @Override
   
    public UserDTO loginUser(String email, String password) { 

        String query =
        		"SELECT * FROM users WHERE email=? AND password=?";;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                UserDTO user = new UserDTO();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

       return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {

        List<UserDTO> list = new ArrayList<UserDTO>();

        String query = "SELECT * FROM users";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UserDTO user = new UserDTO();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public UserDTO getUserById(int userId) {

        String query = "SELECT * FROM users WHERE user_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                UserDTO user = new UserDTO();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateUser(UserDTO user) {

        String query = "UPDATE users SET full_name=?,email=?,mobile=?,username=?,password=?,role=? WHERE user_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole());
            ps.setInt(7, user.getUserId());

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
    public boolean deleteUser(int userId) {

        String query = "DELETE FROM users WHERE user_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);

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