<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href=".../WEB-INF/style.css" rel="stylesheet" type="text/css">
    <!-- Registration form for new users -->
    <style>
        .error { color: red; }
        table { border-collapse: collapse; width: 50%; }
        td { padding: 10px; }
        input { width: 100%; padding: 5px; }
    </style>
</head>
<body>
    <h1>Register to Wellness Services</h1>
    <div>
    <form action="register" method="post">
        <table border="0">
            <tbody>
                <tr>
                    <td><label for="txtStudentNumber">Student Number:</label></td>
                    <td><input type="text" id="txtStudentNumber" name="txtStudentNumber" value="" size="50" required /></td>
                </tr>
                <tr>
                    <td><label for="txtName">Name:</label></td>
                    <td><input type="text" id="txtName" name="txtName" value="" size="50" required /></td>
                </tr>
                <tr>
                    <td><label for="txtSurname">Surname:</label></td>
                    <td><input type="text" id="txtSurname" name="txtSurname" value="" size="50" required /></td>
                </tr>
                <tr>
                    <td><label for="txtEmail">Email:</label></td>
                    <td><input type="email" id="txtEmail" name="txtEmail" value="" size="50" required placeholder="example@domain.com" /></td>
                </tr>
                <tr>
                    <td><label for="txtPhoneNumber">Phone Number:</label></td>
                    <td><input type="tel" id="txtPhoneNumber" name="txtPhoneNumber" value="" size="50" required pattern="^\d{10}$|^\d{3}-\d{3}-\d{4}$" placeholder="1234567890 or 012-345-6789" /></td>
                </tr>
                <tr>
                    <td><label for="txtPassword">Password:</label></td>
                    <td><input type="password" id="txtPassword" name="txtPassword" value="" size="50" required minlength="8" placeholder="e.g., Koos123A" /></td>
                </tr>
            </tbody>
        </table>
        <br>
        <input type="submit" value="Submit" name="btnSubmit" />
        <input type="reset" value="Clear" name="btnClear" />

        <!-- Show any error messages from the servlet -->
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error"><%= request.getAttribute("errorMessage") %></p>
        <% } %>

        <!-- Provide user feedback and security note -->
        <p>Ensure your password is at least 8 characters with uppercase, lowercase, and a number. Your data is stored securely.</p>
    </form>
    </div>
</body>
</html>