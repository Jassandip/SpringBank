<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="customerheader.jsp" %>

</head>
<body>
        
    <h1>Send Money</h1>
    <p>${confirmation}</p>
    <form action="/customer/sendmoney" method="POST">
        Send to: <input type="text" name="to" id="to"><br>
        Amount: <input type="int" name="amount" id="amount"><br>
        <input type="submit" value="Send">
      </form>
</body>
</html>

    