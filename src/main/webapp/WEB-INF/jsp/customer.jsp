<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>

</head>
<body>
    <h1>Customer Dashboard</h1>
    <p>${username}</p>
    <p>${msg}</p>
    <p>${type}</p>
    <form action="/customer" method="POST">
        Id: <input type="text" name="id"><br>
        Password: <input type="text" name="password"><br>
        <input type="submit" value="Submit">
      </form>
</body>
</html>

    