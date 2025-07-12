<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- Welcome page after login
     Welcome, User! btnLogout (invalidates session)-->
</head>
<body>
    <%
        //get data from database
        String email = request.getParameter("txtEmail");
        String name = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhoneNumber");
    %>
    <h1>Welcome, <%= name %></h1>

    <table border="0">
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

</body>
</html>