<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href=".../web/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <h1>Login to Wellness Services</h1>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
    <% } %>
    <div>
    <form action="login" method="POST"> <!-- Updated from "login-servlet" to "login" -->
        <table border="0">
            <tbody>
                <tr>
                    <td>Enter Email:</td>
                    <td><input required type="text" name="txtEmail" value="" size="50" /></td>
                </tr>
                <tr>
                    <td>Enter Password:</td>
                    <td><input required type="password" name="txtPassword" value="" size="50" /></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Login" name="btnLogin" />
    </form>
    </div>
</body>
</html>