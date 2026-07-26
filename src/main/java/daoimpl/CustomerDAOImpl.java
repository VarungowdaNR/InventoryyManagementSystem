package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import database.DBConnection;
import dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addCustomer(CustomerDTO customer) {

        String query = "INSERT INTO customer(customer_name,mobile,email,address) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getMobile());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());

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
    public List<CustomerDTO> getAllCustomers() {

        List<CustomerDTO> list = new ArrayList<CustomerDTO>();

        String query = "SELECT * FROM customer";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                CustomerDTO customer = new CustomerDTO();

                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));

                list.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        String query = "SELECT * FROM customer WHERE customer_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                CustomerDTO customer = new CustomerDTO();

                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setMobile(rs.getString("mobile"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {

        String query = "UPDATE customer SET customer_name=?,mobile=?,email=?,address=? WHERE customer_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getMobile());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());
            ps.setInt(5, customer.getCustomerId());

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
    public boolean deleteCustomer(int customerId) {

        String query = "DELETE FROM customer WHERE customer_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, customerId);

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