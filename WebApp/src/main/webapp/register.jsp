<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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
    <h1 class="title">Register to Wellness Services</h1>
    <div class="form-container">
        <form action="register" method="post">
            <div class="form-group">
                <label for="txtStudentNumber">Student Number:</label>
                <input type="text" id="txtStudentNumber" name="txtStudentNumber" value="" required class="form-input">
            </div>
            <div class="form-group">
                <label for="txtName">Name:</label>
                <input type="text" id="txtName" name="txtName" value="" required class="form-input">
            </div>
            <div class="form-group">
                <label for="txtSurname">Surname:</label>
                <input type="text" id="txtSurname" name="txtSurname" value="" required class="form-input">
            </div>
            <div class="form-group">
                <label for="txtEmail">Email:</label>
                <input type="email" id="txtEmail" name="txtEmail" value="" required placeholder="example@domain.com" class="form-input">
            </div>
            <div class="form-group">
                <label for="txtPhoneNumber">Phone Number:</label>
                <input type="tel" id="txtPhoneNumber" name="txtPhoneNumber" value="" required pattern="^\d{10}$|^\d{3}-\d{3}-\d{4}$" placeholder="1234567890 or 012-345-6789" class="form-input">
            </div>
            <div class="form-group">
                <label for="txtPassword">Password:</label>
                <input type="password" id="txtPassword" name="txtPassword" value="" required minlength="8" placeholder="e.g., Koos123A" class="form-input">
            </div>
            <div class="button-group">
                <input type="submit" value="Submit" name="btnSubmit" class="btn" style="background-color: #f5f5f5; color: black;">
                <input type="reset" value="Clear" name="btnClear" class="btn" style="background-color: #f5f5f5; color: black;">
            </div>
            <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error" style="color: white;"><%= request.getAttribute("errorMessage") %></p>
            <% } %>
            <p class="note" style="color: white;">Ensure your password is at least 8 characters with uppercase, lowercase, and a number. Registration successful messages will appear here.</p>
        </form>
    </div>
</div>
</body>
</html>