package Servlet;

import java.io.IOException;
import java.util.List;

import dao.SupplierDAO;
import daoimpl.SupplierDAOImpl;
import dto.SupplierDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Supplier")
public class Supplier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SupplierDAO dao = new SupplierDAOImpl();

        List<SupplierDTO> suppliers = dao.getAllSuppliers();

        request.setAttribute("suppliers", suppliers);

        request.getRequestDispatcher("Supplier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        
        if (user == null || !"Admin".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect("Supplier");
            return;
        }

        String action = request.getParameter("action");

        SupplierDAO dao = new SupplierDAOImpl();

        if ("add".equals(action)) {

            SupplierDTO supplier = new SupplierDTO();

            supplier.setSupplierName(request.getParameter("supplierName"));
            supplier.setContactPerson(request.getParameter("contactPerson"));
            supplier.setMobile(request.getParameter("mobile"));
            supplier.setEmail(request.getParameter("email"));
            supplier.setAddress(request.getParameter("address"));

            dao.addSupplier(supplier);

        } else if ("update".equals(action)) {

            SupplierDTO supplier = new SupplierDTO();

            supplier.setSupplierId(Integer.parseInt(request.getParameter("supplierId")));
            supplier.setSupplierName(request.getParameter("supplierName"));
            supplier.setContactPerson(request.getParameter("contactPerson"));
            supplier.setMobile(request.getParameter("mobile"));
            supplier.setEmail(request.getParameter("email"));
            supplier.setAddress(request.getParameter("address"));

            dao.updateSupplier(supplier);

        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("supplierId"));

            dao.deleteSupplier(id);
        }

        response.sendRedirect("Supplier");
    }
}