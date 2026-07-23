package Servlet;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/User")
public class User extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    UserDAO dao = new UserDAOImpl();
    List<UserDTO> users = dao.getAllUsers();

    request.setAttribute("users", users);
    request.getRequestDispatcher("User.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String action = request.getParameter("action");
    UserDAO dao = new UserDAOImpl();

    if("delete".equals(action)) {

        int userId = Integer.parseInt(request.getParameter("userId"));
        dao.deleteUser(userId);
    }

    response.sendRedirect("User");
}

}