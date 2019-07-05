<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="customerheader.jsp" %>

</head>
<body>
        
    <h1>Customer Dashboard</h1>
    <p>Welcome ${user.getFirstName()}</p>
    <p>Your balance is ${user.getBalance()}</p>
    
</body>
</html>

    