<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<head>
    <title></title>
    <%@include file="employeeheader.jsp" %>

</head>
<body>
        
    <h1>Employees</h1>
    <form action="/employee/employees" method="POST">
        Search by Employee ID: <input type="text" name="id">
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
        </tr>
        <c:forEach items="${employees}" var="employee">
    <tr>      
        <td>${employee.getFirstName()}</td>
        <td>${employee.getLastName()}</td>
        <td>${employee.getDob()}</td>
        <td>${employee.getId()}</td>  
        <td>${employee.getAccInitDate()}</td>  
        <td>${employee.getIntId()}</td>  

    </tr>
</c:forEach>

    </table> 
</body>
</html>

    