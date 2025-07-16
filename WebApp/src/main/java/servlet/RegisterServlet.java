package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import model.ConnectionProvider;
import model.User;

/**
 * This servlet handles user registration for the web app.
 * - Validates user input (email, phone, password).
 * - Checks if email or student number already exists.
 * - Adds the user to the database and redirects to dashboard.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    // Patterns to check if the input is valid
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$|^\\d{3}-\\d{3}-\\d{4}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Show the registration page when user visits /register
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response to show HTML
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get all the data from the registration form
        String studentNumber = request.getParameter("txtStudentNumber");
        String name = request.getParameter("txtName");
        String surname = request.getParameter("txtSurname");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhoneNumber");
        String password = request.getParameter("txtPassword");

        // Check if any field is empty
        if (studentNumber == null || studentNumber.trim().isEmpty() ||
                name == null || name.trim().isEmpty() ||
                surname == null || surname.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return; // Stop if there's an error
        }

        // Check if email format is valid
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            request.setAttribute("errorMessage", "Invalid email format");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Check if phone number format is valid
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            request.setAttribute("errorMessage", "Invalid phone number format (use 10 digits or format like 012-345-6789)");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Check if password meets requirements
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            request.setAttribute("errorMessage", "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one number");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try {
            // Create a connection to the database
            ConnectionProvider cp = new ConnectionProvider();
            // Check if email is already in use
            if (cp.emailExists(email)) {
                request.setAttribute("errorMessage", "Email already exists");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            // Check if student number is already in use
            if (cp.studentNumberExists(studentNumber)) {
                request.setAttribute("errorMessage", "Student number already exists");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Add the new user to the database (password will be hashed)
            cp.Add(studentNumber, name, surname, email, phone, password);
            System.out.println("User added to database: " + email + ", " + name + ", " + phone);

            // Create a User object with the registered data
            User user = new User(studentNumber, name, surname, email, phone, null); // Password not needed in session

            // Save the user details in the session
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Save the whole user object
            session.setAttribute("email", email); // Save email separately
            session.setAttribute("name", name); // Save name separately
            session.setAttribute("phone", phone); // Save phone separately
            System.out.println("Session set: email=" + email + ", name=" + name + ", phone=" + phone);

            // Go to the dashboard page
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            // If something goes wrong, show the error on the registration page
            System.out.println("Registration error: " + e.getMessage());
            request.setAttribute("errorMessage", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "RegisterServlet handles user registration";
    }
}