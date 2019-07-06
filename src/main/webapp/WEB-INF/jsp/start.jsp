<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Welcome to SpringBank!</title>
    </head>
    <body>
    <h1>Welcome to SpringBank6</h1>
        <p>Would you like to login or create a new account?<p>
            <form action="/login" method="GET">
                <input type="submit" value="login">
            </form>
            <form action="/signup" method="GET">
                <input type="submit" value="Signup">
            </form>
              </body>
</html>