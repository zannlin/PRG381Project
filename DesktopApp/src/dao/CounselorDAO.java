package dao;

import model.Counselor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class CounselorDAO {
    private static final Logger logger = Logger.getLogger(CounselorDAO.class.getName());

    // Create counselor table
    public static void createTable() {
        String sql = "CREATE TABLE Counselors (" +
                "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "name VARCHAR(100), " +
                "specialization VARCHAR(100), " +
                "availability VARCHAR(100))";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Counselors table created.");

        } catch (SQLException e) {
            System.out.println("Table probably exists: " + e.getMessage());
            logger.severe(e.getMessage());
        }
    }

    // Add a new counselor
    public static void addCounselor(Counselor c) {
        String sql = "INSERT INTO Counselors (name, specialization, availability) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getSpecialization());
            stmt.setString(3, c.getAvailability());
            stmt.executeUpdate();
            System.out.println("Counselor added.");

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    // Get all counselors
    public static List<Counselor> getAllCounselors() {
        List<Counselor> counselors = new ArrayList<>();
        String sql = "SELECT * FROM Counselors";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Counselor c = new Counselor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("availability")
                );
                counselors.add(c);
            }

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }

        return counselors;
    }

    // Update a counselor
    public static void updateCounselor(Counselor c) {
        String sql = "UPDATE Counselors SET name = ?, specialization = ?, availability = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getSpecialization());
            stmt.setString(3, c.getAvailability());
            stmt.setInt(4, c.getId());
            stmt.executeUpdate();
            System.out.println("Counselor updated.");

        } catch (SQLException e) {
            logger.severe(e.getMessage());
        }
    }

    public static void deleteCounselor(int id) {
        String sql = "DELETE FROM Counselors WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Counselor deleted");

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
    public static List<String> getAllCounselorNames() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT name FROM Counselors";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                names.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            logger.severe("Error retrieving counselor names: " + e.getMessage());
        }

        return names;
    }
}
