package Servlet;

import java.io.IOException;

import dto.UserDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {

            UserDTO user = (UserDTO) session.getAttribute("user");

            if (user != null) {

                session.invalidate();
                request.setAttribute("msg", "Logout Successfully");

            } else {

                request.setAttribute("error", "Session Expired");
            }

        } else {

            request.setAttribute("error", "Session Expired");
        }

        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
        rd.forward(request, response);
    }
}