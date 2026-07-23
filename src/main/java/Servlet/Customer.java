package Servlet;

import java.io.IOException;
import java.util.List;

import dao.CustomerDAO;
import daoimpl.CustomerDAOImpl;
import dto.CustomerDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Customer")
public class Customer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CustomerDAO dao = new CustomerDAOImpl();

        List<CustomerDTO> customers = dao.getAllCustomers();

        request.setAttribute("customers", customers);

        request.getRequestDispatcher("Customer.jsp").forward(request, response);
    
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        CustomerDAO dao = new CustomerDAOImpl();

        if ("add".equals(action)) {

            CustomerDTO customer = new CustomerDTO();
            customer.setCustomerName(request.getParameter("customerName"));
            customer.setMobile(request.getParameter("mobile"));
            customer.setEmail(request.getParameter("email"));
            customer.setAddress(request.getParameter("address"));

            boolean result = dao.addCustomer(customer);

            if (result) {
                request.setAttribute("success", "Customer Added Successfully");
            } else {
                request.setAttribute("error", "Failed To Add Customer");
            }

            request.setAttribute("customers", dao.getAllCustomers());
            request.getRequestDispatcher("Customer.jsp").forward(request, response);

        } else if ("delete".equals(action)) {

            int customerId = Integer.parseInt(request.getParameter("customerId"));

            boolean result = dao.deleteCustomer(customerId);

            if (result) {
                request.setAttribute("success", "Customer Deleted Successfully");
            } else {
                request.setAttribute("error", "Failed To Delete Customer");
            }

            request.setAttribute("customers", dao.getAllCustomers());
            request.getRequestDispatcher("Customer.jsp").forward(request, response);
        }
    
}
}