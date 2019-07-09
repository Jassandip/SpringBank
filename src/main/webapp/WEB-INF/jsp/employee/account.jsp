<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <%@include file="employeeheader.jsp" %>
    </head>
    <body>
    <h1>Account Info</h1>
        <p><p>
              <form action="/employee/account" method="POST">
                First Name: <input type="text" name="firstName" value=${user.getFirstName()}><br>
                Last Name: <input type="text" name="lastName" value=${user.getLastName()}><br>
                Date of Birth: <input type="date" name="dob" value=${user.getDob()}><br>
                <input type="submit" value="Update" required>
              </form>
              </body>
</html>