package model;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Bery
 */
public class ConnectionProvider {
    public ConnectionProvider() {
    }

    private static final String username = "postgres";
    private static final String password = "K@@s"; //or whatever your password is?
    private static final String conURL = "jdbc:postgresql://localhost:5432/StudentDB";
    private static final String DRIVER = "org.postgresql.Driver";
    private Connection con;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(conURL, username, password);
    }

    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public void Add(String id, String Name, String Surname, String Email, String PhoneNo, String Pass) throws SQLException, ClassNotFoundException {
        try (Connection conn = getConnection(); PreparedStatement pst = conn.prepareStatement("INSERT INTO \"Student\"(student_number, name, surname, email, phone, password) VALUES(?,?,?,?,?,?)")) {
            pst.setString(1, id);
            pst.setString(2, Name);
            pst.setString(3, Surname);
            pst.setString(4, Email);
            pst.setString(5, PhoneNo);
            pst.setString(6, hashPassword(Pass));
            pst.executeUpdate();
        }
    }

    public boolean emailExists(String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean exists = false;
        try {
            conn = getConnection();
            pst = conn.prepareStatement("SELECT * FROM \"Student\" WHERE email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) exists = true;
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        }
        return exists;
    }

    public boolean studentNumberExists(String studentNumber) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean exists = false;
        try {
            conn = getConnection();
            pst = conn.prepareStatement("SELECT * FROM \"Student\" WHERE student_number = ?");
            pst.setString(1, studentNumber);
            rs = pst.executeQuery();
            if (rs.next()) exists = true;
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        }
        return exists;
    }

    public User authenticateUser(String email, String password) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getConnection();
            if (conn == null) {
                throw new SQLException("Database connection is null");
            }
            pst = conn.prepareStatement("SELECT * FROM \"Student\" WHERE email = ? AND password = ?");
            pst.setString(1, email);
            pst.setString(2, hashPassword(password));
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setStudentNumber(rs.getString("student_number"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                System.out.println("Authenticated user: " + user.getEmail() + ", " + user.getName() + ", " + user.getPhone());
            }
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        }
        return user;
    }

    public User getUserByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = getConnection();
            if (conn == null) {
                throw new SQLException("Database connection is null");
            }
            pst = conn.prepareStatement("SELECT * FROM \"Student\" WHERE email = ?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setStudentNumber(rs.getString("student_number"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }
        } finally {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        }
        return user;
    }
}