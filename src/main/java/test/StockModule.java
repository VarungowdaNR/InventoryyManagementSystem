package test;

import java.sql.Date;
import java.util.List;

import dao.StockDAO;
import daoimpl.StockDAOImpl;
import dto.StockDTO;

public class StockModule {

    public static void main(String[] args) {

        StockDAO dao = new StockDAOImpl();

      
        // ADD STOCK
      

//        StockDTO stock = new StockDTO();
//
//        stock.setProductId(1);
//        stock.setStockIn(10);
//        stock.setStockOut(0);
//        stock.setStockDate(Date.valueOf("2026-07-16"));
//        stock.setRemarks("Initial Stock");
//
//        boolean result = dao.addStock(stock);
//
//        if(result)
//            System.out.println("Stock Added Successfully");
//        else
//            System.out.println("Stock Add Failed");


        // DISPLAY ALL STOCK
        

//        List<StockDTO> list = dao.getAllStock();
//
//        for(StockDTO stock : list) {
//
//            System.out.println(stock);
//
//        }


        // SEARCH STOCK
       

//        StockDTO stock = dao.getStockById(1);
//
//        if(stock != null)
//            System.out.println(stock);
//        else
//            System.out.println("Stock Not Found");


        
        // UPDATE STOCK
       

//        StockDTO stock = new StockDTO();
//
//        stock.setStockId(1);
//        stock.setProductId(1);
//        stock.setStockIn(20);
//        stock.setStockOut(0);
//        stock.setStockDate(Date.valueOf("2026-07-16"));
//        stock.setRemarks("Updated Stock");
//
//        boolean result = dao.updateStock(stock);
//
//        if(result)
//            System.out.println("Updated Successfully");
//        else
//            System.out.println("Update Failed");


       
        // DELETE STOCK
  

//        boolean result = dao.deleteStock(1);
//
//        if(result)
//            System.out.println("Deleted Successfully");
//        else
//            System.out.println("Delete Failed");


        // STOCK IN
        

//        StockDTO stock = new StockDTO();
//
//        stock.setProductId(1);
//        stock.setStockIn(5);
//        stock.setStockDate(Date.valueOf("2026-07-16"));
//        stock.setRemarks("Stock In");
//
//        boolean result = dao.stockIn(stock);
//
//        if(result)
//            System.out.println("Stock In Successful");
//        else
//            System.out.println("Stock In Failed");


        // STOCK OUT
       

//        StockDTO stock = new StockDTO();
//
//        stock.setProductId(1);
//        stock.setStockOut(3);
//        stock.setStockDate(Date.valueOf("2026-07-16"));
//        stock.setRemarks("Stock Out");
//
//        boolean result = dao.stockOut(stock);
//
//        if(result)
//            System.out.println("Stock Out Successful");
//        else
//            System.out.println("Stock Out Failed");


        
        // AVAILABLE STOCK
     

//        int qty = dao.getAvailableStock(1);
//
//        System.out.println("Available Stock : " + qty);

    }
}