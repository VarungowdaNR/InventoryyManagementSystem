package Servlet;

import java.io.IOException;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Full Name : " + request.getParameter("fullName"));
        System.out.println("Email     : " + request.getParameter("email"));
        System.out.println("Mobile    : " + request.getParameter("mobile"));
        System.out.println("Username  : " + request.getParameter("username"));
        System.out.println("Password  : " + request.getParameter("password"));
        System.out.println("Role      : " + request.getParameter("role"));

        UserDTO user = new UserDTO();

        user.setFullName(request.getParameter("fullName"));
        user.setEmail(request.getParameter("email"));
        user.setMobile(request.getParameter("mobile"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));

        UserDAO dao = new UserDAOImpl();

        boolean status = dao.registerUser(user);

        System.out.println("Register Status = " + status);

        if (status) {
            response.sendRedirect("Login.jsp");
        } else {
            request.setAttribute("msg", "Registration Failed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}