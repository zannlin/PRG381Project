<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- registration form for new users -->
</head>
<body>
    <h1>Register to Wellness Services</h1>
    <form name="dashboard" action="dashboard.jsp" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Enter Email:</td>
                            <td><input type="text" name="txtEmail" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Name:</td>
                            <td><input type="text" name="txtName" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Phone number</td> <!-- how to format html input -->
                            <td><input type="text" name="txtPhoneNumber" value="" size="10" /></td>
                        </tr>
                        <tr>
                            <td>Enter Password</td> <!-- format password strength -->
                            <td><input type="password" name="txtPassword" value="" size="50" /></td>
                        </tr>
                    </tbody>
                </table>

                <input type="submit" value="btnSubmit" name="Submit" />
                <input type="reset" value="btnClear" name="Clear" />

            <!-- provide user feedback and store securely -->
            </form>
</body>
</html>