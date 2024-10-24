package controller;

import model.User;
import model.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticateUser(username, password); // Ensure this method checks role

        if (user != null) {
            // Set user details in session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole()); // Store role
            session.setAttribute("id", user.getId()); // Store userId in session

            // Redirect based on user role
            if ("buyer".equals(user.getRole())) {
                // Redirect to buyer dashboard
                response.sendRedirect("BuyerDashboardServlet");
            } else if ("seller".equals(user.getRole())) {
                // Redirect to seller dashboard
                response.sendRedirect("SellerDashboardServlet"); 
            } else {
                // If role is neither buyer nor seller
                request.setAttribute("error", "Invalid user role.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Redirect back to login page with error message
            request.setAttribute("error", "Invalid credentials.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
