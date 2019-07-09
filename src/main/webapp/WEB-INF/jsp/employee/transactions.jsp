<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="employeeheader.jsp" %>

</head>
<body>
        
    <h1>Transactions</h1>
    <form action="/employee/transactions" method="POST">
        Search by Client ID: <input type="text" name="id">
        <input type="submit" value="Search">
      </form>
    <table>
        <tr>
            <td>Id</td>
            <td>From</td>
            <td>To</td>
            <td>Amount</td>
            <td>Date</td>
        </tr>
        <c:forEach items="${transactions}" var="s">
    <tr>      
        <td>${s.getId()}</td>
        <td>${s.getFrom()}</td>
        <td>${s.getTo()}</td>
        <td>${s.getAmount()}</td>  
        <td>${s.getTime()}</td>  
    </tr>
</c:forEach>

    </table> 
</body>
</html>

    