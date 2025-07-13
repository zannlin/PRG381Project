package dao;

import model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppointmentDAO {
    private static final Logger logger = Logger.getLogger(AppointmentDAO.class.getName());

    public static void createTable() {
        String sql = "CREATE TABLE Appointments (" +
                "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "student VARCHAR(100), " +
                "counselor VARCHAR(100), " +
                "date DATE, " +
                "time TIME, " +
                "status VARCHAR(50))";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Appointments table created.");

        } catch (SQLException e) {
            System.out.println("Table probably exists: " + e.getMessage());
            logger.severe(e.getMessage());
        }
    }

    //Add appointment
    public static void addAppointment(Appointment a) {
        String sql = "INSERT INTO Appointments (student, counselor, date, time, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getStudent());
            stmt.setString(2, a.getCounselor());
            stmt.setDate(3, Date.valueOf(a.getDate()));
            stmt.setTime(4, Time.valueOf(a.getTime()));
            stmt.setString(5, a.getStatus());
            stmt.executeUpdate();
            System.out.println("Appointment added successfully");

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    //Get all appointments
    public static List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointments";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Appointment a = new Appointment(
                        rs.getInt("id"),
                        rs.getString("student"),
                        rs.getString("counselor"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime(),
                        rs.getString("status")
                );
                appointments.add(a);
            }

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

        return appointments;
    }

    // Update Appointment by id
    public static void updateAppointment(Appointment a) {
        String sql = "UPDATE Appointments SET student = ?,counselor = ?, date = ?, time = ?, status = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getStudent());
            stmt.setString(2, a.getCounselor());
            stmt.setDate(3, Date.valueOf(a.getDate()));
            stmt.setTime(4, Time.valueOf(a.getTime()));
            stmt.setString(5, a.getStatus());
            stmt.setInt(6, a.getId());
            stmt.executeUpdate();
            System.out.println("Appointment updated successfully");

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    //Delete appointment by id
    public static void deleteAppointment(Appointment a) {
        String sql = "DELETE FROM Appointments WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, a.getId());
            stmt.executeUpdate();
            System.out.println("Appointment deleted");

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
