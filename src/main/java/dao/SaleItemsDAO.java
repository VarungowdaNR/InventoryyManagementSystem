package dao;

import java.util.List;

import dto.SaleItemsDTO;

public interface SaleItemsDAO {

    boolean addSaleItem(SaleItemsDTO saleItem);

    List<SaleItemsDTO> getAllSaleItems();

    SaleItemsDTO getSaleItemById(int saleItemId);

    boolean updateSaleItem(SaleItemsDTO saleItem);

    boolean deleteSaleItem(int saleItemId);

}