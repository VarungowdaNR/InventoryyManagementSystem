package Servlet;

import java.io.IOException;
import java.util.List;

import dao.SaleItemsDAO;
import daoimpl.SaleItemsDAOImpl;
import dto.SaleItemsDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaleItems")
public class SalesItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	   UserDTO user = (UserDTO) request.getSession().getAttribute("user");


    	    if(user == null ||
    	       (!user.getRole().equalsIgnoreCase("Admin")
    	       && !user.getRole().equalsIgnoreCase("Employee"))) {

    	        response.sendRedirect("Login.jsp");
    	        return;
    	    }


    	    SaleItemsDAO dao = new SaleItemsDAOImpl();

    	    List<SaleItemsDTO> saleItems = dao.getAllSaleItems();

    	    request.setAttribute("saleItems", saleItems);


    	    request.getRequestDispatcher("SaleItems.jsp")
    	           .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if (user == null ||
        		   (!user.getRole().equalsIgnoreCase("Admin")
        		   && !user.getRole().equalsIgnoreCase("Employee"))) {

        		    response.sendRedirect("Login.jsp");
        		    return;
        		}
        String action = request.getParameter("action");

        SaleItemsDAO dao = new SaleItemsDAOImpl();

        if ("add".equals(action)) {

            SaleItemsDTO saleItem = new SaleItemsDTO();

            saleItem.setSaleId(Integer.parseInt(request.getParameter("saleId")));
            saleItem.setProductId(Integer.parseInt(request.getParameter("productId")));
            saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            saleItem.setPrice(Double.parseDouble(request.getParameter("price")));
            saleItem.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));

            dao.addSaleItem(saleItem);

        } else if ("update".equals(action)) {

            SaleItemsDTO saleItem = new SaleItemsDTO();

            saleItem.setSaleItemId(Integer.parseInt(request.getParameter("saleItemId")));
            saleItem.setSaleId(Integer.parseInt(request.getParameter("saleId")));
            saleItem.setProductId(Integer.parseInt(request.getParameter("productId")));
            saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            saleItem.setPrice(Double.parseDouble(request.getParameter("price")));
            saleItem.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));

            dao.updateSaleItem(saleItem);

        } else if ("delete".equals(action)) {

            int saleItemId = Integer.parseInt(request.getParameter("saleItemId"));

            dao.deleteSaleItem(saleItemId);
        }

        response.sendRedirect("SaleItems");
    }
}