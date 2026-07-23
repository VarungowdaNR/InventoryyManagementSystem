package Servlet;

import java.io.IOException;
import java.util.List;

import dao.CategoryDAO;
import daoimpl.CategoryDAOImpl;
import dto.CategoryDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Category")
public class Category extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

    CategoryDAO dao = new CategoryDAOImpl();
    List<CategoryDTO> categories = dao.getAllCategories();

    request.setAttribute("categories", categories);
    request.getRequestDispatcher("Category.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    UserDTO user = (UserDTO) request.getSession().getAttribute("user");

    if(user == null || !"Admin".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("Category");
        return;
    }

    String action = request.getParameter("action");
    CategoryDAO dao = new CategoryDAOImpl();

    if("add".equals(action)) {

        CategoryDTO category = new CategoryDTO();
        category.setCategoryName(request.getParameter("categoryName"));
        category.setDescription(request.getParameter("description"));

        dao.addCategory(category);

    }else if("update".equals(action)) {

        CategoryDTO category = new CategoryDTO();
        category.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        category.setCategoryName(request.getParameter("categoryName"));
        category.setDescription(request.getParameter("description"));

        dao.updateCategory(category);

    }else if("delete".equals(action)) {

        int id = Integer.parseInt(request.getParameter("categoryId"));
        dao.deleteCategory(id);
    }

    response.sendRedirect("Category");
}

}