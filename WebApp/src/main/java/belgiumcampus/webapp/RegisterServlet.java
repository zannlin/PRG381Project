package belgiumcampus.webapp;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;

@WebServlet(name = "registerServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Register Page";
        System.out.println("RegisterServlet started at URL: /register-servlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Redirect to register.jsp
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
