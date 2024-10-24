package controller;

import model.ShoppingCartDAO;
import model.ProductDAO; // Make sure to import ProductDAO to fetch product details
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName"); // Get product name from the request
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Get buyerId from session
        HttpSession session = request.getSession();
        int buyerId = (int) session.getAttribute("id");

        // Fetch product price using ProductDAO
        ProductDAO productDAO = new ProductDAO();
        double price = productDAO.getProductPriceById(productId); // Create this method in ProductDAO

        // Add to cart
        ShoppingCartDAO cartDAO = new ShoppingCartDAO();
        boolean isAdded = cartDAO.addToCart(productId, buyerId, productName, quantity, price); // Update method call

        if (isAdded) {
            response.sendRedirect("buyer-dashboard.jsp?message=Item added to cart");
        } else {
            response.sendRedirect("buyer-dashboard.jsp?error=Failed to add item to cart");
        }
    }
}
