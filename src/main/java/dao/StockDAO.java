package dao;

import java.util.List;

import dto.StockDTO;

public interface StockDAO {

    // CRUD Operations
    boolean addStock(StockDTO stock);

    List<StockDTO> getAllStock();

    StockDTO getStockById(int stockId);

    boolean updateStock(StockDTO stock);

    boolean deleteStock(int stockId);

    // Business Operations
    boolean stockIn(StockDTO stock);

    boolean stockOut(StockDTO stock);

    int getAvailableStock(int productId);

}