package dao;

import java.util.List;

import dto.CustomerDTO;

public interface CustomerDAO {

    boolean addCustomer(CustomerDTO customer);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(int customerId);

    boolean updateCustomer(CustomerDTO customer);

    boolean deleteCustomer(int customerId);

}