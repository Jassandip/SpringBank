<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Welcome to eomployee update page!</title>
    </head>
    <body>
    <h1>Welcome to eomployee update page!</h1>
        <p><p>
              <form action="/employee/update" method="POST">
                First Name: <input type="text" name="firstName" value=${firstName}><br>
                Last Name: <input type="text" name="lastName" value=${lastName}><br>
                Date of Birth: <input type="date" name="dob" value=${dob}><br>
                <input type="submit" value="Submit" required>
              </form>
              </body>
</html>