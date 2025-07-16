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
        //or search in database then accept guest
        out.println("Hello, Guest!");
    } else {
        out.println("Hello, " + name + "!");
    }
    %>
    <form name="login" action="login.jsp" method="POST">
    <input type="submit" value="Logout" name="btnSubmit" onclick="invalidateSession"/>
    </form>
</body>
</html>