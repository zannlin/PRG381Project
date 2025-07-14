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
    <form name="dashboard" action="dashboard.jsp" method="GET">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Enter Student Number:</td>
                            <td><input type="text" name="txtStudentNumber" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Name:</td>
                            <td><input type="text" name="txtName" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Surname:</td>
                            <td><input type="text" name="txtSurname" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Email:</td>
                            <td><input type="text" name="txtEmail" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Phone number:</td> <!-- how to format html input -->
                            <td><input type="text" name="txtPhoneNumber" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Password:</td> <!-- format password strength -->
                            <td><input type="password" name="txtPassword" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit" name="btnSubmit" onclick="submitToDB"/></td>
                            <td><input type="reset" value="Clear" name="btnClear" onclick="clearForm"/></td>
                        <tr>
                    </tbody>
                </table>
            <!-- provide user feedback and store securely -->

            </form>
</body>
</html>