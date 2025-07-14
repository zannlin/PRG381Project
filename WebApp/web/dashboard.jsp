<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <!-- Welcome page after login Welcome, User! btnLogout (invalidates session)-->
</head>
<body>
    <%
    String name = request.getParameter("txtName");
    if (name == null || name.trim().isEmpty()) {
        out.println("Hello, Guest!");
    } else {
        out.println("Hello, " + name + "!");
    }
    %>
    <%-- exposes secerts through url link --%>
</body>
</html>