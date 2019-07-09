<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="employeeheader.jsp" %>

</head>
<body>
    <h1>Sign up new accounts here ${user.getFirstName()} ${user.getLastName()}</h1>
    <h1>${registration}</h1>
    <form action="employee/" method="POST">
        First Name: <input type="text" name="firstName" required><br>
        Last Name: <input type="text" name="lastName" required><br>
        Date of Birth: <input type="date" name="dob" required><br>
        Account Type: <select name="type" type="text" required>
                <option value="client">Client</option>
                <option value="employee">Employee</option>
              </select><br>
        login Id: <input type="text" name="id" required><br>
        login Password: <input type="text" name="password" required><br>
        <input type="submit" value="Submit" required>
      </form>
</body>
</html>

    