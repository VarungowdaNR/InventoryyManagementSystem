package Servlet;

import java.io.IOException;
import java.util.List;

import dao.ProductDAO;
import daoimpl.ProductDAOImpl;
import dto.ProductDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Product")
public class Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAOImpl();

        List<ProductDTO> products = dao.getAllProductsWithDetails();

        request.setAttribute("products", products);

        request.getRequestDispatcher("Product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if (user == null || !"Admin".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect("Product");
            return;
        }

        String action = request.getParameter("action");

        ProductDAO dao = new ProductDAOImpl();

        if ("add".equals(action)) {

            ProductDTO product = new ProductDTO();

            product.setProductName(request.getParameter("productName"));
            product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
            product.setSupplierId(Integer.parseInt(request.getParameter("supplierId")));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            product.setDescription(request.getParameter("description"));
            product.setManufactureDate(java.sql.Date.valueOf(request.getParameter("manufactureDate")));
            product.setExpiryDate(java.sql.Date.valueOf(request.getParameter("expiryDate")));

            dao.addProduct(product);

        } else if ("update".equals(action)) {

            ProductDTO product = new ProductDTO();

            product.setProductId(Integer.parseInt(request.getParameter("productId")));
            product.setProductName(request.getParameter("productName"));
            product.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
            product.setSupplierId(Integer.parseInt(request.getParameter("supplierId")));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            product.setDescription(request.getParameter("description"));
            product.setManufactureDate(java.sql.Date.valueOf(request.getParameter("manufactureDate")));
            product.setExpiryDate(java.sql.Date.valueOf(request.getParameter("expiryDate")));

            dao.updateProduct(product);

        } else if ("delete".equals(action)) {

            int productId = Integer.parseInt(request.getParameter("productId"));

            dao.deleteProduct(productId);
        }

        response.sendRedirect("Product");
    }
}