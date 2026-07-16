package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DashboardDAO;
import database.DBConnection;

public class DashboardDAOImpl implements DashboardDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public int getTotalProducts() {

        String query = "SELECT COUNT(*) FROM product";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public int getTotalCategories() {

        String query = "SELECT COUNT(*) FROM category";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public int getTotalSuppliers() {

        String query = "SELECT COUNT(*) FROM supplier";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public int getTotalCustomers() {

        String query = "SELECT COUNT(*) FROM customer";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public int getAvailableStock() {

        String query = "SELECT IFNULL(SUM(quantity),0) FROM product";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public double getTotalSales() {

        String query = "SELECT IFNULL(SUM(total_amount),0) FROM sales";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return rs.getDouble(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

}