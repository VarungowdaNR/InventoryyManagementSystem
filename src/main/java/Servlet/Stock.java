package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.StockDAO;
import daoimpl.StockDAOImpl;
import dto.StockDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Stock")
public class Stock extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        StockDAO dao = new StockDAOImpl();

        List<StockDTO> stocks = dao.getAllStock();

        request.setAttribute("stocks", stocks);

        request.getRequestDispatcher("Stock.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

       
        if (!user.getRole().equalsIgnoreCase("Admin")) {
            response.sendRedirect("Stock");
            return;
        }

        String action = request.getParameter("action");

        StockDAO dao = new StockDAOImpl();

        if ("add".equals(action)) {

            StockDTO stock = new StockDTO();
            stock.setProductId(Integer.parseInt(request.getParameter("productId")));
            stock.setStockIn(Integer.parseInt(request.getParameter("stockIn")));
            stock.setStockOut(0);
            stock.setStockDate(Date.valueOf(request.getParameter("stockDate")));
            stock.setRemarks(request.getParameter("remarks"));

            boolean result = dao.addStock(stock);

            if (result) {
                request.setAttribute("success", "Stock Added Successfully");
            } else {
                request.setAttribute("error", "Failed to Add Stock");
            }

        } else if ("stockOut".equals(action)) {

            StockDTO stock = new StockDTO();
            stock.setProductId(Integer.parseInt(request.getParameter("productId")));
            stock.setStockOut(Integer.parseInt(request.getParameter("stockOut")));
            stock.setStockDate(Date.valueOf(request.getParameter("stockDate")));
            stock.setRemarks(request.getParameter("remarks"));

            boolean result = dao.stockOut(stock);

            if (result) {
                request.setAttribute("success", "Stock Out Successfully");
            } else {
                request.setAttribute("error", "Failed to Stock Out");
            }

        } else if ("delete".equals(action)) {

            int stockId = Integer.parseInt(request.getParameter("stockId"));

            boolean result = dao.deleteStock(stockId);

            if (result) {
                request.setAttribute("success", "Stock Deleted Successfully");
            } else {
                request.setAttribute("error", "Failed to Delete Stock");
            }
        }

       
        List<StockDTO> stocks = dao.getAllStock();
        request.setAttribute("stocks", stocks);

        request.getRequestDispatcher("Stock.jsp").forward(request, response);
    }
}