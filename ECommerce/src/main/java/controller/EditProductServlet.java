package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductDAO;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch form parameters
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        String prodName = request.getParameter("productName");
        String prodDescription = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Use the DAO to update the product
        ProductDAO productDAO = new ProductDAO();
        boolean isUpdated = productDAO.updateProduct(prodId, prodName, prodDescription, price,quantity);

        if (isUpdated) {
            // Redirect to success page if update is successful
            response.sendRedirect("Product is updated successfully");
        } else {
            // Show error if no product was updated
            request.setAttribute("error", "Failed to update product.");
            request.getRequestDispatcher("edit-product.jsp").forward(request, response);
        }
    }
}