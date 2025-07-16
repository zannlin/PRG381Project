<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
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
      <input type="submit" value="Logout" class="btn primary">
    </form>
  </div>
</div>
</body>
</html>