<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <style>
        .btn {
            background-color: #f5f5f5;
        }
        body {
            background-image: url("images/background.jpg");
            background-size: cover;
            margin: 0;
            font-family: sans-serif;
        }
        .container {
            background-color: rgba(34, 34, 34, 0.65);
            padding: 2rem;
            border-radius: 8px;
            width: fit-content;
            margin: 5rem auto;
        }
        .title {
            color: white;
            margin: 0 0 1rem 0;
        }
        .link-container a {
            display: inline-block;
            margin: 0.5rem;
            padding: 0.5rem 1rem;
            background-color: white;
            color: black;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Login to Wellness Services</h1>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="error" style="color: white;"><%= request.getAttribute("errorMessage") %></p>
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
                <input type="submit" value="Login" name="btnLogin" class="btn" style="background-color: #f5f5f5; color: black;">
            </div>
        </form>
    </div>
</div>
</body>
</html>