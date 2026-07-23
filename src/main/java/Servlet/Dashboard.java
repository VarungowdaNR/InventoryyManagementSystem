package Servlet;

import java.io.IOException;

import dao.DashboardDAO;
import daoimpl.DashboardDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DashboardDAO dao = new DashboardDAOImpl();

        request.setAttribute("totalProducts", dao.getTotalProducts());
        request.setAttribute("totalCategories", dao.getTotalCategories());
        request.setAttribute("totalSuppliers", dao.getTotalSuppliers());
        request.setAttribute("totalCustomers", dao.getTotalCustomers());
        request.setAttribute("availableStock", dao.getAvailableStock());
        request.setAttribute("totalSales", dao.getTotalSales());

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}