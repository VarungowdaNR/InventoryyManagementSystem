package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SaleItemsDAO;
import database.DBConnection;
import dto.SaleItemsDTO;

public class SaleItemsDAOImpl implements SaleItemsDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addSaleItem(SaleItemsDTO saleItem) {

        String query = "INSERT INTO sale_items(sale_id,product_id,quantity,price,subtotal) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, saleItem.getSaleId());
            ps.setInt(2, saleItem.getProductId());
            ps.setInt(3, saleItem.getQuantity());
            ps.setDouble(4, saleItem.getPrice());
            ps.setDouble(5, saleItem.getSubtotal());

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
    public List<SaleItemsDTO> getAllSaleItems() {

        List<SaleItemsDTO> list = new ArrayList<SaleItemsDTO>();

        String query = "SELECT * FROM sale_items";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                SaleItemsDTO saleItem = new SaleItemsDTO();

                saleItem.setSaleItemId(rs.getInt("sale_item_id"));
                saleItem.setSaleId(rs.getInt("sale_id"));
                saleItem.setProductId(rs.getInt("product_id"));
                saleItem.setQuantity(rs.getInt("quantity"));
                saleItem.setPrice(rs.getDouble("price"));
                saleItem.setSubtotal(rs.getDouble("subtotal"));

                list.add(saleItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public SaleItemsDTO getSaleItemById(int saleItemId) {

        String query = "SELECT * FROM sale_items WHERE sale_item_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, saleItemId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                SaleItemsDTO saleItem = new SaleItemsDTO();

                saleItem.setSaleItemId(rs.getInt("sale_item_id"));
                saleItem.setSaleId(rs.getInt("sale_id"));
                saleItem.setProductId(rs.getInt("product_id"));
                saleItem.setQuantity(rs.getInt("quantity"));
                saleItem.setPrice(rs.getDouble("price"));
                saleItem.setSubtotal(rs.getDouble("subtotal"));

                return saleItem;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateSaleItem(SaleItemsDTO saleItem) {

        String query = "UPDATE sale_items SET sale_id=?,product_id=?,quantity=?,price=?,subtotal=? WHERE sale_item_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, saleItem.getSaleId());
            ps.setInt(2, saleItem.getProductId());
            ps.setInt(3, saleItem.getQuantity());
            ps.setDouble(4, saleItem.getPrice());
            ps.setDouble(5, saleItem.getSubtotal());
            ps.setInt(6, saleItem.getSaleItemId());

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
    public boolean deleteSaleItem(int saleItemId) {

        String query = "DELETE FROM sale_items WHERE sale_item_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, saleItemId);

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