package test;

import java.util.List;

import dao.CustomerDAO;
import daoimpl.CustomerDAOImpl;
import dto.CustomerDTO;

public class CustomerModule {

    public static void main(String[] args) {

        CustomerDAO dao = new CustomerDAOImpl();
      
        // INSERT

//        CustomerDTO customer = new CustomerDTO();
//
//        customer.setCustomerName("Rahul");
//        customer.setMobile("9876543210");
//        customer.setEmail("rahul@gmail.com");
//        customer.setAddress("Bangalore");
//
//        boolean result = dao.addCustomer(customer);
//
//        if(result)
//            System.out.println("Customer Added Successfully");
//        else
//            System.out.println("Failed to Add Customer");



      
        // DISPLAY ALL
        

//        List<CustomerDTO> list = dao.getAllCustomers();
//
//        for(CustomerDTO customer : list) {
//
//            System.out.println(customer);
//
//        }



        
        // SEARCH
        

//        CustomerDTO customer = dao.getCustomerById(1);
//
//        if(customer != null)
//            System.out.println(customer);
//        else
//            System.out.println("Customer Not Found");



        
        // UPDATE
        

//        CustomerDTO customer = new CustomerDTO();
//
//        customer.setCustomerId(1);
//        customer.setCustomerName("Rahul Kumar");
//        customer.setMobile("9999999999");
//        customer.setEmail("rahulkumar@gmail.com");
//        customer.setAddress("Mysore");
//
//        boolean result = dao.updateCustomer(customer);
//
//        if(result)
//            System.out.println("Customer Updated Successfully");
//        else
//            System.out.println("Update Failed");




        // DELETE
     

//        boolean result = dao.deleteCustomer(1);
//
//        if(result)
//            System.out.println("Customer Deleted Successfully");
//        else
//            System.out.println("Delete Failed");

    }

}