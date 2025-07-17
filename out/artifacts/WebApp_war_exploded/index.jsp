<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Wellness Services</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <!-- Home page with links to log in.jsp and register.jsp -->
    <style>
        .btn{
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
    <h1 class="title">Welcome to Wellness Services!</h1>
    <div class="link-container">
        <a href="login.jsp" class="btn primary" style="background-color: #f5f5f5;color:black;">Login</a>
        <a href="register.jsp" class="btn primary" style="background-color: #f5f5f5;color:black;">Register</a>
    </div>
</div>
</body>
</html>
