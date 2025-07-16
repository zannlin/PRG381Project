<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <h1 class="title">Login to Wellness Services</h1>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="error"><%= request.getAttribute("errorMessage") %></p>
    <% } %>
    <div class="form-container">
        <form action="login" method="post">
            <div class="form-group">
                <label for="txtEmail">Email:</label>
                <input type="email" id="txtEmail" name="txtEmail" value="" required class="form-input">
            </div>
            <div class="form-group">
                <label for="txtPassword">Password:</label>
                <input type="password" id="txtPassword" name="txtPassword" value="" required class="form-input">
            </div>
            <div class="button-group">
                <input type="submit" value="Login" name="btnLogin" class="btn primary">
            </div>
        </form>
    </div>
</div>
</body>
</html>