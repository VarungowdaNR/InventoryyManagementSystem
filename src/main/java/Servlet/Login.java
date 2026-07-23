package Servlet;

import java.io.IOException;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAOImpl();
        UserDTO user = dao.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("dashboard.jsp");

        } else {

            request.setAttribute("msg", "Invalid Email or Password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        }
    }
}