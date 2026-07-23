package Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import dao.SalesDAO;
import daoimpl.SalesDAOImpl;
import dto.SalesDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Sales")
public class Sales extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SalesDAO dao = new SalesDAOImpl();

        List<SalesDTO> sales = dao.getAllSales();

        request.setAttribute("sales", sales);

        request.getRequestDispatcher("Sales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        SalesDAO dao = new SalesDAOImpl();

        if ("add".equals(action)) {

            SalesDTO sale = new SalesDTO();

            sale.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
            sale.setTotalAmount(Double.parseDouble(request.getParameter("totalAmount")));
            sale.setSaleDate(Timestamp.valueOf(request.getParameter("saleDate").replace("T", " ") + ":00"));

            boolean result = dao.addSale(sale);

            if (result) {
                request.setAttribute("success", "Sale Added Successfully");
            } else {
                request.setAttribute("error", "Failed To Add Sale");
            }

        } else if ("delete".equals(action)) {

            int saleId = Integer.parseInt(request.getParameter("saleId"));

            boolean result = dao.deleteSale(saleId);

            if (result) {
                request.setAttribute("success", "Sale Deleted Successfully");
            } else {
                request.setAttribute("error", "Failed To Delete Sale");
            }
        }

        request.setAttribute("sales", dao.getAllSales());

        request.getRequestDispatcher("Sales.jsp").forward(request, response);
    }
}