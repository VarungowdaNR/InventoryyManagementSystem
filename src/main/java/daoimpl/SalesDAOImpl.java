package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.SalesDAO;
import database.DBConnection;
import dto.SaleItemsDTO;
import dto.SalesDTO;

public class SalesDAOImpl implements SalesDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public boolean addSale(SalesDTO sale) {

        String query = "INSERT INTO sales(customer_id,total_amount,sale_date) VALUES(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, sale.getCustomerId());
            ps.setDouble(2, sale.getTotalAmount());
            ps.setTimestamp(3, sale.getSaleDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<SalesDTO> getAllSales() {

        List<SalesDTO> list = new ArrayList<>();

        String query = "SELECT * FROM sales";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SalesDTO sale = new SalesDTO();

                sale.setSaleId(rs.getInt("sale_id"));
                sale.setCustomerId(rs.getInt("customer_id"));
                sale.setTotalAmount(rs.getDouble("total_amount"));
                sale.setSaleDate(rs.getTimestamp("sale_date"));

                list.add(sale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public SalesDTO getSaleById(int saleId) {

        String query = "SELECT * FROM sales WHERE sale_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, saleId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                SalesDTO sale = new SalesDTO();

                sale.setSaleId(rs.getInt("sale_id"));
                sale.setCustomerId(rs.getInt("customer_id"));
                sale.setTotalAmount(rs.getDouble("total_amount"));
                sale.setSaleDate(rs.getTimestamp("sale_date"));

                return sale;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateSale(SalesDTO sale) {

        String query = "UPDATE sales SET customer_id=?, total_amount=?, sale_date=? WHERE sale_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, sale.getCustomerId());
            ps.setDouble(2, sale.getTotalAmount());
            ps.setTimestamp(3, sale.getSaleDate());
            ps.setInt(4, sale.getSaleId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSale(int saleId) {

        String query = "DELETE FROM sales WHERE sale_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, saleId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public double calculateTotalAmount(int saleId) {

        String query = "SELECT total_amount FROM sales WHERE sale_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, saleId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total_amount");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<SalesDTO> getSalesByCustomer(int customerId) {

        List<SalesDTO> list = new ArrayList<>();

        String query = "SELECT * FROM sales WHERE customer_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                SalesDTO sale = new SalesDTO();

                sale.setSaleId(rs.getInt("sale_id"));
                sale.setCustomerId(rs.getInt("customer_id"));
                sale.setTotalAmount(rs.getDouble("total_amount"));
                sale.setSaleDate(rs.getTimestamp("sale_date"));

                list.add(sale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean generateSale(SalesDTO sale, int productId, int quantity) {

        System.out.println("Generate Sale Method");


        return addSale(sale);
    }

    @Override
    public boolean generateSale(SalesDTO sale, List<SaleItemsDTO> items) {

        System.out.println("Generate Multiple Item Sale");


        return addSale(sale);
    }
}