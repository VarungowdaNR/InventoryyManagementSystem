package test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.SalesDAO;
import daoimpl.SalesDAOImpl;
import dto.SaleItemsDTO;
import dto.SalesDTO;

public class SalesModule {

    public static void main(String[] args) {

        SalesDAO dao = new SalesDAOImpl();

        // INSERT
       

//        SalesDTO sale = new SalesDTO();
//
//        sale.setCustomerId(1);
//        sale.setTotalAmount(5000);
//        sale.setSaleDate(new Timestamp(System.currentTimeMillis()));
//
//        boolean result = dao.addSale(sale);
//
//        if(result)
//            System.out.println("Sale Added Successfully");
//        else
//            System.out.println("Failed to Add Sale");



        // GENERATE SALE
       

//        SalesDTO sale = new SalesDTO();
//
//        sale.setCustomerId(1);
//        sale.setSaleDate(new Timestamp(System.currentTimeMillis()));
//
//        List<SaleItemsDTO> items = new ArrayList<>();
//
//        SaleItemsDTO item = new SaleItemsDTO();
//
//        item.setProductId(1);
//        item.setQuantity(2);
//        item.setPrice(5000);
//        item.setSubtotal(10000);
//
//        items.add(item);
//
//        boolean result = dao.generateSale(sale, items);
//
//        if(result)
//            System.out.println("Sale Generated Successfully");
//        else
//            System.out.println("Sale Generation Failed");



        // DISPLAY ALL
  

//        List<SalesDTO> list = dao.getAllSales();
//
//        for(SalesDTO sale : list){
//
//            System.out.println(sale);
//
//        }



        // ============================
        // SEARCH
        // ============================

//        SalesDTO sale = dao.getSaleById(1);
//
//        if(sale != null)
//            System.out.println(sale);
//        else
//            System.out.println("Sale Not Found");



        // UPDATE
        

//        SalesDTO sale = new SalesDTO();
//
//        sale.setSaleId(1);
//        sale.setCustomerId(1);
//        sale.setTotalAmount(15000);
//        sale.setSaleDate(new Timestamp(System.currentTimeMillis()));
//
//        boolean result = dao.updateSale(sale);
//
//        if(result)
//            System.out.println("Sale Updated Successfully");
//        else
//            System.out.println("Update Failed");



        // DELETE
       

//        boolean result = dao.deleteSale(1);
//
//        if(result)
//            System.out.println("Sale Deleted Successfully");
//        else
//            System.out.println("Delete Failed");


        // CALCULATE TOTAL AMOUNT
        

//        double total = dao.calculateTotalAmount(1);
//
//        System.out.println("Total Amount : " + total);



        // SALES BY CUSTOMER
        

//        List<SalesDTO> list = dao.getSalesByCustomer(1);
//
//        for(SalesDTO sale : list){
//
//            System.out.println(sale);
//
//        }

    }

}