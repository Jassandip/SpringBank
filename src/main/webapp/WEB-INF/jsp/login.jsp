<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>

</head>
<body>
    <h1>login</h1>
    <p>${msg}</p>
    <p>${type}</p>
    <form action="/login" method="POST">
        Id: <input type="text" name="id" id="id"><br>
        Password: <input type="text" name="password" id="id"><br>
        <input type="submit" value="Submit" id="loginSubmit">
      </form>
</body>
</html>

    