<%@page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title></title>

</head>
<body>
    <h1>Employee Dashboard (Currently showing all transactions)</h1>
    <p>${transactions}</p>
    <p>${info}</p>
    <form action="employee/update" method="GET">
        <input type="submit" value="Update">
    </form>
    <form action="employee/transctions" method="GET">
        <input type="submit" value="View Transactions">
    </form>
</body>
</html>

    