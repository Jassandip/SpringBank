<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>

</head>
<body>
    <h1>Signup</h1>
    <form action="/signup" method="POST">
        First Name: <input type="text" name="firstname"><br>
        Last Name: <input type="text" name="lastname"><br>
        Date of Birth: <input type="date" name="dob"><br>
        Account Type: <select name="type" type="text">
                <option value="client">Client</option>
                <option value="employee">Employee</option>
              </select><br>
        Loggin Id: <input type="text" name="id"><br>
        Loggin Password: <input type="text" name="password"><br>
        <input type="submit" value="Submit">
      </form>
</body>
</html>

    