package dao;
import model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FeedbackDAO {
    private static final Logger logger = Logger.getLogger(FeedbackDAO.class.getName());

    // Create table
    public static void createTable() {
        String sql = "CREATE TABLE Feedback (" +
                "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "student VARCHAR(100), " +
                "rating INT, " +
                "comments VARCHAR(500))";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Feedback table created.");

        } catch (SQLException e) {
            System.out.println("Table probably exists: " + e.getMessage());
            logger.severe(e.getMessage());
        }
    }

    // Add new feedback
    public static void addFeedback(Feedback f) {
        String sql = "INSERT INTO Feedback (student, rating, comments) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getStudent());
            stmt.setInt(2, f.getRating());
            stmt.setString(3, f.getComments());

            stmt.executeUpdate();
            System.out.println("Feedback added.");

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    // Get all feedback entries
    public static List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM Feedback ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Feedback f = new Feedback(
                        rs.getInt("id"),
                        rs.getString("student"),
                        rs.getInt("rating"),
                        rs.getString("comments")
                );
                feedbacks.add(f);
            }

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }

        return feedbacks;
    }

    // Update existing feedback
    public static void updateFeedback(Feedback f) {
        String sql = "UPDATE Feedback SET student=?, rating=?, comments=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getStudent());
            stmt.setInt(2, f.getRating());
            stmt.setString(3, f.getComments());
            stmt.setInt(4, f.getId());

            stmt.executeUpdate();
            System.out.println("Feedback updated.");

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    // Delete feedback by id
    public static void deleteFeedback(int id) {
        String sql = "DELETE FROM Feedback WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Feedback deleted.");

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

}
