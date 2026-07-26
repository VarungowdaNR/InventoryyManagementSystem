package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.StockDAO;
import database.DBConnection;
import dto.StockDTO;

public class StockDAOImpl implements StockDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public boolean addStock(StockDTO stock) {

        String query = "INSERT INTO stock(product_id,stock_in,stock_out,stock_date,remarks) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, stock.getProductId());
            ps.setInt(2, stock.getStockIn());
            ps.setInt(3, stock.getStockOut());
            ps.setDate(4, stock.getStockDate());
            ps.setString(5, stock.getRemarks());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<StockDTO> getAllStock() {

        List<StockDTO> list = new ArrayList<>();

        String query = "SELECT * FROM stock";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StockDTO stock = new StockDTO();

                stock.setStockId(rs.getInt("stock_id"));
                stock.setProductId(rs.getInt("product_id"));
                stock.setStockIn(rs.getInt("stock_in"));
                stock.setStockOut(rs.getInt("stock_out"));
                stock.setStockDate(rs.getDate("stock_date"));
                stock.setRemarks(rs.getString("remarks"));

                list.add(stock);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public StockDTO getStockById(int stockId) {

        String query = "SELECT * FROM stock WHERE stock_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, stockId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                StockDTO stock = new StockDTO();

                stock.setStockId(rs.getInt("stock_id"));
                stock.setProductId(rs.getInt("product_id"));
                stock.setStockIn(rs.getInt("stock_in"));
                stock.setStockOut(rs.getInt("stock_out"));
                stock.setStockDate(rs.getDate("stock_date"));
                stock.setRemarks(rs.getString("remarks"));

                return stock;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateStock(StockDTO stock) {

        String query = "UPDATE stock SET product_id=?, stock_in=?, stock_out=?, stock_date=?, remarks=? WHERE stock_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, stock.getProductId());
            ps.setInt(2, stock.getStockIn());
            ps.setInt(3, stock.getStockOut());
            ps.setDate(4, stock.getStockDate());
            ps.setString(5, stock.getRemarks());
            ps.setInt(6, stock.getStockId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteStock(int stockId) {

        String query = "DELETE FROM stock WHERE stock_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, stockId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean stockIn(StockDTO stock) {

        stock.setStockOut(0);

        return addStock(stock);
    }

    @Override
    public boolean stockOut(StockDTO stock) {

        stock.setStockIn(0);

        return addStock(stock);
    }

    @Override
    public int getAvailableStock(int productId) {

        String query = "SELECT SUM(stock_in)-SUM(stock_out) AS available FROM stock WHERE product_id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("available");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}