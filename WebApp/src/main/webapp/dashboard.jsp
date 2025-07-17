<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
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
    .dashboard-table td {
      color: #e0e0e0; /* Lighter text for better contrast */
    }
    .dashboard-table td:first-child {
      color: #b0bec5; /* Slightly lighter for headers */
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="container">
  <%
    // Get data from session
    String email = (String) session.getAttribute("email");
    String name = (String) session.getAttribute("name");
    String phone = (String) session.getAttribute("phone");

    // Fallback if session attributes are null (for debugging)
    if (email == null || name == null || phone == null) {
      email = "Not set";
      name = "Not set";
      phone = "Not set";
    }
  %>
  <h1 class="title">Welcome, <%= name %>!</h1>
  <div class="dashboard-container">
    <table class="dashboard-table">
      <tbody>
      <tr>
        <td>Email</td>
        <td><%= email %></td>
      </tr>
      <tr>
        <td>Name</td>
        <td><%= name %></td>
      </tr>
      <tr>
        <td>Phone</td>
        <td><%= phone %></td>
      </tr>
      </tbody>
    </table>
    <form action="login?logout" method="get" class="button-group">
      <input type="submit" value="Logout" class="btn" style="background-color: #f5f5f5; color: black;">
    </form>
  </div>
</div>
</body>
</html>