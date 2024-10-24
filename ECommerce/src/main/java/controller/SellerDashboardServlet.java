package controller;

import model.ProductDAO;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Product; // Ensure you import your Product model

@WebServlet("/SellerDashboardServlet")
public class SellerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the seller ID from session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Check if the user is logged in and is a seller
        if (user != null && "seller".equals(user.getRole())) {
            // Optionally, you can fetch the products associated with this seller
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = productDAO.getProductsBySellerId(user.getId()); // Implement this method in ProductDAO
            
            request.setAttribute("products", products); // Set products as request attribute
            session.setAttribute("id", user.getId());
            // Forward to the seller dashboard JSP page
            request.getRequestDispatcher("seller-dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp?error=You must be logged in as a seller.");
        }
    }
}
