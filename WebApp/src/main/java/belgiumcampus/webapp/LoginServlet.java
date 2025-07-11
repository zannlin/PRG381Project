package belgiumcampus.webapp;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Login Page";
        System.out.println("LoginServlet started at URL: /login-servlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Redirect to login.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
