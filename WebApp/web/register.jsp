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
                            <td>Enter Student Number:</td>
                            <td><input required type="text" name="txtStudentNumber" pattern="[0-9]{6}" title="Enter six digit student number." size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Name:</td>
                            <td><input required type="text" name="txtName" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Surname:</td>
                            <td><input required type="text" name="txtSurname" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Email:</td>
                            <td><input required type="email" name="txtEmail" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Phone number:</td> <!-- how to format html input -->
                            <td><input required type="tel" name="txtPhoneNumber" pattern="[0-9]{10}" title="Enter 10 digit phone number." size="50" /></td>
                        </tr>
                        <tr>
                            <td>Enter Password:</td> <!-- hash password -->
                            <td><input required type="password" name="txtPassword" pattern=".{8,}" title="Eight characters minimum." size="50" /></td>
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