<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!--  Login form for existing users -->
</head>
<body>

    <form name="dashboard" action="dashboard.jsp" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td>Email</td>
                    <td><input required type="email" name="txtEmail" size="50" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input required type="password" name="txtPassword" pattern=".{8,}" title="Eight characters minimum." size="50" /></td>
                </tr>
                <tr><td><input type="submit" value="Submit" name="btnSubmit" onclick="confirmToDB"/></td>
                    <td><input type="reset" value="Clear" name="btnClear"/></td>
                </tr>
            </tbody>
        </table>
    </from>
        <button type="button" name="back"><a href="index.jsp">Back</a></button>

</body>
</html>

