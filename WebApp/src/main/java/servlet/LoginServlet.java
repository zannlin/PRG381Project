package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.ConnectionProvider;
import model.User;

/**
 * This servlet handles user login and logout for the web app.
 * - Login: Checks email and password, logs user in if correct.
 * - Logout: Ends the session and returns to login page.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the URL path to decide what to do
        String path = request.getServletPath();

        if ("/login".equals(path)) {
            // If user goes to /login, show the login page
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if ("/logout".equals(path)) {
            // If user goes to /logout, end the session
            HttpSession session = request.getSession(false); // Get session only if it exists
            if (session != null) {
                session.invalidate(); // Clear the session
            }
            // Go back to the login page
            response.sendRedirect("login.jsp");
        } else {
            // If the path is wrong, show a "not found" error
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response to show HTML
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = request.getServletPath();

        if ("/login".equals(path)) {
            // Get the email and password from the login form
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            // Check if email or password is missing or empty
            if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                request.setAttribute("errorMessage", "Please enter both email and password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return; // Stop here if there's an error
            }

            try {
                // Create a connection to the database
                ConnectionProvider cp = new ConnectionProvider();
                // Check if the email and password are correct
                User user = cp.authenticateUser(email, password);

                if (user != null) {
                    // If login is successful, save user details in the session
                    HttpSession session = request.getSession(); // Create or get the session
                    session.setAttribute("user", user); // Save the whole user object
                    session.setAttribute("email", user.getEmail()); // Save email separately
                    session.setAttribute("name", user.getName()); // Save name separately
                    session.setAttribute("phone", user.getPhone()); // Save phone separately

                    // Go to the dashboard page
                    response.sendRedirect("dashboard.jsp");
                } else {
                    // If login fails, show an error on the login page
                    request.setAttribute("errorMessage", "Email or password is incorrect");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                // If something goes wrong (like database error), show the error
                request.setAttribute("errorMessage", "An error happened: " + e.getMessage());
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "This servlet manages login and logout for users.";
    }
}