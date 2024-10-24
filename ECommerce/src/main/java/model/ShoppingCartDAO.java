package model;

import utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShoppingCartDAO {

    // Method to add an item to the cart
    public boolean addToCart(int productId, int buyerId, String productName, int quantity, double price) {
        String sql = "INSERT INTO ShoppingCart (prod_id, buyer_id, quantity, price) VALUES (?, ?, ?, ?) "
                   + "ON DUPLICATE KEY UPDATE quantity = quantity + ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            stmt.setInt(2, buyerId);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, price); // Set the price
            stmt.setInt(5, quantity); // Update quantity if the product is already in the cart

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Returns true if an item was added or quantity updated

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }

    // Method to delete an item from the cart
    public boolean deleteFromCart(int productId, int buyerId) {
        String sql = "DELETE FROM ShoppingCart WHERE prod_id = ? AND buyer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productId); // Use productId instead of cartId for deletion
            stmt.setInt(2, buyerId); // Include buyerId to ensure the right cart item is deleted

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0; // Returns true if a product was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
}