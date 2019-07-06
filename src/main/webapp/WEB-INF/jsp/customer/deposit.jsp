<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="customerheader.jsp" %>

</head>
<body>
        
    <h1>Deposit</h1>
    <p>Current Balance ${user.getBalance()}</p>
    <form action="/customer/deposit" method="POST">
        Amount: <input type="int" name="amount" id="amount">
        <input type="submit" value="Deposit">
      </form>
</body>
</html>

    