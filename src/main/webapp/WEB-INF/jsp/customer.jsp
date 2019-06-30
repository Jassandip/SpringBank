<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>

</head>
<body>
    <h1>Customer Dashboard</h1>
    <p>${confirmation}</p>
    <form action="/customer" method="POST">
        Send to: <input type="text" name="id" id="id"><br>
        Amount: <input type="int" name="amount" id="amount"><br>
        <input type="submit" value="Submit">
      </form>
</body>
</html>

    