<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="employeeheader.jsp" %>

</head>
<body>
        
    <h1>Clients</h1>
    <form action="/employee/client" method="POST">
        Search by Client ID: <input type="text" name="id">
        <input type="submit" value="Search">
      </form>

    <table>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Dob</td>
            <td>Id</td>
            <td>AccInitDate</td>
            <td>IntId</td>
            <td>Balance</td>
        </tr>
        <c:forEach items="${clients}" var="client">
    <tr>      
        <td>${client.getFirstName()}</td>
        <td>${client.getLastName()}</td>
        <td>${client.getDob()}</td>
        <td>${client.getId()}</td>  
        <td>${client.getAccInitDate()}</td>  
        <td>${client.getIntId()}</td>  
        <td>${client.getBalance()}</td>  

    </tr>
</c:forEach>

    </table> 
</body>
</html>

    