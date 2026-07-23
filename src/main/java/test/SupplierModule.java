package test;

import java.util.List;

import dao.SupplierDAO;
import daoimpl.SupplierDAOImpl;
import dto.SupplierDTO;

public class SupplierModule {

    public static void main(String[] args) {

        SupplierDAO dao = new SupplierDAOImpl();

        // ADD SUPPLIER
        

//        SupplierDTO supplier = new SupplierDTO();
//
//        supplier.setSupplierName("ABC Traders");
//        supplier.setContactPerson("Ramesh");
//        supplier.setMobile("9876543210");
//        supplier.setEmail("abc@gmail.com");
//        supplier.setAddress("Bangalore");
//
//        boolean result = dao.addSupplier(supplier);
//
//        if(result)
//            System.out.println("Supplier Added Successfully");
//        else
//            System.out.println("Supplier Add Failed");


        // DISPLAY ALL SUPPLIERS
        

//        List<SupplierDTO> list = dao.getAllSuppliers();
//
//        for(SupplierDTO supplier : list) {
//
//            System.out.println(supplier);
//
//        }


        // SEARCH SUPPLIER
        

//        SupplierDTO supplier = dao.getSupplierById(1);
//
//        if(supplier != null)
//            System.out.println(supplier);
//        else
//            System.out.println("Supplier Not Found");


       
        // UPDATE SUPPLIER
       

//        SupplierDTO supplier = new SupplierDTO();
//
//        supplier.setSupplierId(1);
//        supplier.setSupplierName("XYZ Traders");
//        supplier.setContactPerson("Suresh");
//        supplier.setMobile("9999999999");
//        supplier.setEmail("xyz@gmail.com");
//        supplier.setAddress("Mysore");
//
//        boolean result = dao.updateSupplier(supplier);
//
//        if(result)
//            System.out.println("Updated Successfully");
//        else
//            System.out.println("Update Failed");


        
        // DELETE SUPPLIER
       

//        boolean result = dao.deleteSupplier(1);
//
//        if(result)
//            System.out.println("Deleted Successfully");
//        else
//            System.out.println("Delete Failed");

    }
}