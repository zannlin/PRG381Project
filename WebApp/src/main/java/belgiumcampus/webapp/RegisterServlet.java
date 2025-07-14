package belgiumcampus.webapp;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import org.mindrot.jbcrypt.BCrypt;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String studentNumber= request.getParameter("txtStudentNumber");
        String name= request.getParameter("txtName");
        String surname= request.getParameter("txtSurname");
        String email= request.getParameter("txtEmail");
        String phoneNumber= request.getParameter("txtPhoneNumber");
        //hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        //connection

    }

        public void destroy() {
    }
}
