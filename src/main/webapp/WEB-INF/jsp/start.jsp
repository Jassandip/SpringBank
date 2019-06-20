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
        <p>Would you like to loggin or create a new account?<p>
            <form action="/loggin" method="GET">
                <input type="submit" value="Loggin">
            </form>
            <form action="/signup" method="GET">
                <input type="submit" value="Signup">
            </form>
              </body>
</html>