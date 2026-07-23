package dao;

import java.util.List;

import dto.SaleItemsDTO;
import dto.SalesDTO;

public interface SalesDAO {

    boolean addSale(SalesDTO sale);

    List<SalesDTO> getAllSales();

    SalesDTO getSaleById(int saleId);

    boolean updateSale(SalesDTO sale);

    boolean deleteSale(int saleId);


    boolean generateSale(SalesDTO sale,
            List<SaleItemsDTO> items);

    boolean generateSale(SalesDTO sale, int productId,int quantity);

    double calculateTotalAmount(int saleId);
    List<SalesDTO> getSalesByCustomer(int customerId);

}